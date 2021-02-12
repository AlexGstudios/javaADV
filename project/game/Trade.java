public class Trade{
    
    static TradeGui tradeGui;
    static Person[] persons;
    static Container chest;

    private static int npcID;

    // starts the new gui window
    public Trade(){

        chest = Game.chest;
        tradeGui = new TradeGui();
        setChest();
        setPlayer();
    }
    
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

    public void setChest(){

        tradeGui.setTradePerson(Game.chest.getShow());
    }

    // updates the gui to show the npc's inventory
    public void setNpc(){

        tradeGui.setTradePerson(persons[npcID].getShow());
    }

    // updates the gui to show the players inventory
    public void setPlayer(){

        tradeGui.setTradePlayer(Game.player.getShow());
    }

    // The switch for the trade gui to change items with npc
    public static void tradeSwitch(String tradeCommand){

        switch (tradeCommand) {
            case "Take Chest Key":
                Game.player.getPlayerInventory().switchItems(persons[getID()].getPersonInventory(), "Chest Key");
                persons[getID()].getPersonInventory().removeItem(persons[getID()].getPersonInventory(), "Chest Key");
                break;
            case "Take Master Key":
                Game.player.getPlayerInventory().switchItems(Game.chest.getContInventory(), "Master");
                Game.chest.getContInventory().removeItem(Game.chest.getContInventory(), "Master");
                break;
            case "Take Note":
                Game.player.getPlayerInventory().switchItems(persons[getID()].getPersonInventory(), "Note");
                persons[getID()].getPersonInventory().removeItem(persons[getID()].getPersonInventory(), "Note");
                break;
            case "Give Chest Key":
                persons[getID()].getPersonInventory().switchItems(Game.player.getPlayerInventory(),  "Chest Key");
                Game.player.getPlayerInventory().removeItem(Game.player.getPlayerInventory(), "Chest Key");
                break;
            case "Give Master Key":
                persons[getID()].getPersonInventory().switchItems(Game.player.getPlayerInventory(), "Master");
                Game.player.getPlayerInventory().removeItem(Game.player.getPlayerInventory(), "Master");
                break;
            case "Give Note":
                persons[getID()].getPersonInventory().switchItems(Game.player.getPlayerInventory(), "Note");
                Game.player.getPlayerInventory().removeItem(Game.player.getPlayerInventory(), "Note");
                break;
        
            default:
                break;
        }
    }
}