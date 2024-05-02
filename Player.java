public class Player{
    private int num;
    private Room currentRoom;
    private boolean allToolsCollected;
    private Part lastMachinePartCollected;
    public Player(int num,Room startRoom)
    {
        this.num = num;
        currentRoom = startRoom;
    }
    
    public Part lastMachinePartCollected(){
        return lastMachinePartCollected;
    }
    public Room currentRoom() {
        return currentRoom;
    }
    public boolean hasTools(){
        return allToolsCollected;
    }
    public String move(int dir)
    {
        if(currentRoom.getDoor(dir) == null)
        {
            return("No door in this direction");
        }
        else
        {
            currentRoom = currentRoom.getDoor(dir);
            return(currentRoom.printMessage());
        }
    }
    public String collectPart(){
        if(currentRoom.hasPart()){
            if(((RoomWithMachinePart)currentRoom).getPart().isNext(lastMachinePartCollected)){
                lastMachinePartCollected = ((RoomWithMachinePart)currentRoom).getPart();
                return(
                "You have successfully collected part "
                +lastMachinePartCollected.getNum()+
                ", where "+lastMachinePartCollected.getNum()+
                "is the part number");
            }
            else{
                return("The part in this room is not the next part");
            }
        }
        else{
            return("This room doesn't have a part");
        }
    }

    public String collectTools(){
        if(allToolsCollected)
        return("Tools already collected");

        if(currentRoom.hasTools()){
            allToolsCollected = true;
            return("You successfully collected tools");
        }
        else
        {
            return("Room doesn't have tools");
        }
    }

    public String build(){
        if(lastMachinePartCollected.isLastPart())
        if(allToolsCollected)
        if(currentRoom.isWorkshop())
        {
            return("You Won!!");
        }
        else
        return("You dont have all the parts");
        else
        return("You dont have the tools");
        else
        return("You are not in the workshop");
    }
}