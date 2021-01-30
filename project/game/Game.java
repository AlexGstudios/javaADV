import java.util.*;

public class Game {
    
    Gui gui;

    int numOfRooms = 4;

    String[] roomNames = {"Street", "Tavern", "Smith", "General store"};
    Room[] rooms = new Room[numOfRooms];
    Room room;

    
    public Game(){

        this.gui = new Gui();

        createRooms(numOfRooms);

        gui.setShowRoom();
    }

    public void createRooms(int roomNum){

        for (int i = 0; i < roomNum; i++) {
            
            room = new Room(i + 1, roomNames[i]);
            rooms[i] = room;
        }
    }
}
