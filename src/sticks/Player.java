package sticks;

public class Player {

    private Hand RH;
    private Hand LH;
    private String name;

    public Player(String playerName) {
        name = playerName;
        RH = new Hand();
        LH = new Hand();
    }

    public Hand getRH() {
        return RH;
    }

    public Hand getLH() {
        return LH;
    }

    public String getName() {
        return name;
    }

    public boolean split() {
        if (RH.dead() || LH.dead() && RH.getFingers() > 1 || LH.getFingers() > 1) {
            if (RH.dead()) {
                RH.add(LH.getFingers() / 2);
                LH.add(LH.getFingers() / 2 * -1);
            } else if (LH.dead()) {
                LH.add(RH.getFingers() / 2);
                RH.add(RH.getFingers() / 2 * -1);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean dead() {
        if (RH.dead() && LH.dead()) {
            return true;
        }
        return false;
    }

    public String toString() {
        return name + ":\n\t\t" + "LH: " + LH.getFingers() + " RH: " + RH.getFingers() + "\t";
    }
}
