import java.util.concurrent.ThreadLocalRandom;

public class Key extends GameObject {

    private String objectName;
    private int keyID;
    
    public Key(String objectName, Boolean pickUp) {
        super(objectName, pickUp);

        this.keyID = createKeyID();
    }

    private int createKeyID() {
       
        int randNum = ThreadLocalRandom.current().nextInt(0,5);

        return randNum;
    }

    public String getKeyName(){

        return this.objectName;
    }

    public int getKeyID(){

        return this.keyID;
    }
}
