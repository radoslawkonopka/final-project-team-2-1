import src.abstractfactory.AbstractFactory;
import src.abstractfactory.EnemyFactory;
import src.abstractfactory.TowerFactory;
import src.board.Board;
import src.board.PathGenerator;
import src.board.iterator.CellList;
import src.cell.Cell;
import src.cell.CellComponent;
import src.cell.CellComposite;
import src.cell.enemy.Enemy;
import src.cell.enemy.EnemyPrototype;
import src.cell.enemy.SlowEnemy;
import src.cell.tower.Tower;
import src.cell.tower.WeakTower;

public class Game {
    public static void play(){

        // Creates board and path
        System.out.println("\nCreating The Board");
        var path = PathGenerator.create10by10EasyPath();
      
        Board board = new Board.BoardBuilder().setBoardSize(10, 10).setPathCell(path).build();
        GameGui gamePlay = new GameGui(board);
        
        gamePlay.setxBox(gamePlay.getxCanvas()/board.getRows());
        gamePlay.setyBox(gamePlay.getyCanvas()/board.getColumns());
        AbstractFactory<Enemy> enemyFactory = new EnemyFactory();
//        EnemyPrototype enemy1 = enemyFactory.createProduct("slowenemy",board.getCell(2,1));
//        EnemyPrototype enemy2 = enemyFactory.createProduct("fastenemy",board.getCell(0,0));
        SlowEnemy enemy = new SlowEnemy(board.getPath());
//        AbstractFactory<Tower> towerFactory = new TowerFactory();
//        Tower tower = towerFactory.createProduct("weaktower", board.getCell(2,1), board.getPath().getCellPathIterator());
        gamePlay.drawBoard(board.displayBoard());
//        CellComposite towers = new CellComposite();
//        towers.add(towerFactory.createProduct("weaktower", board.getCell(2,2), board.getPath().getCellPathIterator()));
//        towers.add(towerFactory.createProduct("strongtower", board.getCell(1,9), board.getPath().getCellPathIterator()));
        CellComposite enemies = new CellComposite();
        // enemies.add(new SlowEnemy(board.getPath()));
        // enemies.add(new SlowEnemy(board.getPath()));
        // enemies.add(new SlowEnemy(board.getPath()));
        enemies.add(enemy.clone());
        enemies.add(enemy.clone());
        enemies.add(enemy.clone());
//        towers.add(tower);
        while (true) {
            try {
                for (int i =0; i<enemies.getSubComponents().size(); i++){
                    ((EnemyPrototype)enemies.getChild(i)).move();
                }

                for (var tower : board.getTowerList()) tower.attack();
                
                // System.out.println(enemy.getHealth());
                System.out.println(enemy.toString());
                gamePlay.drawBoard(board.displayBoard());
                Thread.sleep(1000);
                System.out.println("=================================");
                System.out.println("");
                System.out.println("");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        // gamePlay.drawBox(gamePlay.getJPanel(), 1, 1);
    }
}