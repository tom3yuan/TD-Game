import greenfoot.*;
/**
 * Write a description of class ShortRange here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShortRange extends CreatedTower
{
    private GreenfootImage image = new GreenfootImage("machinegun.png");
    private GreenfootImage image1 = new GreenfootImage("machinegunfire.png");
    private int delayCount;
    private int delayCount1;
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

    /**
     * Constructor for objects of class ShortRange
     */
    public ShortRange(int x, int y)
    {
        super(x, y);
        image.scale(image.getWidth()/10, image.getHeight()/10);
        image1.scale(image1.getWidth()/10, image1.getHeight()/10);
        setImage(image);
    }

    public void act(){
        if(Greenfoot.mousePressed(this)){
            MyWorld.coinCount+=38;
            MyWorld.towerWorld[getY()/85][getX()/85] = null;
            getWorld().removeObject(this);
            return;
        }
        if (paused1())
        {
            delayCount1--;
            return;
        }
        setImage(image);
        if (paused())
        {
            delayCount--;
            return;
        }
        detect();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void detect(){
        for(int t = getX()/85+2; t>=getX()/85-2; t--){
            for(int k = getY()/85+2; k>=getY()/85-2; k--){
                if(t>=0 && t<15 && k>=0 && k<10){
                    if (getY()/85<10&&getX()/85<15&&MyWorld.enemyWorld[k][t] != null){
                        if (MyWorld.enemyWorld[k][t].getWorld() != null){
                            turnTowards(MyWorld.enemyWorld[k][t].getX(), MyWorld.enemyWorld[k][t].getY());
                        }
                        attack(MyWorld.enemyWorld[k][t], 4);
                        setImage(image1);
                        setDelay(10);
                        setDelay1(2);
                        return;
                    }
                }
            }
        }
    }
}
