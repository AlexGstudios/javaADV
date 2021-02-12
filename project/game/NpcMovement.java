import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class NpcMovement implements Runnable {

    GameGui gui = Game.gui;
    Key personKey = Game.getPersonKey();

    static String[] names = { "John P Bollbirth", "Våd Olofsson", "Bongo" };
    String[] personsArr = new String[3];

    Boolean isTrue = true;

    int[] willMove = { 0, 0, 0 };
    int[] personRoom = { 0, 0, 0 };

    Person person;
    static Person[] persons = new Person[names.length];

    // creates the npc's
    public NpcMovement(){

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

        for (int i = 0; i < willMove.length; i++) {
            
            if (willMove[i] == 4) {
    
                personRoom[i] = ThreadLocalRandom.current().nextInt(0, 4);
            }
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

        for (int k = 0; k < willMove.length; k++) {
            
            if (willMove[k] == 2) {
                
                int randomPickUp = ThreadLocalRandom.current().nextInt(0, 2);
    
                if (randomPickUp == 1 && persons[k].getPersonInventory().getIfObjectNull() != null) {
                    
                    String[] roomInvArr = Game.rooms[personRoom[k]].getRoomInventory().getGameObjectNames();
    
                    for (int i = 0; i < roomInvArr.length; i++) {
                        if (roomInvArr[i] != "Chest Key") {
                            
                            if (i + 1 == roomInvArr.length) {
                                
                                Game.rooms[personRoom[k]].getRoomInventory().switchItems(persons[k].getPersonInventory(), "Chest Key");
                                persons[k].getPersonInventory().removeItem(persons[k].getPersonInventory(), "Chest Key");
                            }
                        }
                    }
                }else if (randomPickUp == 0) {
    
                    String[] roomInvArr = Game.rooms[personRoom[k]].getRoomInventory().getGameObjectNames();
    
                    for (int i = 0; i < roomInvArr.length; i++) {
                        if (roomInvArr[i] == "Chest Key") {
                            
                            persons[k].getPersonInventory().switchItems(Game.rooms[personRoom[k]].getRoomInventory(), "Chest Key");
                            Game.rooms[personRoom[k]].getRoomInventory().removeItem(persons[k].getPersonInventory(), "Chest Key");
                        }
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
