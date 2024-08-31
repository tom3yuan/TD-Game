import greenfoot.*;
import java.util.*;
/**
 * Write a description of class tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Draggables extends Actor
{
    private boolean mseBtnDown;
    private int mseX;
    private int mseY;
    // instance variables - replace the example below with your own
    private String type;

    /**
     * Constructor for objects of class tower
     */
    public Draggables()
    {
        
    }

    public void placeTower(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        // updatting button state
        if (!mseBtnDown && Greenfoot.mousePressed(null)) mseBtnDown = true;
        if (mseBtnDown && Greenfoot.mouseClicked(null)) mseBtnDown = false;
        // for button down state
        if (mseBtnDown)
        {
            // updating mouse position
            if (mouse != null)
            {
                mseX = mouse.getX();
                mseY = mouse.getY();
            }
            // moving
            turnTowards(mseX, mseY);
            move(3);
            setRotation(0);
        }
    }

    
}
