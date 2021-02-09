public class Game {
    
    static GameGui gui = new GameGui();
    Room room;
    Player player = new Player();
    NpcMovement npcMove = new NpcMovement();

    Thread npcThread = new Thread(npcMove);

    
    static int numOfRooms = 4;
    
    static Room[] rooms = new Room[numOfRooms];
    
    Boolean isTrue = true;
    
    
    public Game(){
        
        createRooms(numOfRooms);
        
        player.firstRoom();
        
        npcThread.start();

        while (isTrue) {
            switch (gui.getCommand()) {
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
                case "Exit":
                    gui.dispose();
                    isTrue = false;
                    break;
                default:
                    break; 
            }
        }
    }

    public void createRooms(int roomNum){

        String[] roomNames = {"Level 1", "Level 2", "Level 3", "Level 4"};
        String[] roomDisc = {"A dark damp room.", "There is a crack in the wall, can this be the way out?",
                        "I can smell something, is it food?", "Ah a locked door, this must be the way out."};

        String[] objectName = { "Chair", "Box", "Sofa", "TV", "Lamp",
                                "Drawer", "Bed", "Note", "Art picture", "Crack",
                                "Ladder", "Toolbox", "Mop", "Flashlight", "Wrench",
                                "Chest", "Door", "", "", ""};

        Boolean[] objectPickable = {false, false, false, false, false,
                                    false, false, true, false, false,
                                    false, false, false, false, false,
                                    false, false, false, false, false};

        int from = 0;
        int stop = 5;

        for (int i = 0; i < roomNum; i++) {
            
            room = new Room(i + 1, roomNames[i], roomDisc[i]);

            for (int j = from; j < stop; j++) {
                
                GameObject object = new GameObject(objectName[j], objectPickable[j]);
                room.addToInventory(object);
            }

            from = from + 5;
            stop = stop + 5;

            rooms[i] = room;
        }
    }
}
