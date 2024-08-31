import greenfoot.*;

/**
 * Write a description of class range here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class range extends Actor
{
    // instance variables - replace the example below with your own
    private int x;

    private GreenfootImage image = new GreenfootImage("range.png");
    private Draggables m;
    /**
     * Constructor for objects of class range
     */
    public range(Draggables k, int side)
    {
        image.scale(86*side, 86*side);
        image.setTransparency(150);
        setImage(image);
        m = k;
    }
    public void act(){
        setLocation(m.getX(), m.getY());
    }
        
}
