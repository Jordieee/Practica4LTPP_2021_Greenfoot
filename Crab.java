import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Crab extends Actor 
{
    /**
     * Act - do whatever the Crab wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static int wormsCrab = 0;
    
    //get & set for wormscrab
    public static int getWormsCrab(){
        return wormsCrab;
    }
    
    public static void setWormsCrab(int val){
        wormsCrab = val;
    }
    
    //Crab act
    public void act() {
        getWorld().showText(null, getX(), getY()); // Limpiamos el texto
        move(4);
        getWorld().showText("Crab: " + wormsCrab, 487, 15);
        
        if (Greenfoot.isKeyDown("left")) turn(-3);
        if (Greenfoot.isKeyDown("right")) turn(3);
        Worm worm = (Worm)getOneObjectAtOffset(0, 0, Worm.class);
        if (worm != null) {
            wormsCrab++;
            getWorld().removeObject(worm);
            ((CrabWorld)getWorld()).setnumWorms(((CrabWorld)getWorld()).getnumWorms()-1); 
            Greenfoot.playSound("eating.wav");
        }
        
        
    } 
    
    
    
}
