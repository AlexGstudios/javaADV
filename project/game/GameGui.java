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
        private JTextArea info;
        private JTextArea playerInventory;
        private String command;
        private JButton button;

        public String[] comm = {"Level 1: moves you to Level 1.  ",
                                "Level 2: moves you to Level 2\n",
                                "Level 3: moves you to Level 3.  ",
                                "Level 4: moves you to Level 4\n",
                                "Exit: exits the game"};

        // sets up the main gui
        public GameGui(){
            this.command = "";
            this.setTitle("Game");
            this.setSize(1200, 800);
            this.setLocation(500, 250);
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setUpElements();
            setUpPanel();
            this.add(panel);
            this.setVisible(true);
            this.setResizable(false);
        }

        //Returnera det senaste commitade kommandot
        public String getCommand(){

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
        public void setInfoText(String str){
            this.info.setText(str);
        }

        //Add person to room
        public void setPerson(Person p){
            this.showPersons.setText(p.toString());
        }

//Nedantåenda spaghetti är inte vacker...

        private void setUpPanel(){
            this.panel.add(showPersons);
            this.panel.add(showRoom);
            this.panel.add(input);
            this.panel.add(inventory);
            this.panel.add(button);
            this.panel.add(commands);
            this.panel.add(info);
            this.panel.add(playerInventory);
        }
        private void setUpElements(){
            this.panel = new JPanel(new GridLayout(4,4));
            this.showRoom = new JTextArea("Room: ");
            this.showPersons = new JTextArea("Persons");
            this.inventory = new JTextArea("Inventory");
            this.input = new JTextField("Give command");
            this.commands = new JTextArea("Commands:\n" + comm[0] + comm[1] + comm[2] + comm[3] + comm[4]);
            this.info = new JTextArea("Info");
            this.playerInventory = new JTextArea("Player inventory");
            this.showPersons.setEditable(false);
            this.showRoom.setEditable(false);
            this.inventory.setEditable(false);

            ActionListener inputListener = e -> {
                this.command = input.getText();
                Game.move(this.getCommand());
            };

            input.addActionListener(inputListener);

            this.button = new JButton("commit");
            this.button.addActionListener(inputListener);

        }
    }

