public class Part{
    private int number = 0;
    public final int LAST_PART = 4;
    public Part(int num)
    {
        number = num;
    }
    public int getNum()
    {
        return number;
    }
    public boolean isLastPart()
    {
        return (number == LAST_PART);
    }
    public boolean isNext(Part inp)
    {
        return (number+1 == inp.getNum());
    }
}
