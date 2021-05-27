package sticks;

public class Hand {
    
    private int fingers;

    /** Hand Class *******************************************************
     * class creates a Hand object that has the number of fingers stored.
     */
    public Hand() {
        fingers = 1;
    }
    
    // returns the number of fingers not folded down
    public int getFingers() {
        return fingers;
    }
    
    // adds more fingers after player makes their move and returns the new value of fingers
    public int add(int add) {
        fingers += add;
        return fingers;
    }
    
    // retuns the state of the hand
    public boolean dead() {
        if(fingers > 0 && fingers <= 5)
            return false;
        else
            return true;
    }
    
}