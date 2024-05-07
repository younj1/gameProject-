// Defining the Workshop class that extends Room
public class Workshop extends Room{
    // Constructor for Workshop class
    public Workshop(int num)
    {
        super(num);
    }
    // Overriding the isWorkshop method from the Room class
    @Override
    public boolean isWorkshop() {
        return true;
    }

}