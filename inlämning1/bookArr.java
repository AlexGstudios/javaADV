import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;
import java.io.*;

public class bookArr {

    private String[] words = null;

    public void toWords() throws FileNotFoundException {
            words = fileToString("E:/Java projects/javaADV/javaADV/inlämning1/arrayer.txt");
    }


    public void AboveEight() {

        List<String> strList = Arrays.asList(words);
        
        List<String> list = strList
        .stream()
        .filter(x -> x.length() > 8)
        .collect(Collectors.toList());
        
        int numAboveEight = list.size();
        
        System.out.println("Words above eight characters: " + numAboveEight);
    }
    
    public void uniqueWords(){
        
        List<String> uniqueWords = Arrays.asList(words);
        
        List<String> uniquelst = uniqueWords
        .stream()
        .sorted()
        .distinct()
        .collect(Collectors.toList());
        
        int uniqueNum = uniquelst.size();
        
        System.out.println("Unique words: " + uniqueNum);
    }
    
    public void lessThanFour() {
        List<String> strList = Arrays.asList(words);
        
        List<String> list = strList
        .stream()
        .filter(x -> x.length() < 4)
        .collect(Collectors.toList());
        
        int numAboveEight = list.size();
        
        System.out.println("Words under four characters: " + numAboveEight);
    }
    
    public void uniqueAboveEight() {
        
        List<String> strList = Arrays.asList(words);
        
        List<String> list = strList
        .stream()
        .sorted()
        .distinct()
        .filter(x -> x.length() > 8)
        .collect(Collectors.toList());
        
        int uniqueAboveEight = list.size();
        
        System.out.println("Unique words above eight characters: " + uniqueAboveEight);
    }
    
    public void avgLength() {
        
        List<String> strList = Arrays.asList(words);
        
        OptionalDouble list = strList
        .stream()
        .mapToInt(x -> x.length())
        .average();
        
        Double dubNum = list.getAsDouble();
        
        System.out.println("Average characters of all the words: " + dubNum);
    }
    
    public void sumWords() {
        
        List<String> strList = Arrays.asList(words);
        
        int sum = strList
        .stream()
        .mapToInt(x -> x.length())
        .sum();
        
        System.out.println("Sum of characters of all the words: " + sum);
    }
    
    public void wordsLowerThanTwo() {
        
        List<String> strList = Arrays.asList(words);

        Predicate<String> p1 = x -> x.length() < 2;
        
        Boolean list = strList
        .stream()
        .anyMatch(p1);
        
        
        System.out.println("Are there words shorter than 2 characters: " + list);
    }
    
    public void wordsShorterThanTwelve() {
        
        List<String> strList = Arrays.asList(words);

        Predicate<String> p1 = x -> x.length() > 12;
        
        Boolean list = strList
        .stream()
        .anyMatch(p1);
        
        System.out.println("Are there words longer than twelve characters: " + list);
    }

    public String[] fileToString(String source) throws FileNotFoundException {
        
        File file = new File(source);
        
        FileReader fileReaader = new FileReader(file);
        
        
        BufferedReader buffer = new BufferedReader(fileReaader);
        
        String str;
        
        String[] words = null;
        
        try {
            while ((str = buffer.readLine()) != null) {
                words = str.split("[, ]+");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        for(int i = 0; i < words.length; i++)
        {
            words[i] = words[i].substring(1, words[i].length()-1);
        }
        
        
        return words;
    }
}
