
import greenfoot.*; 
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    // instance variables - replace the example below with your own
    private int hp;
    // add field
    private int delayCount;
    // methods to add
    public int speed;
    private boolean finished1;
    private boolean finished2;
    private boolean finished3;
    private boolean finished4;
    private boolean finished5;
    private boolean finished6;
    private boolean finished7;
    public boolean paused()
    {
        return delayCount > 0;
    }

    public void setDelay(int actCount)
    {
        delayCount = actCount;
    }

    /**
     * Constructor for objects of class Enemy
     */
    public Enemy(int health, int speed1)
    {
        hp = health;
        GreenfootImage image = new GreenfootImage("bad.png");
        image.scale(image.getWidth() - 204, image.getHeight() - 139);
        setImage(image);
        MyWorld.enemyWorld[5][0] = this;
        finished1 = true;
        finished2 = false;
        finished3 = false;
        finished4 = false;
        finished5 = false;
        finished6 = false;
        finished7 = false;
        speed = speed1;
    }

    public void act(){
        if (paused())
        {
            delayCount--;
            return;
        }
        if(finished1){
            move1(getX());
        }
        if(finished2){
            move2(getY());
        }
        if(finished3){
            move3(getX());
        }
        if(finished4){
            move4(getY());
        }
        if(finished5){
            move5(getX());
        }
        if(finished6){
            move6(getY());
        }
        if(finished7){
            move7(getX());
        }
        if(hp<0){
            MyWorld.enemyWorld[getY()/85][getX()/85] = null;
            MyWorld.score+=10;
            MyWorld.coinCount+=10;
            getWorld().removeObject(this);
        }
    }

    public int getPositionInGrid(){
        for(int i = 0; i<MyWorld.enemyWorld.length; i++){
            for (int k = 0; k<MyWorld.enemyWorld[i].length; k++){
                if (this==MyWorld.enemyWorld[i][k]){
                    return i*10+k;
                }
            }
        }
        return 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void reducehp(int dmg){
        hp -= dmg;
    }

    /*public void death(){
    if(hp<=0){
    getWorld().removeObject(this);
    //probably add money or something here
    }
    }*/
    public void move1(int x){
        if (x<213){
            setLocation(x+speed, getY());
            for(int i = 0; i<speed; i++){
                if((x+i+1)%85==0){
                    //might not work, Y isnt measured correctly
                    MyWorld.moveEnemy(getY()/85, getX()/85-1, getY()/85, getX()/85);
                }
            }
            if(x%10==0){
                setDelay(1);
            }
        }
        else{
            finished1 = false;
            finished2 = true;
            setRotation(270);
        }
    }

    public void move2(int y){
        if (getY()>213){
            setLocation(getX(), y-speed);
            //do the below for all of them
            for(int i = 0; i<speed; i++){
                if((y+i+1)%85==0){
                    //might not work, Y isnt measured correctly
                    MyWorld.moveEnemy(getY()/85+1, getX()/85, getY()/85, getX()/85);
                }
            }
            if(y%10==0){
                setDelay(1);
            }
        }
        else{
            finished2 = false;
            finished3 = true;
            setRotation(0);
        }
    }

    public void move3(int x){
        if (x<475){
            setLocation(x+speed, getY());
            for(int i = 0; i<speed; i++){
                if((x+i+1)%85==0){
                    //might not work, Y isnt measured correctly
                    MyWorld.moveEnemy(getY()/85, getX()/85-1, getY()/85, getX()/85);
                }
            }
            if(x%10==0){
                setDelay(1);
            }
        }
        else{
            finished3 = false;
            finished4 = true;
            setRotation(90);
        }
    }

    public void move4(int y){
        if (getY()<550){
            setLocation(getX(), y+speed);
            for(int i = 0; i<speed; i++){
                if((y+i+1)%85==0){
                    //might not work, Y isnt measured correctly
                    MyWorld.moveEnemy(getY()/85-1, getX()/85, getY()/85, getX()/85);
                }
            }
            if(y%10==0){
                setDelay(1);
            }
        }
        else{
            finished4 = false;
            finished5 = true;
            setRotation(0);
        }
    }

    public void move5(int x){
        if (x<810){
            setLocation(x+speed, getY());
            for(int i = 0; i<speed; i++){
                if((x+i+1)%85==0){
                    //might not work, Y isnt measured correctly
                    MyWorld.moveEnemy(getY()/85, getX()/85-1, getY()/85, getX()/85);
                }
            }
            if(x%10==0){
                setDelay(1);
            }
        }
        else{
            finished5 = false;
            finished6 = true;
            setRotation(270);
        }
    }

    public void move6(int y){
        if (getY()>385){
            setLocation(getX(), y-speed);
            for(int i = 0; i<speed; i++){
                if((y+i+1)%85==0){
                    //might not work, Y isnt measured correctly
                    MyWorld.moveEnemy(getY()/85+1, getX()/85, getY()/85, getX()/85);
                }
            }
            if(y%10==0){
                setDelay(1);
            }
        }
        else{
            finished6 = false;
            finished7 = true;
            setRotation(0);
        }
    }

    public void move7(int x){
        if (x<1255){
            setLocation(x+speed, getY());
            for(int i = 0; i<speed; i++){
                if((x+i+1)%85==0){
                    //might not work, Y isnt measured correctly
                    MyWorld.moveEnemy(getY()/85, getX()/85-1, getY()/85, getX()/85);
                }
            }
            if(x%10==0){
                setDelay(1);
            }
        }
        else if (x<1270){
            setLocation(x+speed, getY());
        }
        else{
            finished7 = false;
            MyWorld.life--;
            MyWorld.enemyWorld[getY()/85][getX()/85]=null;
            getWorld().removeObject(this);
        }
    }
}
