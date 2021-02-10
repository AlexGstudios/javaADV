public class Trade{
    
    static TradeGui tradeGui;
    static Person[] persons;

    private static int npcID;

    // starts the new gui window
    public Trade(int personID){

        persons = NpcMovement.persons;
        tradeGui = new TradeGui();
        npcID = personID;
        setNpc();
        setPlayer();
    }

    // sets the npc's ID to be able to switch items with the right npc
    public static int getID(){

        return npcID;
    }

    // updates the gui to show the npc's inventory
    public void setNpc(){

        System.out.println(npcID);
        tradeGui.setTradePerson(persons[npcID].getShow());
    }

    // updates the gui to show the players inventory
    public void setPlayer(){

        tradeGui.setTradePlayer(Game.player.getShow());
    }

    // The switch for the trade gui to change items with npc
    public static void tradeSwitch(String tradeCommand){

        switch (tradeCommand) {
            case "Take Key":
                Game.player.getPlayerInventory().switchItems(persons[getID()].getPersonInventory(), "Key");
                break;
            case "Take Shoe":
                Game.player.getPlayerInventory().switchItems(persons[getID()].getPersonInventory(), "Shoe");
                persons[getID()].getPersonInventory().removeItem(persons[getID()].getPersonInventory(), "Shoe");
                break;
            case "Take Note":
                Game.player.getPlayerInventory().switchItems(persons[getID()].getPersonInventory(), "Note");
                break;
            case "Give Key":
                persons[getID()].getPersonInventory().switchItems(Game.player.getPlayerInventory(),  "Key");
                break;
            case "Give Shoe":
                persons[getID()].getPersonInventory().switchItems(Game.player.getPlayerInventory(), "Shoe");
                Game.player.getPlayerInventory().removeItem(Game.player.getPlayerInventory(), "Shoe");
                break;
            case "Give Note":
                persons[getID()].getPersonInventory().switchItems(Game.player.getPlayerInventory(), "Note");
                break;
        
            default:
                break;
        }
    }
}