public class NpcMovement implements Runnable {

    GameGui gui = Game.gui;

    String[] names = { "John P Bollbirth", "Våd Olofsson", "Snäll Goodguy", "Bongo" };

    Boolean isTrue = true;

    int[] willMove = { 0, 0, 0, 0 };

    Person person;
    Person[] persons = new Person[names.length];

    @Override
    public void run() {

        for (int i = 0; i < names.length; i++) {

            person = new Person(names[i]);
            persons[i] = person;
        }

        while (isTrue) {

            System.out.println("Loop starts over");

            try {
            willMove[0] = (int) (Math.random() * 4) + 1;
            willMove[1] = (int) (Math.random() * 4) + 1;
            willMove[2] = (int) (Math.random() * 4) + 1;
            willMove[3] = (int) (Math.random() * 4) + 1;

            if (willMove[0] == 4) {

                gui.setShowPersons(persons[0].getName());
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
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
