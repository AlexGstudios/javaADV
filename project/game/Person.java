import java.util.Arrays;

public class Person implements Npc {

    private final int INVENTORYMAXSIZE = 1;

    private int hitPoints; // might be added as feature if there is time
    private String name;
    private Inventory persInv;
    private int ID;

    public Person(String name, int ID){

        this.hitPoints = (int) (Math.random()*10)+1; // might be added as feature if there is time
        this.name = name;
        this.persInv = new Inventory(INVENTORYMAXSIZE);
        this.ID = ID;
    }

    public int getID(){

        return this.ID;
    }

    // gets the npc's inventory
    public Inventory getPersonInventory(){

        return this.persInv;
    }

    // gets the npc name
    @Override
    public String getName() {

        return this.name;
    }

    // might delete
    @Override
    public int getHitPoints() {
        
        return this.hitPoints;
    }

    // add items to the npc
    public void addPersonInv(GameObject object){
        
        this.persInv.addItem(object);
    }

    // returns a string of the npc name and its inventory
    @Override
    public String getShow() {
        
        String concat = "" + getName() + "\n" + Arrays.toString(persInv.getGameObjectNames()) + "\n";
        
        return concat;
    }
}
