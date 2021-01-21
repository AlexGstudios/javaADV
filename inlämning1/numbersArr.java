import java.util.*;
import java.util.stream.*;
import java.io.*;

public class numbersArr {

    private Double[] numbers = null;

    public void toNumbers() throws FileNotFoundException {
        numbers = fileToDouble("E:/Java projects/javaADV/javaADV/inlämning1/arrayerInts.txt");
    }

    public void numbersAbovethousand(){
        
        List<Double> numDouble = Arrays.asList(numbers);
        
        long num = numDouble
        .stream()
        .filter(x -> x > 1000)
        .count();
        
        System.out.println("Count of numbers above 1000: " + num);
    }

    public void underThousandDevidableThree(){

        List<Double> numDouble = Arrays.asList(numbers);

        double[] dubArr = numDouble
                                .stream()
                                .filter(x -> x < 1000)
                                .distinct()
                                .filter(x -> { return ((Math.floor(x)) % 3 == 0);})
                                .mapToDouble(x -> x)
                                .toArray();

        for (double d : dubArr) {
            System.out.println(d);
        }
    }
    
    public void sumOfBelowFiveHundred() {
        
        List<Double> numDouble = Arrays.asList(numbers);
        
        Double numArr = numDouble
        .stream()
        .filter(x -> x < 500)
        .collect(Collectors.summingDouble(Double::doubleValue));
        
        System.out.println("The sum of all numbers below 500: " + numArr);
    }
    
    public void avgOfRange() {
        
        List<Double> numDouble = Arrays.asList(numbers);
        
        OptionalDouble avg = numDouble
        .stream()
        .filter(x -> x > 2000 && x < 3000)
        .mapToDouble(x -> x.doubleValue())
        .average();
        
        Double dubNum = avg.getAsDouble();
        
        System.out.println("Average between 2000 to 3000: " + dubNum);
    }
    
    public void maxMin() {

        List<Double> numDouble = Arrays.asList(numbers);

        DoubleSummaryStatistics maxMin = numDouble
                                    .stream()
                                    .collect(Collectors.summarizingDouble(Double::doubleValue));

        System.out.println("Max value in array: " + maxMin.getMax());
        System.out.println("Min value in array: " + maxMin.getMin());
    }
    
    
    public Double[] fileToDouble(String source) throws FileNotFoundException {
        
        File file = new File(source);
        
        FileReader fileReaader = new FileReader(file);
        
        
        BufferedReader buffer = new BufferedReader(fileReaader);

        String str;

        String[] holder = null;

        
        try {
            while ((str = buffer.readLine()) != null) {
                holder = str.split(",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Double[] num = new Double[holder.length];

        for(int i = 0; i < holder.length; i++){

            num[i] = Double.parseDouble(holder[i]);
        }


        return num;
    }
}
