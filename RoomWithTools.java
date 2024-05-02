public class RoomWithTools extends Room {
    // Constructor for RoomWithTools class that takes an integer 'num'
    public RoomWithTools(int num) 
    {
        // Calling the constructor of the superclass Room with 'num'
        super(num); 
    }

// Overriding the hasTools method from the superclass Room
    @Override
    public boolean hasTools() 
    {
        // Always returning true to indicate that the room has tools
        return true;
    }
}
