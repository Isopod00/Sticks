package sticks;

public class Player {

    private Hand RH = new Hand();
    private Hand LH = new Hand();
    private String name;
    
    public Player(String playerName) {
        name = playerName;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean split() {
        if(RH.dead() || LH.dead() && RH.getFingers() > 1 || LH.getFingers() > 1) {
            if(RH.dead()) {
                RH.add(LH.getFingers() / 2);
                LH.add(LH.getFingers() / 2 * -1);
            } else if (LH.dead()) {
                LH.add(RH.getFingers() / 2);
                RH.add(RH.getFingers() / 2 * -1);
            }
            return true;
        } else
            return false;
    }
    
    public boolean dead() {
        if(RH.dead() && LH.dead())
            return false;
        else
            return true;
    }
    
    public String toString() {
        return name + ":\t" + "RH: " + RH.getFingers() + "\t" + LH.getFingers() + "LH: ";
    }
    
}