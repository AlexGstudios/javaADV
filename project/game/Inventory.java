import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Inventory {

    GameGui gui = Game.gui;
    
    private GameObject[] items;
    private int inventorySize;

    public Inventory(int itemCount){

        this.items = new GameObject[itemCount];
        this.inventorySize = itemCount;
    }

    public void setInventory(GameObject[] obj){

        this.items = obj;
    }

    public void addItem(GameObject object){

        int numItems = index();
 
        List<GameObject> currGameList = Arrays.asList(this.items);

        GameObject[] newInv = new GameObject[inventorySize];

        if (numItems < inventorySize) {
            
            newInv = currGameList
                                .stream()
                                .sorted(Comparator.nullsLast(Comparator.comparing(GameObject::getName)))
                                .toArray(GameObject[]::new);

            newInv[numItems] = object;
            setInventory(newInv);
        }else{
            gui.setFullInventory();
        }
    }

    public String[] getGameObjectNames(){

        int index = index();

        String[] objectNames = new String[index];

        for (int i = 0; i < index; i++) {
            
            if (index == -1) {
                // return something.. return "empty?full?";
            }else{
                objectNames[i] = items[i].getName();
            }
        }

        return objectNames;
    }

    public int index(){

        for (int i = 0; i < items.length; i++) {
            
            if (items[i] == null) {
                
                return i;
            }
        }

        return -1;
    }
}