public class Orc implements Npc {

    int hitPoints;

    public Orc(){

        this.hitPoints = (int) (Math.random()*15)+1;
    }

    @Override
    public String getName() {
        
        return "Orc";
    }

    @Override
    public int getHitPoints() {
        return this.hitPoints;
    }

    @Override
    public void getShow() {
        
        System.out.println("This is an Orc " + this.hitPoints);
    }
    
}
