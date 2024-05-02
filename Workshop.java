public class Workshop extends Room {
    public Workshop(int num) // Constructor for Workshop class that takes an integer 'num'
    {
        super(num); // Calling the constructor of the superclass Room with 'num'
    }

    @Override
    public boolean isWorkshop() // Overriding the isWorkshop method from the superclass Room
    {
        return true; // Always returning true to indicate that the room is a workshop
    }
}
