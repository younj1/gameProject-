public class Workshop extends Room {
    
    // Constructor for initializing a workshop room
    public Workshop(int num) {
        super(num); // Calling the constructor of the superclass (Room)
    }

    // Overriding the isWorkshop method to indicate that this room is a workshop
    @Override
    public boolean isWorkshop() {
        return true;
    }
}
