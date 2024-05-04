public class RoomWithMachinePart extends Room {
    private Part part;
    
    // Constructor for initializing a room with a machine part
    public RoomWithMachinePart(int num, Part part) {
        super(num); // Calling the constructor of the superclass (Room)
        this.part = part;
    }

    // Getter method for retrieving the machine part in the room
    public Part getPart() {
        return part;
    }

    // Method for collecting the machine part by the player
    public Part collectPart(Player player) {
        // Checking if the collected part is the next part in sequence
        if (part.isNext(part)) {
            return part;
        } else {
            return null;
        }
    }

    // Overriding the hasPart method to indicate that this room has a machine part
    @Override
    public boolean hasPart() {
        return true;
    }

    // Method to provide help message specific to this room
    public String help() {
        return("HELP HELP!! room number:" + super.getNumber());
    }
}
