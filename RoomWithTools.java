public class RoomWithTools extends Room{
    public RoomWithTools(int num)
    {
        super(num);
    }
    @Override
    public boolean hasTools() {
        return true;
    }

}