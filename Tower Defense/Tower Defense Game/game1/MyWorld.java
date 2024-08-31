import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{   
    static CreatedTower[][] towerWorld;
    static Enemy[][] enemyWorld;
    private int delayCount;
    static int enemySpawnDelay;
    static boolean hasTower1 = false;
    static int score;
    static int coinCount;
    static int life;
    public static boolean startedLevel;
    private boolean firstAction;
    private boolean secondAction;
    private boolean thirdAction;
    private int enemySpeed;
    public static int enemyHealth;
    private int count1;
    private int count2; 
    private int count3;
    private int delayCount1;
    static int enemySpawnDelay1;
    static boolean onGoingGame;
    private GreenfootSound music = new GreenfootSound("music.mp3");
    //TO DO:
    //ADD OTHER TOWERS
    //LOOK FOR BUGS
    public boolean paused()
    {
        return delayCount > 0;
    }

    public void setDelay(int actCount)
    {
        delayCount = actCount;
    }

    public boolean paused1()
    {
        return delayCount1 > 0;
    }

    public void setDelay1(int actCount1)
    {
        delayCount1 = actCount1;
    }

    public void started(){
        music.playLoop();
        coinCount = 500;
        TowerIcon.hasTower = false;
        TowerIcon1.hasTower1 = false;
        TowerIcon2.hasTower2 = false;
        score = 0;
        life = 100;
        enemySpeed = 2;
        enemyHealth = 50;
    }

    public void stopped(){
        TowerIcon.hasTower = false;
        TowerIcon1.hasTower1 = false;
        TowerIcon2.hasTower2 = false;
    }

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public void act(){
        if(Greenfoot.isKeyDown("m")){
            score = 0;
            coinCount = 0;
            enemySpeed = 2;
            TowerIcon.hasTower = false;
            TowerIcon1.hasTower1 = false;
            TowerIcon2.hasTower2 = false;
            for(int i = 0; i<towerWorld.length; i++){
                for(int k = 0; k<towerWorld[0].length; k++){
                    if(towerWorld[i][k]!=null){
                        removeObject(towerWorld[i][k]);
                        towerWorld[i][k]=null;
                    }
                }
            }
            for(int i = 0; i<enemyWorld.length; i++){
                for(int k = 0; k<enemyWorld[0].length; k++){
                    if(enemyWorld[i][k]!=null){
                        removeObject(enemyWorld[i][k]);
                        enemyWorld[i][k]=null;
                    }
                }
            }
        }
        showText("Score:  "+ score, 1000, 85);
        showText("Coin Amount:  "+ coinCount, 1000, 170);
        showText("Life Remaining:  "+ life, 1000, 255);
        if(startedLevel){
            startLevel();
            startedLevel = false;
        }
        if (paused())
        {
            delayCount--;
            return;
        }
        if (paused1())
        {
            delayCount1--;
            return;
        }
        if(firstAction){
            enemySpeed = 2;
            enemyHealth = 50;
            if(count1>0){
                count1--;
            }
            else{
                secondAction = true;
                firstAction = false;
            }
        }
        if(secondAction){
            enemySpeed = 1;
            enemyHealth = 70;
            enemySpawnDelay = 100;
            if(count2>0){
                count2--;
            }
            else{
                thirdAction = true;
                secondAction = false;
                setDelay1(1000);
                onGoingGame = false;
                return;
            }
        }
        if(thirdAction){
            enemySpeed = 7;
            enemyHealth = 30;
            enemySpawnDelay = 30;
            if(count3>0){
                count3--;
            }
            else{
                thirdAction = false;
                enemySpeed = 2;
                enemyHealth = 50;
                enemySpawnDelay = 150;
                //change score and money here
                coinCount = 1000;
                life = 1000;
                //score = 0;
            }

        }
        createEnemy(enemySpeed, enemyHealth);
        setDelay(enemySpawnDelay);
    }

    public MyWorld()
    {    
        //each grid is 85.3333x85.3333
        // Create a new world with 1280x860 cells with a cell size of 1x1 pixels.
        super(1280, 853, 1); 
        GreenfootImage image = new GreenfootImage("map1.png");
        image.scale(image.getWidth() + 680, image.getHeight() + 453);
        setBackground(image);
        coinCount = 1000;
        score = 0;
        life = 1000;
        firstAction = false;
        secondAction = false;
        thirdAction = false;
        enemyHealth = 500;
        enemySpeed = 2;
        count1 = 10;
        count2 = 30;
        count3 = 20;

        TowerIcon k = new TowerIcon();
        addObject(k, 1190, 85);

        TowerIcon1 m = new TowerIcon1();
        addObject(m, 1190, 170);

        TowerIcon2 c = new TowerIcon2();
        addObject(c, 1190, 255);
        score = 0;
        addObject(new DifficultyButton(), 1100, 500);

        addObject(new PlayLevel(), 1100, 600);
        addObject(new CopyOfDifficultyButton(), 1100, 700);
        enemySpawnDelay = 150;
        enemyWorld = new Enemy[10][15];
        towerWorld = new CreatedTower[10][15];
        towerWorld[5][0] = new CreatedTower(0, 0);
        towerWorld[5][1] = new CreatedTower(0, 0);
        towerWorld[5][2] = new CreatedTower(0, 0);
        towerWorld[4][2] = new CreatedTower(0, 0);
        towerWorld[3][2] = new CreatedTower(0, 0);
        towerWorld[2][2] = new CreatedTower(0, 0);
        towerWorld[2][3] = new CreatedTower(0, 0);
        towerWorld[2][4] = new CreatedTower(0, 0);
        towerWorld[2][5] = new CreatedTower(0, 0);
        towerWorld[3][5] = new CreatedTower(0, 0);
        towerWorld[4][5] = new CreatedTower(0, 0);
        towerWorld[5][5] = new CreatedTower(0, 0);
        towerWorld[6][5] = new CreatedTower(0, 0);
        towerWorld[6][6] = new CreatedTower(0, 0);
        towerWorld[6][7] = new CreatedTower(0, 0);
        towerWorld[7][7] = new CreatedTower(0, 0);
        towerWorld[7][8] = new CreatedTower(0, 0);
        towerWorld[7][9] = new CreatedTower(0, 0);
        towerWorld[6][9] = new CreatedTower(0, 0);
        towerWorld[5][9] = new CreatedTower(0, 0);
        towerWorld[5][10] = new CreatedTower(0, 0);
        towerWorld[5][11] = new CreatedTower(0, 0);
        towerWorld[5][12] = new CreatedTower(0, 0);
        towerWorld[5][13] = new CreatedTower(0, 0);
        towerWorld[5][14] = new CreatedTower(0, 0);
    }

    public void createEnemy(int speed, int health){
        Integer t = new Integer(speed);
        Integer m = new Integer(health);
        Enemy k = new Enemy(m, t);
        enemyWorld[5][0] = k;
        addObject(k, 0, 468);
    }

    public void startLevel(){
        onGoingGame = true;
        coinCount = 100;
        TowerIcon.hasTower = false;
        TowerIcon1.hasTower1 = false;
        TowerIcon2.hasTower2 = false;
        score = 0;
        life = 50;
        count1 = 10;
        count2 = 30;
        count3 = 20;
        enemySpeed = 2;
        for(int i = 0; i<towerWorld.length; i++){
            for(int k = 0; k<towerWorld[0].length; k++){
                if(towerWorld[i][k]!=null){
                    removeObject(towerWorld[i][k]);
                    towerWorld[i][k]=null;
                }
            }
        }
        for(int i = 0; i<enemyWorld.length; i++){
            for(int k = 0; k<enemyWorld[0].length; k++){
                if(enemyWorld[i][k]!=null){
                    removeObject(enemyWorld[i][k]);
                    enemyWorld[i][k]=null;
                }
            }
        }
        firstAction = true;
        setDelay(200);
    }

    public static void moveEnemy(int fromrow, int fromcol, int torow, int tocol){

        enemyWorld[torow][tocol] = enemyWorld[fromrow][fromcol];

        enemyWorld[fromrow][fromcol] = null;
    }

    public static Enemy getEnemyAt(int row, int col){
        return enemyWorld[row][col];
    }

    public static void printEnemyWorld(){
        for (Enemy[] w:enemyWorld){
            for(Enemy k: w){
                if(k==null){
                    System.out.print("null");
                }
                else{
                    System.out.print("occupied");
                }
            }
            System.out.println();
        }
    }
}
