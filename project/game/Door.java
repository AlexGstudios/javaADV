public class Door {
    
    String name;
    int doorID;

    public Door(String name, int doorID){

        this.name = name;
        this.doorID = doorID;
    }

    public String doorName(){

        return this.name;
    }

    public int getDoorID(){

        return this.doorID;
    }
}
