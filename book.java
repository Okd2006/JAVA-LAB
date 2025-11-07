import java.util.*;
class Book{
    public String name;
    public String author;
    public int price;
    public int numpages;

    public Book( String name, String author, int price, int numpages){
        this.name=name;
        this.author=author;
        this.price=price;
        this.numpages=numpages;
    }
    public void setName( String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public String getAuthor(){
        return author;
    }
    public void setPrice(int price){
        this.price=price;
    }
    public int getPrice(){
        return price;
    }
    public void setPages( int numpages){
        this.numpages=numpages;
    }
    public int getPages(){
        return numpages;
    }
    public String toString(){
        return "Book name\n"+name+"\n Author \n"+author+"\n Price\n"+price+"\n Number of Pages\n"+numpages;
    }
}
public class BookDemo{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of book");
        int n=sc.nextInt();
        
        sc.nextLine();
        
        Book[] books=new Book[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter details of books"+(i+1)+":");
            System.out.println("Name: ");
            String name=sc.nextLine();
            System.out.println("Author: ");
            String author=sc.nextLine();
            System.out.println("Price: ");
            int price=sc.nextInt();
            System.out.println("Number of pages: ");
            int numpages=sc.nextInt();
            sc.nextLine();
            books[i]=new Book(name,author,price,numpages);
        }
        System.out.println("Book details::\n");
        for (Book b: books){
            System.out.println(b.toString());
        }
        sc.close();
        }
    }
