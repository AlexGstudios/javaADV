public class Door extends GameObject{
    
    String objectName;
    Boolean pickUp;
    int doorID;

    public Door(String objectName, Boolean pickUp, int doorID){
        super(objectName, pickUp);

        this.objectName = objectName;
        this.doorID = doorID;
    }

    public String doorName(){

        return this.objectName;
    }

    public int getDoorID(){

        return this.doorID;
    }
}
