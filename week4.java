import java.util.*;
abstract class shape{
    int a,b;
    shape(int a,int b){
        this.a=a;
        this.b=b;
    }
    abstract void printarea();
}
class rectangle extends shape{
    rectangle(int length,int width){
        super(length,width);
    }
    void printarea(){
        System.out.println("Area of rectangle: "+(a*b));
    }
}
class triangle extends shape{
    triangle(int base,int height){
        super(base,height);
    }
    void printarea(){
        System.out.println("Area of triangle: "+(0.5*a*b));
    }
}
class circle extends shape{
    circle(int radius){
        super(radius,0);
    }
    void printarea(){
        System.out.println("Area of circle: "+(3.14*a*a));
    }
}
class Demo{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length and width of rectangle:");
        int length=sc.nextInt();
        int width=sc.nextInt();
        rectangle r=new rectangle(length,width);
        r.printarea();
        System.out.println("Enter the base and height of triangle:");
        int base=sc.nextInt();
        int height=sc.nextInt();
        triangle t=new triangle(base,height);
        t.printarea();
        System.out.println("Enter the radius of circle:");
        int radius=sc.nextInt();
        circle c=new circle(radius);
        c.printarea();


    }
}
