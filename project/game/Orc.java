public class Orc implements Npc {

    int hitPoints;

    public Orc(){

        this.hitPoints = (int) (Math.random()*15)+1;
    }

    @Override
    public String name() {
        
        return "Orc";
    }

    @Override
    public int hitPoints() {
        return this.hitPoints;
    }

    @Override
    public void show() {
        
        System.out.println("This is an Orc " + this.hitPoints);
    }
    
}
