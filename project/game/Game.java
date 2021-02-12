public class Game {
    
    static GameGui gui = new GameGui();
    Room room;
    static Player player = new Player(5);
    NpcMovement npcMove = new NpcMovement();

    Thread npcThread = new Thread(npcMove);

    
    static int numOfRooms = 4;
    
    static Room[] rooms = new Room[numOfRooms];
    
    static Boolean isTrue = true;
    
    
    public Game(){
        
        createRooms(numOfRooms);
        
        player.firstRoom();
        
        npcThread.start();
    }

    // Setting up the rooms
    public void createRooms(int roomNum){

        String[] roomNames = {"Level 1", "Level 2", "Level 3", "Level 4"};
        String[] roomDisc = {"A dark damp room.", "There is a crack in the wall, can this be the way out?",
                        "I can smell something, is it food?", "Ah a locked door, this must be the way out."};

        String[] objectName = { "Chair", "Box", "Sofa", "TV", "Lamp",
                                "Drawer", "Bed", "Note", "Art picture", "Crack",
                                "Ladder", "Toolbox", "Mop", "Flashlight", "Wrench",
                                "Chest", "Door", "", "", ""};

        Boolean[] objectPick =      {false, false, false, false, false,
                                    false, false, true, false, false,
                                    false, false, false, false, false,
                                    false, false, false, false, false};

        int from = 0;
        int stop = 5;

        for (int i = 0; i < roomNum; i++) {
            
            room = new Room(i + 1, roomNames[i], roomDisc[i]);

            for (int j = from; j < stop; j++) {
                
                GameObject object = new GameObject(objectName[j], objectPick[j]);
                room.addToInventory(object);
            }

            from = from + 5;
            stop = stop + 5;

            rooms[i] = room;
        }
    }

    //The Main switch for movement, "trade" and to pick up items in rooms
    public static void move(String command){

        switch (command) {
            case "Level 1":
                player.firstRoom();
                break;
            case "Level 2":
                player.secondRoom();
                break;
            case "Level 3":
                player.thirdRoom();
                break;
            case "Level 4":
                player.fourthRoom();
                break;
            case "Trade John":
                Trade john = new Trade(NpcMovement.persons[0].getID());
                break;
            case "Trade Våd":
                Trade vad = new Trade(NpcMovement.persons[1].getID());
                break;
            case "Trade Bongo":
                Trade bongo = new Trade(NpcMovement.persons[2].getID());
                break;
            case "Pick Up Note":
                player.getPlayerInventory().switchItems(rooms[player.getPlayerPosition()].getRoomInventory(), "Note");
                rooms[player.getPlayerPosition()].getRoomInventory().removeItem(rooms[player.getPlayerPosition()].getRoomInventory(), "Note");
                break;
            case "Pick Up Chest Key":
                player.getPlayerInventory().switchItems(rooms[player.getPlayerPosition()].getRoomInventory(), "Chest Key");
                rooms[player.getPlayerPosition()].getRoomInventory().removeItem(rooms[player.getPlayerPosition()].getRoomInventory(), "Chest Key");
                break;
            case "Drop Note":
                rooms[player.getPlayerPosition()].getRoomInventory().switchItems(player.getPlayerInventory(), "Note");
                player.getPlayerInventory().removeItem(player.getPlayerInventory(), "Note");
                break;
            case "Drop Chest Key":
                rooms[player.getPlayerPosition()].getRoomInventory().switchItems(player.getPlayerInventory(), "Chest Key");
                player.getPlayerInventory().removeItem(player.getPlayerInventory(), "Key");
                break;
            case "Drop Shoe":
                rooms[player.getPlayerPosition()].getRoomInventory().switchItems(player.getPlayerInventory(), "Shoe");
                player.getPlayerInventory().removeItem(player.getPlayerInventory(), "Shoe");
                break;
            case "Exit":
                gui.dispose();
                isTrue = false;
                break;
            default:
                break; 
        }
    }
}
