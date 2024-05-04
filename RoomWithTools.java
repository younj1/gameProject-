public class RoomWithTools extends Room {
    
    // Constructor for initializing a room with tools
    public RoomWithTools(int num) {
        super(num); // Calling the constructor of the superclass (Room)
    }

    // Overriding the hasTools method to indicate that this room has tools
    @Override
    public boolean hasTools() {
        return true;
    }
}
