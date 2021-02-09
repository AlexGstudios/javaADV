import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;

/*Extremt enkelt Gui för att kunna komma igång.
Snygga gärna till/gör ett eget. Men tänk på att gör GUI:s INTE är ett kursmoment - så fastna inte här!
 */


    public class GameGui extends JFrame {

        private JPanel panel;
        private JTextArea showRoom;
        private JTextArea showPersons;
        private JTextArea commands;
        private JTextField input;
        private JTextArea inventory;
        private String command;
        private boolean gotCommand;
        private JButton button;

        public String[] comm = {"Level 1: moves you to Level 1\n",
                                "Level 2: moves you to Level 2\n",
                                "Level 3: moves you to Level 3\n",
                                "Level 4: moves you to Level 4\n",
                                "Exit: exits the game"};

        public GameGui(){
            this.gotCommand = false;
            this.command = "";
            this.setTitle("Game");
            this.setSize(800, 600);
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setUpElements();
            setUpPanel();
            this.add(panel);
            this.setVisible(true);
            this.setResizable(false);
        }

        //Returnera det senaste commitade kommandot
        public String getCommand(){
            if (this.gotCommand){
                this.gotCommand = false;
                System.out.println(this.command);
                return this.command;
            }
            return this.command;
        }
        //Här kan man updatera respektive fält:
        public void setShowRoom(String roomDescription){
            this.showRoom.setText(roomDescription);
         }
        public void setShowPersons(String person){
            this.showPersons.setText(person);
        }
        public void setShowInventory(String[] i){
            this.inventory.setText(Arrays.toString(i));
        }
        public void setFullInventory(){
            this.input.setText("This inventory is full.");
        }

        //Add person to room
        public void setPerson(Person p){
            this.showPersons.setText(p.toString());
        }

//Nedantåenda spaghetti är inte vacker...


        public void gotCommand(){
            this.gotCommand = false;
        }

        private void setUpPanel(){
            this.panel.add(showPersons);
            this.panel.add(showRoom);
            this.panel.add(input);
            this.panel.add(inventory);
            this.panel.add(button);
            this.panel.add(commands);
        }
        private void setUpElements(){
            this.panel = new JPanel(new GridLayout(4,3));
            this.showRoom = new JTextArea("Room: ");
            this.showPersons = new JTextArea("Persons");
            this.inventory = new JTextArea("Inventory");
            this.input = new JTextField("Give command");
            this.commands = new JTextArea("Commands:\n" + comm[0] + comm[1] + comm[2] + comm[3] + comm[4]);
            this.showPersons.setEditable(false);
            this.showRoom.setEditable(false);
            this.inventory.setEditable(false);

            ActionListener inputListener = e -> {
                this.command = input.getText();
                this.gotCommand = true;
                this.getCommand();
            };

            input.addActionListener(inputListener);

            this.button = new JButton("commit");
            this.button.addActionListener(inputListener);

        }
    }

