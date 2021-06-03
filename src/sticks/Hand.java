package sticks;

public class Hand {

    private int fingers;

    /**
     * Hand Class *******************************************************
     * creates a Hand object that has the number of fingers stored.
     */
    public Hand() {
        fingers = 1;
    }

    // returns the number of fingers not folded down
    public int getFingers() {
        return fingers;
    }

    // adds more fingers after player makes their move and returns the new value of fingers
    public boolean add(int add) {
        if (fingers > 0) {
            fingers += add;
            return true;
        } else {
            return false;
        }
    }

    public void addSplit(int add) {
        fingers += add;
    }

    // retuns the state of the hand
    public boolean dead() {
        if (fingers > 0 && fingers < 5) {
            return false;
        } else {
            return true;
        }
    }
}
