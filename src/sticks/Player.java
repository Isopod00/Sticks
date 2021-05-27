package sticks;

public class Player {

    private Hand RH = new Hand();
    private Hand LH = new Hand();
    private String name;
    
    public Player(String playerName) {
        name = playerName;
    }
    
    public void split() {
        
    }
    
    public boolean dead() {
        if(RH.dead() && LH.dead())
            return false;
        else
            return true;
    }
    
}