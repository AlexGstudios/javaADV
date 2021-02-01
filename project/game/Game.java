public class Game {
    
    Gui gui;
    Player player = new Player();

    int numOfRooms = 4;

    String[] roomNames = {"Street", "Tavern", "Smith", "General store"};
    Room[] rooms = new Room[numOfRooms];
    Room room;

    Boolean isTrue = true;

    
    public Game(){

        this.gui = new Gui();

        createRooms(numOfRooms);

        gui.setShowRoom(rooms[0].getRoomName());
        
        while (isTrue) {
            switch (gui.getCommand()) {
                case "Street":
                    gui.setShowRoom(player.street());
                    break;
                case "Tavern":
                    gui.setShowRoom(player.tavern());
                    break;
                case "Smith":
                    gui.setShowRoom(rooms[2].getRoomName());
                    break;
                case "General store":
                    gui.setShowRoom(rooms[3].getRoomName());
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

        for (int i = 0; i < roomNum; i++) {
            
            room = new Room(i + 1, roomNames[i]);
            rooms[i] = room;
        }
    }
}
