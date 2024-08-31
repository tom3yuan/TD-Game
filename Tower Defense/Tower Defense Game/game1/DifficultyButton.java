import greenfoot.*;
import javax.swing.JOptionPane;
/**
 * Write a description of class DifficultyButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DifficultyButton extends Actor
{
    // instance variables

    private GreenfootImage image = new GreenfootImage("spawnratebutton.png");
    /**
     * Constructor for objects of class DifficultyButton
     */
    public DifficultyButton()
    {
        image.scale(image.getWidth()/3, image.getHeight()/3);
        setImage(image);
    }

    public void act(){
        sampleMethod();
    }

    public boolean onlyDigits(String str)
    {
        // Traverse the string from
        // start to end
        for (int i = 0; i < str.length(); i++) {

            // Check if character is
            // not a digit between 0-9
            // then return false
            if (str.charAt(i) < '0'
            || str.charAt(i) > '9') {
                return false;
            }
        }
        // If we reach here, that means
        // all characters were digits.
        return true;
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
            String inputValue = JOptionPane.showInputDialog("Please Input Spawn Rate (60 is Fastest, 200 is Slowest)");
            if(inputValue!=null&&onlyDigits(inputValue)){
                if(Integer.parseInt(inputValue)>=60){
                    MyWorld.enemySpawnDelay=Integer.parseInt(inputValue);
                }
            }
        }
    }
}
