import greenfoot.*;
import javax.swing.JOptionPane;
/**
 * Write a description of class PlayLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayLevel extends Actor
{
    // instance variables

    private GreenfootImage image = new GreenfootImage("playlevel.png");
    /**
     * Constructor for objects of class PlayLevel
     */
    public PlayLevel()
    {
        image.scale(image.getWidth()/3, image.getHeight()/3);
        setImage(image);
    }

    public void act(){
        sampleMethod();
    }


    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void sampleMethod()
    {
        if (Greenfoot.mouseClicked(this))
        {
            MyWorld.startedLevel = true;
        }
    }
}
