import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class CrabWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrabWorld extends World
{
    
    /**
     * Constructor for objects of class CrabWorld.
     * 
     */
    private static int numWorms = 17;
   
    
    //Get & set for numWorms
    public int getnumWorms(){
        return numWorms;
    }
    public void setnumWorms(int val){
        numWorms = val;
    }
    
    //Constructor
    public CrabWorld()
    {    
        super(560, 560, 1); 
        Crab.setWormsCrab(0);
        Lobster.setLobsterWorms(0);
        Whale.setWhaleWorms(0);
        numWorms = 17;
        spawnAll();
    }
    
    //World act method
    public void act(){
        if (numWorms==0){
            if(Crab.getWormsCrab()>Lobster.getLobsterWorms() && Crab.getWormsCrab()>Whale.getWhaleWorms()){
                showText("You win :D", 250, 250);
                Greenfoot.stop();
            }
            else if(Whale.getWhaleWorms()>Lobster.getLobsterWorms() && Whale.getWhaleWorms()>Crab.getWormsCrab()){
                showText("Whale wins :(", 250, 250);
                Greenfoot.stop();
            }
            else{
                showText("Lobster wins :(", 250, 250);
                Greenfoot.stop();
            }
        }
         
        
        
    }
    
    //Random spawning
    private void spawnAll() {
        Crab crab = new Crab();
        Lobster lobster = new Lobster();
        Whale whale = new Whale();
        addObject(crab, 280, 280);
        addObject(lobster, 30, 520);
        addObject(whale, 30, 30);
        
        for(int i=0;i<numWorms;i++){
            int x = (int)(Math.random()*500)+10;
            int y = (int)(Math.random()*500)+10;

            Worm worm = new Worm(false);
            int random = (int)(Math.random()*8)+1;
            if(random==8)
                worm.setSpecial(true);
                
            
            addObject(worm,x,y);
        }
            
    }
    
}
