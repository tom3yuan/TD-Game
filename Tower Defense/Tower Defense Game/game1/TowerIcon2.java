import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TowerIcon2 extends Actor
{
    static boolean hasTower2;
    /**
     * Act - do whatever the Tower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!hasTower2){
            makeTower();
            hasTower2 = true;
        }
    }    

    public TowerIcon2(){
        setImage("tower1.png");
        setLocation(780, 200);
        hasTower2 = false;
        getImage().setTransparency(0);
    }

    public void makeTower(){
        getWorld().addObject(new CopyOfCopyOfTower1(), getX(), getY());
    }
}
