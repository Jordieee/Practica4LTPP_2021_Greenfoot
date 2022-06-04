import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Whale here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Whale extends Actor
{
    private static int whaleWorms = 0;
    
    //get & set for wormswhale
    public static int getWhaleWorms(){
        return whaleWorms;
    }
    
    public static void setWhaleWorms(int val){
        whaleWorms = val;
    }
    
    //Initial reference value to control whale's size
    private int whaleSize = 25;
    
    public void act()
    {
        //Whale Movement
        move(2);
        getWorld().showText("Whale: " + whaleWorms, 492, 47);
        if (Greenfoot.getRandomNumber(100) < 5)
            turn(Greenfoot.getRandomNumber(90)-45);
        if (getX() <= 5 || getX() >= getWorld().getWidth() - 5)
            turn(180);
        if (getY() <= 5 || getY() >= getWorld().getHeight() - 5)
            turn(180);
        
        //Whale eats a Worm
        Worm worm = (Worm)getOneObjectAtOffset(0, 0, Worm.class);
        
        //Changing the whale's image per worms eaten
        if (worm != null) {
            whaleWorms++;
            getWorld().removeObject(worm);
            ((CrabWorld)getWorld()).setnumWorms(((CrabWorld)getWorld()).getnumWorms()-1); 
            Greenfoot.playSound("eating.wav");
            setImage("whale_big.png");
            getImage().scale(getImage().getWidth()*whaleSize/100, getImage().getHeight()*whaleSize/100);
            whaleSize+=3;
        }
        
        //Whale eats the crab
        Crab crab = (Crab)getOneObjectAtOffset(0, 0, Crab.class);
        if (crab != null) {
            getWorld().removeObject(crab);
            Greenfoot.playSound("die.mp3");
            Greenfoot.stop();
            getWorld().showText("Whale ate you :(", 250, 250);
        }
        
        //Whale eats the lobster
        Lobster lobster = (Lobster)getOneObjectAtOffset(0, 0, Lobster.class);
        if (lobster != null) {
            getWorld().removeObject(lobster);
            Greenfoot.playSound("die.mp3");
            setImage("whale_big.png");
            getImage().scale(getImage().getWidth()*whaleSize/100, getImage().getHeight()*whaleSize/100);
            whaleSize+=3;
        }
    }
}
