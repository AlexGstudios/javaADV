public class GameObject {
    
    private String name;
    private Boolean pick;

    public GameObject(String objectName, Boolean pickUp){

        this.name = objectName;
        this.pick = pickUp;
    }

    // gets the name of the object
    public String getName(){

        return name;
    }

    public Boolean getPick(){

        return this.pick;
    }
}
