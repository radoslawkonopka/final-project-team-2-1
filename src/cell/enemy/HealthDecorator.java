package src.cell.enemy;
/**
 * This class extends EnemyDecorator and is used 
 * for specifically modifying enemy health.
 */
public class HealthDecorator extends EnemyDecorator {

   private double healthIncrease;

   /**
    * Creates new Enemy with modified life
    * @param Modified Enemy
    * @param modifier ratio
    */
   public HealthDecorator(EnemyPrototype decoratedEnemy, double healthIncrease) {
      super(decoratedEnemy);
      this.healthIncrease = healthIncrease;
   }

   /** This method will be used to clone/create copies of enemy objects 
    * @return new HealthDecorator with the same attributes values
   */
   @Override
   public HealthDecorator clone(){
      return new HealthDecorator(decoratedEnemy.clone(), this.healthIncrease);
   }

   /* This method will return health with increase life points */
   @Override
   public double getHealth(){
      return healthIncrease * this.decoratedEnemy.getHealth();
   }
   
}