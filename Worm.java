import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Worm here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Worm extends Actor
{
    private boolean special;
    
    public boolean isSpecial(){
        return special;
    }
    
    //get & set for specialWorm
    public void setSpecial(boolean val){
        special = val;
    }
    
    public Worm(boolean special){
        this.special = special;
    }
    
    //Worm act
    public void act()
    {
        //Worm movement
        
        //Special case
        if(special){
            
            int randomMove = (int)(Math.random()*4)+1;
            
            //25% chance of rotating
            if (randomMove==1){
            
                if (getX() <= 5 || getX() >= getWorld().getWidth() - 5 ||
                    getY() <= 5 || getY() >= getWorld().getHeight() - 5) {
                    turn(180 + (int)(Math.random()*90) - 45);
                    setImage("wormr.png");

                }
            }
            move(1);
            clamp();
        }
        
        //Normal Worm case
        else{
            move(1);
            if (getX() <= 5) {
                turn(180);
                setImage("worm.png");
            }
            if (getX() >= getWorld().getWidth() - 5){
                turn(180);
                setImage("wormr.png");
            }
        }// Add your action code here.
    }
    
    //Checking if the worm is in the right place, to avoid worms getting stuck in corners
    private void clamp() {
        setLocation(Math.min(getWorld().getWidth() - 5, Math.max(5, getX())),
                   Math.min(getWorld().getHeight() - 5, Math.max(5, getY())));
    }
    
}
