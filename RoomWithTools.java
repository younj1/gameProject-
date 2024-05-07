// Defining the RoomWithTools class that extends Room
public class RoomWithTools extends Room{
    // Constructor for RoomWithTools class
    public RoomWithTools(int num)
    {
        super(num);
    }
    // Overriding the hasTools method from the Room class
    @Override
    public boolean hasTools() {
        return true;
    }

}