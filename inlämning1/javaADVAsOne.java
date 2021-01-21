import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.*;

public class javaADVAsOne {

    public static void main(String[] args) {

        bookArr bA = new bookArr();

        numbersArr nA = new numbersArr();

        try {
            bA.toWords();
            nA.toNumbers();
        } catch (Exception e) {
            System.out.println("File not found");
        }

        bA.AboveEight();

        bA.uniqueWords();

        bA.lessThanFour();

        bA.uniqueAboveEight();

        bA.avgLength();

        bA.sumWords();

        bA.wordsLowerThanTwo();
        
        bA.wordsShorterThanTwelve();

        System.out.println("--------------------------------------------");

        nA.numbersAbovethousand();

        nA.underThousandDevidableThree();

        nA.sumOfBelowFiveHundred();

        nA.avgOfRange();

        nA.maxMin();

        System.out.println("-------------------------------------------");

        myObject mO = new myObject(true, 30, "sarah");
        
        List<myObject> mOList = new ArrayList<>();

        for(int i = 0; i < 50; i++)
        {
            mO = new myObject(randomBool(), randomInt(), randomString());
            mOList.add(mO);
        }

        aboveTwenty(mOList);

        valueAverage(mOList);     
        
        nameToTrue(mOList);
    }

    public static void aboveTwenty(List<myObject> mOList){

        List<myObject> overTwenty = mOList
                                        .stream()
                                        .filter(x -> x.getValue() > 20)
                                        .collect(Collectors.toList());

                
        for(int i = 0; i < overTwenty.size(); i++)
        {
            System.out.println("Bool: " + overTwenty.get(i).getBool());
            System.out.println("Name: " + overTwenty.get(i).getName());
            System.out.println("Value:" + overTwenty.get(i).getValue());
            System.out.println("--------");
        }
    }

    public static void valueAverage(List<myObject> mOList){

        OptionalDouble avg = mOList
                            .stream()
                            .mapToDouble(x -> x.getValue())
                            .average();
        
        Double dubAvg = avg.getAsDouble();

        System.out.println("Average of all values: " + dubAvg + "\n -----");
    }

    public static void nameToTrue(List<myObject> mOList){

        List<myObject> list = mOList
                                    .stream()
                                    .filter(x -> x.getBool())
                                    .map(x -> {
                                        if(x.getBool()){
                                            x.setName("This Is True");
                                        }
                                        return x;
                                    })
                                    .collect(Collectors.toList());
        
        for (myObject w : list) {
            System.out.println(w.toString());
        }
    }

    public static Boolean randomBool(){
        
        Boolean isTrue = false;

        int numBool = ThreadLocalRandom.current().nextInt(0, 2);

        if (numBool == 1) {
            isTrue = true;
        }else if(numBool == 0){
            isTrue = false;
        }

        return isTrue;
    }

    public static int randomInt(){

        int randInt = ThreadLocalRandom.current().nextInt(1, 51);

        return randInt;
    }

    public static String randomString(){

        String randString = "";

        char[] charArr = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','å','ä','ö'};

        Double len = ((Math.random()*12)+1);

        for(int i = 0; i < len; i++)
        {
            Double randChar = Math.random()*28-1;
            randString = randString + charArr[randChar.intValue()];
        }


        return randString;
    }
}