import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TowerIcon extends Actor
{
    static boolean hasTower;
    /**
     * Act - do whatever the Tower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!hasTower){
            makeTower();
            hasTower = true;
        }
    }    

    public void started(){
        hasTower = false;
    }

    public void stopped(){
        hasTower = false;
    }

    public TowerIcon(){
        setImage("tower1.png");
        setLocation(780, 200);
        getImage().setTransparency(0);
        hasTower = false;
    }

    public void makeTower(){
        if (hasTower == false){
            getWorld().addObject(new Tower1(), getX(), getY());
        }
    }
}
