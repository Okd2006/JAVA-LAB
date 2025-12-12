class BMS extends Thread{
    public void run(){
        int c=0;
        while(c<5){
            System.out.println("BMS college of Engineering");
            try{
                Thread.sleep(10000);
                c++;
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
class CSE extends Thread{
    public void run(){
        int count=0;
        while(count<5){
            System.out.println("CSE");
            try{
                Thread.sleep(2000);
                count++;
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
public class ThreadDemo{
    public static void main(String[] args){
        BMS t1=new BMS();
        CSE t2=new CSE();
        t1.start();
        t2.start();

    }
}
