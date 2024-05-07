// Defining the Player class
public class Player{
    private int num;
    private Room currentRoom;
    private boolean allToolsCollected;
    private Part lastMachinePartCollected;

    // Constructor for Player class
    public Player(int num,Room startRoom)
    {
        this.num = num;
        currentRoom = startRoom;
    }

    // Getter method for player number
    public int getNum() {
        return num;
    }
    
    // Getter method for the last machine part collected
    public Part lastMachinePartCollected(){
        return lastMachinePartCollected;
    }

    // Getter method for the current room of the player
    public Room currentRoom() {
        return currentRoom;
    }

    // Method to check if the player has tools
    public boolean hasTools(){
        return allToolsCollected;
    }

    // Method for player movement
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

    // Method for collecting a machine part
    public String collectPart(){
        if(currentRoom.hasPart()){
            Part partInRoom = ((RoomWithMachinePart)currentRoom).getPart();
            if(lastMachinePartCollected == null){
                if(partInRoom.getNum() == 1){
                    lastMachinePartCollected = partInRoom;
                    return(
                    "You have successfully collected part "
                    +lastMachinePartCollected.getNum());
                }else{
                    return("The part in this room is not the next part");
                }
            }
            if(lastMachinePartCollected.isNext(partInRoom)){
                lastMachinePartCollected = partInRoom;
                return(
                "You have successfully collected part "
                +lastMachinePartCollected.getNum());
            }
            else{
                return("The part in this room is not the next part");
            }
        }
        else{
            return("This room doesn't have a part");
        }
    }

    // Method for collecting tools
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

    // Method for building
    public String build(){
        if(lastMachinePartCollected == null)
        return("You dont have any parts dingus!");

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