public class RoomWithMachinePart extends Room {
    // Declaring a private variable named 'part' of type Part
    private Part part; 

    // Constructor for RoomWithMachinePart class that takes an integer 'num' and a Part 'part'
    public RoomWithMachinePart(int num, Part part) 
    {
        // Calling the constructor of the superclass Room with 'num'
        super(num); 
        // Assigning the 'part' parameter to the 'part' variable of this class
        this.part = part; 
    }

    // Method to get the 'part' attribute of the room
    public Part getPart() 
    {
        // Returning the 'part'
        return part; 
    }

 // Method to collect a part by a player
    public Part collectPart(Player player)
    {
        // Checking if the 'part' is the next part to collect
        if (part.isNext(part)) 
        // Returning the 'part' if it is the next part
            return part; 
        else
        // Returning null if it's not the next part
            return null; 
    }

// Overriding the hasPart method from the superclass Room
    @Override
    public boolean hasPart() 
    {
        // Always returning true to indicate that the room has a part
        return true; 
    }

// Method to provide help information
    public String help() 
    {
        // Returning a help message with the room number
        return "HELP HELP!! room number: " + super.getNumber(); 
    }
}
