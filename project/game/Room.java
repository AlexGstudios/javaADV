public class Room {

    GameGui gui = Game.gui;
    Inventory roomInv;

    private static final int INVENTORYSIZE = 7;

    private int roomNumber;
    private String roomName;
    private String roomDisc;

    public Room(int roomValue, String name, String roomDiscription){

        this.roomNumber = roomValue;
        this.roomName = name;
        this.roomDisc = roomDiscription;
        roomInv = new Inventory(INVENTORYSIZE);
    }

    // gets the room number
    public int getRoomNumber(){
        
        return this.roomNumber;
    }

    // gets the room name
    public String getRoomName(){

        return roomName;
    }

    // adds items to the rooms inventory
    public void addToInventory(GameObject object){

        this.roomInv.addItem(object);
    }

    // updates the gui with the roms discription and inventory
    public String show(){

        gui.setShowInventory(roomInv.getGameObjectNames());
        return roomDisc;
    }
}