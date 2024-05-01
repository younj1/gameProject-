public class Part {
    // Private variable to store the number of the part
    private int number = 0;
    
    // Constant representing the last part number
    public final int LAST_PART = 4;
    
    // Constructor to initialize the Part with a number
    public Part(int num) {
        number = num;
    }
    
    // Method to get the number of the Part
    public int getNum() {
        return number;
    }
    
    // Method to check if the Part is the last part
    public boolean isLastPart() {
        // Returns true if the number of the Part is equal to the last part number
        return (number == LAST_PART);
    }
    
    // Method to check if the given part is the next part after this Part
    public boolean isNext(Part inp) {
        // Returns true if the number of the given Part is one more than the number of this Part
        return (number + 1 == inp.getNum());
    }
    
}
