public class Room {

    GameGui gui = Game.gui;
    Inventory inv;

    private static final int INVENTORYSIZE = 7;

    private int roomNumber;
    private String roomName;
    private String roomDisc;

    public Room(int roomValue, String name, String roomDiscription){

        this.roomNumber = roomValue;
        this.roomName = name;
        this.roomDisc = roomDiscription;
        inv = new Inventory(INVENTORYSIZE);
    }

    public int getRoomNumber(){
        
        return this.roomNumber;
    }

    public String getRoomName(){

        return roomName;
    }

    public void addToInventory(GameObject object){

        this.inv.addItem(object);
    }

    public String show(int index){

        gui.setShowInventory(Game.rooms[index].inv.getGameObjectNames()); // korta ner inv.get.. ?
        return roomDisc;
    }
}