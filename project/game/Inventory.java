import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Inventory {

    GameGui gui = Game.gui;
    
    private GameObject[] items;
    private int inventorySize;

    public Inventory(int itemCount){

        this.items = new GameObject[itemCount];
        this.inventorySize = itemCount;
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

        GameObject[] itemChanged = new GameObject[1];

        GameObject object = findObject(giving, name);

        List<GameObject> givingList = Arrays.asList(giving.items);

        itemChanged = givingList
                            .stream()
                            .map(x -> {
                                if (x == object) {
                                    return object;
                                }
                                return x;
                            })
                            .toArray(GameObject[]::new);
        addItem(itemChanged[0]);
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

        String[] nameArr = {name};

        List<GameObject> searchInventory = Arrays.asList(giving.items);

        GameObject[] foundItem = new GameObject[1];

        foundItem = searchInventory
                                .stream()
                                .map(x -> {
                                    if (giving.getGameObjectNames().equals(nameArr)) {
                                        return x;
                                    }
                                    return x;
                                })
                                .toArray(GameObject[]::new);

        return foundItem[0];
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