import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.WindowConstants;

public class TradeGui extends JFrame {

    // Person[] tradePersons = NpcMovement.persons;
    // Player tradePlayerInventory = Game.player;

    private JPanel tradePanel;
    private JTextArea tradePerson;
    private JTextArea tradePlayer;
    private JTextField tradeInput;
    private String tradeCommand;
    private JButton tradeButton;


    public TradeGui(){

        this.tradeCommand = "";
        this.setTitle("Trade Window");
        this.setSize(800, 600);
        this.setLocation(550, 300);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setUp();
        setPanel();
        this.add(tradePanel);
        this.setVisible(true);
        this.setResizable(false);
    }

    // gets the Trade gui command
    public String getTradeCommand(){

        return this.tradeCommand;
    }

    // updates the npc's name and inventory
    public void setTradePerson(String personStr){
        
        this.tradePerson.setText(personStr);
    }

    // updates the player inventory
    public void setTradePlayer(String playerStr){

        this.tradePlayer.setText(playerStr);
    }

    // stes the panel up with its content
    public void setPanel(){

        this.tradePanel.add(tradePerson);
        this.tradePanel.add(tradePlayer);
        this.tradePanel.add(tradeInput);
        this.tradePanel.add(tradeButton);
    }

    // sets up the content in all the fields
    public void setUp(){

        this.tradePanel = new JPanel(new GridLayout(2,6));
        this.tradePerson = new JTextArea("Npc inventory");
        this.tradePlayer = new JTextArea("Player inventory");
        this.tradeInput = new JTextField("Enter what you want to trade here.");
        // addera ett fält med commands som spelaren ska använda

        ActionListener aL = e -> {

            this.tradeCommand = tradeInput.getText();
            Trade.tradeSwitch(this.tradeCommand);
            // lägg till ett sätt att stänga fönstret vid klick
        };

        tradeInput.addActionListener(aL);

        this.tradeButton = new JButton("Trade button");
        this.tradeButton.addActionListener(aL);


    }
}
