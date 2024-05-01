public class RoomWithMachinePart extends Room{
    private Part part;
    
    public RoomWithMachinePart(int num, Part part)
    {
        super(num);
        this.part = part;
    }
    public Part getPart()
    {
        return part;
    }
    public Part collectPart(Player player)
    {
        if(part.isNext(part))
            return part;
        else
            return null;
    }

    @Override
    public boolean hasPart() 
    {
        return true;
    }

    public String help()
    {
        return("HELP HELP!! room number:"+super.getNumber());
    }
}