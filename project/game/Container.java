import java.util.Arrays;

public class Container extends GameObject {

    String objectName;
    int inventorySize;

    Inventory containerInv;

    int containerID;
    
    public Container(String objectName, Boolean pickUp, int inventorySize, int ID) {
        
        super(objectName, pickUp);
        this.objectName = objectName;
        this.inventorySize = inventorySize;
        this.containerInv = new Inventory(this.inventorySize);
        this.containerID = ID;
    }

    public String getName(){

        return this.objectName;
    }

    public int getcontainerID(){

        return this.containerID;
    }

    public Inventory getContInventory(){

        return this.containerInv;
    }

    // adds items to the rooms inventory
    public void addToInventory(GameObject object){

        this.containerInv.addItem(object);
    }
    
    public String getShow() {
        
        String concat = "" + getName() + "\n" + Arrays.toString(containerInv.getGameObjectNames()) + "\n";
        
        return concat;
    }
}
