package sticks;

public class Player {

    private Hand RH;
    private Hand LH;
    private String name;

    /* Player Class
       creates two Hand objects that act as a single player
     */
    public Player(String playerName) {
        name = playerName;
        RH = new Hand();
        LH = new Hand();
    }

    // Returns the right hand
    public Hand getRH() {
        return RH;
    }

    // Returns the left hand
    public Hand getLH() {
        return LH;
    }

    // returns player name
    public String getName() {
        return name;
    }

    // returns true and adds when conditions are met, false otherwise
    public boolean add(int add, Hand hand) {
        if (hand.getFingers() > 0) {
            hand.addFingers(add);
            return true;
        }
        return false;
    }

    // returns true if the hands can properly split, false otherwise
    public boolean split() {
        if ((RH.dead() || LH.dead()) && (RH.getFingers() > 1 || LH.getFingers() > 1)) {
            if (RH.dead()) {
                RH.addFingers(LH.getFingers() / 2);
                LH.addFingers(LH.getFingers() / 2 * -1);
            } else if (LH.dead()) {
                LH.addFingers(RH.getFingers() / 2);
                RH.addFingers(RH.getFingers() / 2 * -1);
            }
            return true;
        } else {
            return false;
        }
    }

    // returns true if both hands are dead, false otherwise
    public boolean dead() {
        if (RH.dead() && LH.dead()) {
            return true;
        }
        return false;
    }

    // returns a string containing the left and right finger amounts
    public String toString() {
        return name + ":\n\t\t" + "LH: " + LH.getFingers() + "   RH: " + RH.getFingers() + "\t";
    }
}
