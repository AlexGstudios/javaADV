public class Person implements Npc {

    private final int INVENTORYMAXSIZE = 1;

    private int hitPoints;
    private String name;
    private Inventory persInv;

    public Person(String name){

        this.hitPoints = (int) (Math.random()*10)+1;
        this.name = name;
        this.persInv = new Inventory(INVENTORYMAXSIZE);
    }
    @Override
    public String getName() {

        return this.name;
    }

    @Override
    public int getHitPoints() {
        
        return this.hitPoints;
    }

    public void addPersonInv(GameObject object){
        
        this.persInv.addItem(object);
    }

    @Override
    public void getShow() {
        
        
    }
    
}
