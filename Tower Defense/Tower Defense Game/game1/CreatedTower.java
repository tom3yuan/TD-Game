import greenfoot.*; 
/**
 * Write a description of class CreatedTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CreatedTower extends Actor
{
    // instance variables - replace the example below with your own
    
    
    /**
     * Constructor for objects of class CreatedTower
     */
    public CreatedTower(int x, int y)
    {
    }
    
    public void attack(Enemy i, int dmg){
        i.reducehp(dmg);
    }
}
