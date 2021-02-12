public class Container extends GameObject {

    String objectName;
    int inventorySize;

    Inventory containerInv;
    
    public Container(String objectName, Boolean pickUp, int inventorySize, int containerSize) {
        
        super(objectName, pickUp);
        this.objectName = objectName;
        this.inventorySize = inventorySize;
        this.containerInv = new Inventory(containerSize);
    }

    public String getName(){

        return this.objectName;
    }

    public Inventory contInventory(){

        return this.containerInv;
    }
}
