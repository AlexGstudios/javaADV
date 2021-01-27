package pkgTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) throws FileNotFoundException{

        String[] toFind = {"(?i)abcdefghijlklmnopqstuvxyz",
        "(?i)ola",
        "a{3,5}",
        "\\W{2,}+",
        "[a-zA-Z0-9_%.\\-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z]{2,3}+",
        "\\d{8}|[\\d/-]{4}+\\d{6}",
        "(\\D)\\1\\1\\1(?!1)+",
        "[a-zA-Z]{3}/[0-9]{3}|[a-zA-Z]{3}_[0-9]{3}",
        "\\([a-zA-Z0-9]+\\)",
        "(if)\\(+[a-zA-Z0-9\\W]+;|(for)\\(+[a-zA-Z0-9\\W]+}"};
        
        
        for (int i = 0; i < toFind.length; i++) {
            
            File file = new File("E:/Java projects/javaADV/javaADV/inlämning2/assignmentTwo/text.txt");
            
            Scanner sc = new Scanner(file);
            
            int num = 0;

            int specNum = 0;
            
            if (i == 3) {
                
                while (sc.hasNextLine()) {
                    
                    String specialChars = sc.nextLine();

                    specNum = specNum + numberOfSpecial(specialChars, toFind[i]);

                }
            }else{
                
                while (sc.hasNextLine()) {
                    String rdLine = sc.nextLine();
                    num++;
                    match(rdLine, toFind[i], num);
                }
                
                sc.close();
            }
            if (specNum != 0) {
                
                System.out.println(specNum);
            }

        }
    }

    private static int numberOfSpecial(String specialChars, String toFind) {

        Pattern pCount = Pattern.compile(toFind);
        Matcher mCount = pCount.matcher(specialChars);

        int specialCount = 0;

        while (mCount.find()) {
            if (mCount.group().length() != 0) {
                
                specialCount++;
            }
        }

        return specialCount;
    }

    public static void match(String x, String y, int count) {
        
        Pattern p = Pattern.compile(y);
        Matcher m = p.matcher(x);

        while (m.find()) {

            if (m.group().length() != 0){

                System.out.print("Found: " + m.group() + " ");
                System.out.print("Line: " + count + " ");
                System.out.print("Start at: " + m.start() + " ");
                System.out.println("Ends at: " + m.end());
            }
        }

    }
}
