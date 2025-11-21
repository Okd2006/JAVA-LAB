import CIE.Internals;
import SEE.External;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the number of students (n): ");
        int n = s.nextInt();

        
        External[] students = new External[n];
        Internals[] cieMarks = new Internals[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n=== Enter Details for Student " + (i + 1) + " ===");
            students[i] = new External();
            cieMarks[i] = new Internals();

            students[i].acceptDetails(s); 
            cieMarks[i].acceptMarks(s);   
            students[i].acceptMarks(s);  
        }

        
        System.out.println("\n\n======= FINAL STUDENT MARKS REPORT =======");
        for (int i = 0; i < n; i++) {
           
            students[i].displayDetails(); 

            System.out.println("Final Marks (CIE + SEE):");
            System.out.println("Subject\t\tCIE\tSEE\tFinal");
            System.out.println("------------------------------------------");
            
            for (int j = 0; j < 5; j++) {
             
                int finalMark = cieMarks[i].internalMarks[j] + students[i].seeMarks[j];
                
                System.out.println("Subject " + (j + 1) + "\t" +
                                   cieMarks[i].internalMarks[j] + "\t" +
                                   students[i].seeMarks[j] + "\t" +
                                   finalMark);
            }
        }
        
        s.close();
    }
}