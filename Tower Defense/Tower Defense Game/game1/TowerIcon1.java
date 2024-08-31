import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TowerIcon1 extends Actor
{
    static boolean hasTower1;
    /**
     * Act - do whatever the Tower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!hasTower1){
            makeTower();
            hasTower1 = true;
        }
    }    

    public TowerIcon1(){
        setImage("tower1.png");
        setLocation(780, 200);
        hasTower1 = false;
        getImage().setTransparency(0);
    }

    public void makeTower(){
        getWorld().addObject(new CopyOfTower1(), getX(), getY());
    }
}
