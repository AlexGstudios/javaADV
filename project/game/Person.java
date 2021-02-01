public class Person implements Npc {

    int hitPoints;
    String name;

    public Person(String name){

        this.hitPoints = (int) (Math.random()*10)+1;
        this.name = name;
    }
    @Override
    public String name() {

        return this.name;
    }

    @Override
    public int hitPoints() {
        
        return this.hitPoints;
    }

    @Override
    public void show() {
        
        System.out.println(name() + " who has " + hitPoints() + " hitpoints");
    }
    
}
