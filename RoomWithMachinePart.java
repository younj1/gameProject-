// Defining the RoomWithMachinePart class that extends Room
public class RoomWithMachinePart extends Room{
    private Part part;
    
    // Constructor for RoomWithMachinePart class
    public RoomWithMachinePart(int num, Part part)
    {
        super(num);
        this.part = part;
    }

    // Getter method for the machine part in the room
    public Part getPart()
    {
        return part;
    }

    // Method to collect a machine part from the room
    public Part collectPart(Player player)
    {
        if(part.isNext(part))
            return part;
        else
            return null;
    }

    // Overriding the hasPart method from the Room class
    @Override
    public boolean hasPart() 
    {
        return true;
    }

    // Method to provide help message
    public String help()
    {
        return("HELP HELP!! room number:"+super.getNumber());
    }
}