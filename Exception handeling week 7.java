public class father {
    int fage;
    class WrongAge extends Exception{
        public WrongAge(String msg){
            super(msg);
        }
    }
    father(int fage) throws WrongAge{
        if(fage<0){
            throw new WrongAge("Father age cannot be negative");
        }
        this.fage=fage;
    }
}
class son extends father{
    int sage;

    son(int fage,int sage) throws father.WrongAge {
        super(fage);

        if(sage>=fage){
            throw new WrongAge("Son's age cannot be more than father");
        }
        this.sage=sage;
    }
}



import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter father's age: ");
        int fage = sc.nextInt();

        System.out.print("Enter son's age: ");
        int sage = sc.nextInt();

        try {
            son s = new son(fage, sage);
            System.out.println("Object created successfully!");
        } catch (father.WrongAge e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        sc.close();
    }
}

