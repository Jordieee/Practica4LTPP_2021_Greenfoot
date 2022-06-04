import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lobster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lobster extends Actor
{
    /**
     * Act - do whatever the Lobster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static int lobsterWorms = 0;
    
    //get & set for wormsLobster
    public static int getLobsterWorms(){
        return lobsterWorms;
    }
    
    public static void setLobsterWorms(int val){
        lobsterWorms = val;
    }
    
    //Lobster act
    public void act() {
        move(4);
        getWorld().showText("Lobster: " + lobsterWorms, 500, 30);
        if (Greenfoot.getRandomNumber(100) < 10)
            turn(Greenfoot.getRandomNumber(90)-45);
        if (getX() <= 5 || getX() >= getWorld().getWidth() - 5)
            turn(180);
        if (getY() <= 5 || getY() >= getWorld().getHeight() - 5)
            turn(180);
        
        //Lobster eats a worm
        Worm worm = (Worm)getOneObjectAtOffset(0, 0, Worm.class);
        if (worm != null) {
            lobsterWorms++;
            getWorld().removeObject(worm);
            ((CrabWorld)getWorld()).setnumWorms(((CrabWorld)getWorld()).getnumWorms()-1); 
            Greenfoot.playSound("eating.wav");
        }
        
        //Lobster eats the crab
        Crab crab = (Crab)getOneObjectAtOffset(0, 0, Crab.class);
        if (crab != null) {
            getWorld().removeObject(crab);
            Greenfoot.playSound("die.mp3");
            getWorld().showText("Lobster ate you :(", 250, 250);
            Greenfoot.stop();
        }
    }
    
}
