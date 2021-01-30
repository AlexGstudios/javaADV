public class Room {

    private int roomNumber;
    private String roomName;

    public Room(int roomValue, String name){

        this.roomNumber = roomValue;
        this.roomName = name;
    }

    public int getRoomNumber(){
        
        return this.roomNumber;
    }

    public String getRoomName(){

        return roomName;
    }
}
