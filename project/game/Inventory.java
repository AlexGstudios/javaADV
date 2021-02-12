import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Inventory {

    GameGui gui = Game.gui;
    
    private GameObject[] items;
    private int inventorySize;

    public Inventory(int itemCount){

        this.items = new GameObject[itemCount];
        this.inventorySize = itemCount;
    }

    public GameObject getIfObjectNull(){

        for (int i = 0; i < items.length; i++) {
            
            if (items[i] == null) {
                return items[i];
            }
        }
        return items[0];
    }

    // sets inventory
    public void setInventory(GameObject[] obj){

        this.items = obj;
    }

    // adds object to the inventory
    public void addItem(GameObject object){

        int numItems = index();
 
        List<GameObject> currGameList = Arrays.asList(this.items);

        GameObject[] newInv = new GameObject[inventorySize];

        if (numItems < inventorySize && numItems != -1) {
            
            newInv = currGameList
                                .stream()
                                .sorted(Comparator.nullsLast(Comparator.comparing(GameObject::getName)))
                                .toArray(GameObject[]::new);

            newInv[numItems] = object;
            setInventory(newInv);
        }else{
            gui.setInfoText("This inventory is full.");
        }
    }

    // switch items between player/npc and player room
    public void switchItems(Inventory giving, String name){

        GameObject itemChanged;

        List<GameObject> givingList = Arrays.asList(giving.items);

        itemChanged = givingList
                            .stream()
                            .filter(Objects::nonNull)
                            .filter(x -> x.getName().equals(name))
                            .findFirst().orElse(null);
        addItem(itemChanged);
    }

    // removes the item from inventory
    public void removeItem(Inventory giving, String name){

        GameObject itemName = findObject(giving, name);

        List<GameObject> searchInventory = Arrays.asList(this.items);

        this.items = searchInventory
                                .stream()
                                .map(x -> {
                                    if (x == itemName) {
                                        return null;
                                    }
                                    return x;
                                })
                                .toArray(GameObject[]::new);
    }

    // gets the names from the inventory and returns as a string[]
    public String[] getGameObjectNames(){

        int index = index();

        String[] objectNames = new String[items.length];

        for (int i = 0; i < index; i++) {

            if (index == 0) {

                objectNames[i] = items[i].getName();
            }else{

                objectNames[i] = items[i].getName();
            }
        }

        return objectNames;
    }

    // goes through the inventory and finds the object with the given (String) name
    public GameObject findObject(Inventory giving, String name){

        GameObject foundItem;

        List<GameObject> searchInventory = Arrays.asList(giving.items);

        foundItem = searchInventory
                                .stream()
                                .filter(Objects::nonNull)
                                .filter(x -> x.getName().equals(name))
                                .findFirst().orElse(null);

        return foundItem;
    }

    // goes through to check if the invientory is full
    public int index(){

        for (int i = 0; i < items.length; i++) {
            
            if (items[i] == null) {
                
                return i;
            }
        }
        // får se över denna metod
        return items.length;
    }
}