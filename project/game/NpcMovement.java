import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class NpcMovement implements Runnable {

    GameGui gui = Game.gui;
    Key personKey;

    static String[] names = { "John P Bollbirth", "Våd Olofsson", "Bongo" };
    String[] personsArr = new String[3];

    Boolean isTrue = true;

    int[] willMove = { 0, 0, 0 };
    int[] personRoom = { 0, 0, 0 };

    Person person;
    static Person[] persons = new Person[names.length];

    // creates the npc's
    public NpcMovement(){

        this.personKey = new Key("Chest Key", true);

        for (int i = 0; i < names.length; i++) {

            person = new Person(names[i], i);
            persons[i] = person;
        }

        persons[1].addPersonInv(this.personKey);
    }

    // runs the npc thread and checks if the npc will move
    @Override
    public void run() {

        while (isTrue) {

            playerInRoom(personRoom);

            showThings();

            try {
            willMove[0] = (int) (Math.random() * 10) + 1;
            willMove[1] = (int) (Math.random() * 10) + 1;
            willMove[2] = (int) (Math.random() * 10) + 1;

            personMovement(willMove);

            dropAndPickUp(willMove);

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // sets which room the npc's are in
    public void personMovement(int[] willMove){

        if (willMove[0] == 4) {

            personRoom[0] = ThreadLocalRandom.current().nextInt(0, 4);
        }
        if (willMove[1] == 4) {

            personRoom[1] = ThreadLocalRandom.current().nextInt(0, 4);
        }
        if (willMove[2] == 4) {

            personRoom[2] = ThreadLocalRandom.current().nextInt(0, 4);
        }
    }
    
    // adds the npc to an array to show which room they are in
    public void playerInRoom(int[] personRoom){

        for (int i = 0; i < personRoom.length; i++) {
            
            if (personRoom[i] == Game.player.getPlayerPosition()) {
    
                personsArr[i] = "\n" + persons[i].getShow();
            }else{
    
                personsArr[i] = null;
            }
        }
    }

    // the npc's picks up and drop the item chest key
    public void dropAndPickUp(int[] willMove){

        if (willMove[0] == 2) {
            
            int randomPickUp = ThreadLocalRandom.current().nextInt(0, 2);

            if (randomPickUp == 1 && persons[0].getPersonInventory().getIfObjectNull() != null) {
                
                String[] roomInvArr = Game.rooms[personRoom[0]].getRoomInventory().getGameObjectNames();

                for (int i = 0; i < roomInvArr.length; i++) {
                    if (roomInvArr[i] != "Chest Key") {
                        
                        if (i + 1 == roomInvArr.length) {
                            
                            Game.rooms[personRoom[0]].getRoomInventory().switchItems(persons[0].getPersonInventory(), "Chest Key");
                            persons[0].getPersonInventory().removeItem(persons[0].getPersonInventory(), "Chest Key");
                        }
                    }
                }
            }else if (randomPickUp == 0) {

                String[] roomInvArr = Game.rooms[personRoom[0]].getRoomInventory().getGameObjectNames();

                for (int i = 0; i < roomInvArr.length; i++) {
                    if (roomInvArr[i] == "Chest Key") {
                        
                        persons[0].getPersonInventory().switchItems(Game.rooms[personRoom[0]].getRoomInventory(), "Chest Key");
                        Game.rooms[personRoom[0]].getRoomInventory().removeItem(persons[0].getPersonInventory(), "Chest Key");
                    }
                }
            }
        }
        if (willMove[1] == 2) {
            
            int randomPickUp = ThreadLocalRandom.current().nextInt(0, 2);

            if (randomPickUp == 1 && persons[1].getPersonInventory().getIfObjectNull() != null) {
                
                String[] roomInvArr = Game.rooms[personRoom[1]].getRoomInventory().getGameObjectNames();

                for (int i = 0; i < roomInvArr.length; i++) {
                    if (roomInvArr[i] != "Chest Key") {
                       
                        if (i + 1 == roomInvArr.length) {
                            
                            Game.rooms[personRoom[1]].getRoomInventory().switchItems(persons[1].getPersonInventory(), "Chest Key");
                            persons[1].getPersonInventory().removeItem(persons[1].getPersonInventory(), "Chest Key");
                        }
                    }
                }
            }else if (randomPickUp == 0) {

                String[] roomInvArr = Game.rooms[personRoom[1]].getRoomInventory().getGameObjectNames();

                for (int i = 0; i < roomInvArr.length; i++) {
                    if (roomInvArr[i] == "Chest Key") {
                        
                        persons[1].getPersonInventory().switchItems(Game.rooms[personRoom[1]].getRoomInventory(), "Chest Key");
                        Game.rooms[personRoom[1]].getRoomInventory().removeItem(persons[1].getPersonInventory(), "Chest Key");
                    }
                }
            }
        }
        if (willMove[2] == 2) {
            
            int randomPickUp = ThreadLocalRandom.current().nextInt(0, 2);

            if (randomPickUp == 1 && persons[2].getPersonInventory().getIfObjectNull() != null) {
                
                String[] roomInvArr = Game.rooms[personRoom[2]].getRoomInventory().getGameObjectNames();

                for (int i = 0; i < roomInvArr.length; i++) {
                    if (roomInvArr[i] != "Chest Key") {
                        
                        if (i + 1 == roomInvArr.length) {
                            
                            Game.rooms[personRoom[2]].getRoomInventory().switchItems(persons[2].getPersonInventory(), "Chest Key");
                            persons[2].getPersonInventory().removeItem(persons[2].getPersonInventory(), "Chest Key");
                        }
                    }
                }
            }else if (randomPickUp == 0) {

                String[] roomInvArr = Game.rooms[personRoom[2]].getRoomInventory().getGameObjectNames();

                for (int i = 0; i < roomInvArr.length; i++) {
                    if (roomInvArr[i] == "Chest Key") {
                        
                        persons[2].getPersonInventory().switchItems(Game.rooms[personRoom[2]].getRoomInventory(), "Chest Key");
                        Game.rooms[personRoom[2]].getRoomInventory().removeItem(persons[2].getPersonInventory(), "Chest Key");
                    }
                }
            }
        }
    }

    // updates the gui
    public void showThings(){

            gui.setShowPersons(Arrays.toString(personsArr));
            gui.setPlayerInventory(Game.player.getShow());
            gui.setShowInventory(Game.rooms[Game.player.getPlayerPosition()].getRoomInventory().getGameObjectNames());
    }
}
