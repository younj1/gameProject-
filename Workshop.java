public class Workshop extends Room{
    public Workshop(int num)
    {
        super(num);
    }
    @Override
    public boolean isWorkshop() {
        return true;
    }

}