package src.cell.enemy;
/**
 * This class implements enemy.
 * Used for decorator pattern to modify enemy attributes
 */
public abstract class EnemyDecorator extends EnemyPrototype{
   protected final EnemyPrototype decoratedEnemy;

   public EnemyDecorator(EnemyPrototype decoratedEnemy){
        super(decoratedEnemy.getPosition());
        this.decoratedEnemy = decoratedEnemy;
    }

   /* Returns health*/
   @Override
    public double getHealth(){
        return decoratedEnemy.health;
    };

    /* Returns speed*/
    @Override
    public double getSpeed(){
        return this.decoratedEnemy.getSpeed();
    };

    /* sets the attack speed 
    * @param newSpeed is used to replace previous enemy speed value
    */
    public void setSpeed(double newSpeed){
        this.decoratedEnemy.setSpeed(newSpeed);
    }
    /**
     * Draws enemy according to its type
     */
    @Override
    public void draw() {
        this.decoratedEnemy.draw();
    }

    @Override
    /* sets the health of enemy
    * @param newHealth is used to replace health
    */
    public void setHealth(double newHealth){
         this.decoratedEnemy.setHealth(newHealth);
    };

    /**
    * Returns hash code
    */
    public int hashCode(){
        return this.decoratedEnemy.hashCode();
    }
    
    /**
    * Compare objects based on damage, range, and speed
    * @param Object to compare
    */
    public boolean equals(Object other){
        return this.decoratedEnemy.equals(other);
    }

    /**
     * This method will allow the object to move from current cell to another
     */
    public void move(){
        this.decoratedEnemy.move();
    }

}