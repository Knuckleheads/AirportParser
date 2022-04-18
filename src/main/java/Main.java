import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        String csvFile = args[0];

        int mode;
        Scanner sc = new Scanner(System.in);
        System.out.println("Select operating mode: \n0 -" +
                "use standard column (2)\n1 - enter the column yourself");
        mode = sc.nextInt();
            switch (mode) {
                case (0):
                    System.out.println("Enter a search string");
                    String needValue = sc.next();
                    print(csvFile, needValue);
                    break;

                case (1):
                    System.out.println("Enter the desired column starting from zero");
                    int needColumn = sc.nextInt();
                   // while(needColumn > 13 ||)
                    System.out.println("Enter a search string");
                    String needValue1 = sc.next();
                    print(csvFile, needColumn, needValue1);
                    break;
                default:
                    System.out.println("There is no such mode of operation.");
            }
        }
    public static void print(String csvFile, int needColumn, String needValue) throws IOException {
        Parser parser = new Parser();
        int count = 0;
        long startTime = System.nanoTime();
        for(String str : parser.parseCsv(csvFile, needValue, needColumn)){
            System.out.println(str);
            count++;
        }
        long finishTime = System.nanoTime();
        System.out.println("Time spent searching: " + ((finishTime - startTime) / 1000000D) );
        if(count > 0) System.out.println("Number of lines found: " + count);
        else System.out.println("There are no found lines");
    }
    public static void print(String csvFile, String needValue) throws IOException {
        Parser parser = new Parser();
        int count = 0;
        long startTime = System.nanoTime();
        for(String str : parser.parseCsv(csvFile, needValue)){
            System.out.println(str);
            count++;
        }
        long finishTime = System.nanoTime();
        System.out.println("Time spent searching: " + ((finishTime - startTime) / 1000000D) );
        if(count > 0) System.out.println("Number of lines found: " + count);
        else System.out.println("There are no found lines");
    }
}








