import java.util.Arrays;

public class Player {

    // gör så varje rom har en siffra och kolla om player och person är i samma rum för trade
    // samt att player skall bara kunna gå 1 rum i taget (int 1 till 3)etc
    GameGui gui = Game.gui;
    Inventory playerInv;

    private final int INVENTORYMAXSIZE;
    private int playerPos = 0;
    private int roomNumber = 1;

    private GameObject playerStart = new GameObject("shoe", true);

    public Player(int itemCount){

        this.playerInv = new Inventory(itemCount);
        this.INVENTORYMAXSIZE = itemCount;
        this.playerInv.addItem(playerStart);
    }

    // returns a string woth the players inventory
    public String getShow(){

        String concat = Arrays.toString(playerInv.getGameObjectNames());
        
        return concat;
    }

    // gets the players inventory
    public Inventory getPlayerInventory(){

        return this.playerInv;
    }

    // sets the players position to hinder the player to move too far
    public void setPlayerPos(int move){

        this.playerPos = move;
    }

    // checks if the player can move to this room and then updates the gui
    public void firstRoom(){

        roomNumber = 1;

        changeCheck(playerPos, roomNumber);
    }

    // checks if the player can move to this room and then updates the gui
    public void secondRoom(){

        roomNumber = 2;

        changeCheck(playerPos, roomNumber);
    }

    // checks if the player can move to this room and then updates the gui
    public void thirdRoom(){

        roomNumber = 3;

        changeCheck(playerPos, roomNumber);
    }

    // checks if the player can move to this room and then updates the gui
    public void fourthRoom(){

        roomNumber = 4;

        changeCheck(playerPos, roomNumber);
    }

    // checks the players movement
    public void changeCheck(int player, int roomNum) {

        int restrict = player - roomNum;

        if(restrict == 1 || restrict == -1){

            setPlayerPos(roomNum);
            gui.setShowRoom(Game.rooms[roomNum-1].show());
        }else{
            gui.setInfoText("Unable to move.");
        }
    }
}