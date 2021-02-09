public class GameObject {
    
    private String name;
    private Boolean pickable;

    public GameObject(String objectName, Boolean pickUp){

        this.name = objectName;
        this.pickable = pickUp;
    }

    public String getName(){

        return name;
    }
}
