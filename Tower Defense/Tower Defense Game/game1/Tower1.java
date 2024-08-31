import greenfoot.*;
/**
 * Write a description of class Tower1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tower1 extends Draggables
{   
    private int[][] range;
    private boolean isGrabbed;
    private boolean draggable = true;
    private boolean faceable = true;
    private GreenfootImage image = new GreenfootImage("aa12.png");
    private boolean hasRange;
    private range range1;
    String type;
    public Tower1(/*String ty*/){
        image.scale(image.getWidth()/10, image.getHeight()/10);
        setImage(image);
        hasRange = false;
    }

    public void act(){
        setLocation();
    }

    public void setLocation(){
        if(draggable){
            if (Greenfoot.mousePressed(this) && !isGrabbed)
            {
                TowerIcon.hasTower = false;
                isGrabbed = true;
                // the rest of this block will avoid this object being dragged UNDER other objects
                World world = getWorld();
                MouseInfo mi = Greenfoot.getMouseInfo();
                world.removeObject(this);
                world.addObject(this, (int)Math.round(mi.getX()/85.33333)*85+42, (int)Math.round(mi.getY()/85.33333) * 85 + 42);
                return;
            }
            // check for actual dragging of the object
            if ((Greenfoot.mouseDragged(this)) && isGrabbed)
            {
                // follow the mouse
                if(!hasRange){
                    range1 = new range(this, 3);
                    getWorld().addObject(range1, getX(), getY());
                    hasRange = true;
                }
                MouseInfo mi = Greenfoot.getMouseInfo();
                int k = mi.getX()-42;
                int w = mi.getY()-42;
                setLocation((int)Math.round(k/85.33333)*85+42, (int)Math.round(w/85.33333)*85+42);
                return;
            }
            // check for mouse button release
            if (Greenfoot.mouseDragEnded(this) && isGrabbed)
            {
                // release the object
                isGrabbed = false;
                draggable = false;
                if(getY()/85<10&&getX()/85<15&&MyWorld.towerWorld[getY()/85][getX()/85]==null&&MyWorld.coinCount>=50){
                    
                    //check this
                    CreatedTower t = new LongRange(getX()/getImage().getWidth(), getY()/getImage().getHeight());
                    getWorld().addObject(t, getX(), getY());
                    MyWorld.towerWorld[getY()/getImage().getHeight()][getX()/getImage().getWidth()] = t;
                    MyWorld.towerWorld[getY()/85][getX()/85]=t;
                    MyWorld.coinCount-=50;
                    getWorld().removeObject(range1);
                    getWorld().removeObject(this);
                }
                else{
                    getWorld().removeObject(range1);
                    getWorld().removeObject(this);
                }
                return;
            }
        }
    }

    public void createTiles(){
        for(int[] k:range){
            for(int i:k){
                //create range indicator here
            }
        }
    }

}
