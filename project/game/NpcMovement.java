public class NpcMovement implements Runnable {

    GameGui gui = Game.gui;

    static String[] names = { "John P Bollbirth", "Våd Olofsson", "Snäll Goodguy", "Bongo" };

    Boolean isTrue = true;

    int[] willMove = { 0, 0, 0, 0 };

    Person person;
    static Person[] persons = new Person[names.length];

    // creates the npc's
    public NpcMovement(){

        for (int i = 0; i < names.length; i++) {

            person = new Person(names[i]);
            persons[i] = person;
        }
    }

    // runs the npc thread and checks if the npc will move
    @Override
    public void run() {

        while (isTrue) {

            System.out.println("Loop starts over");

            try {
            willMove[0] = (int) (Math.random() * 4) + 1;
            willMove[1] = (int) (Math.random() * 4) + 1;
            willMove[2] = (int) (Math.random() * 4) + 1;
            willMove[3] = (int) (Math.random() * 4) + 1;

            if (willMove[0] == 4) {

                gui.setShowPersons(persons[0].getShow());
            }
            if (willMove[1] == 4) {

                // Våd ska byta rum
            }
            if (willMove[2] == 4) {

                // Snäll ska byta rum
            }
            if (willMove[3] == 4) {

                // Bongo ska byta rum
            }
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
