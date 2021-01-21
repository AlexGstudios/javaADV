public class myObject {
    
    private Boolean bool = false;
    private int values;
    private String name;
    
    public myObject(Boolean bool, int values, String name){
        this.bool = bool;
        this.values = values;
        this.name = name;
    }

    public Boolean getBool(){
        return bool;
    }
    public int getValue(){
        return values;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String toString(){
        return ("Boolean: " + this.bool + ",\n" + "Name: " + this.name + ",\n" + "Value: " + this.values + "\n ---------");
    }
}
