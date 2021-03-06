package sticks;

public class Hand {

    private int fingers;

    /* Hand Class
       creates a Hand object that has the number of fingers stored.
     */
    public Hand() {
        fingers = 1;
    }

    // returns the number of fingers not folded down
    public int getFingers() {
        return fingers;
    }

    // adds more fingers to a hand object
    public void addFingers(int add) {
        fingers += add;
    }

    // returns true and adds when conditions are met, false otherwise
    public boolean add(int add) {
        if (fingers > 0) {
            addFingers(add);
            return true;
        }
        return false;
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
