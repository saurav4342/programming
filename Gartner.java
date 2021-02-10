package project1;

public class Gartner {
    public static void main(String[] args){
        Gartner g = new Gartner();
        g.addByMulti(5, 6);
        g.addByDiv(4, 7);
        }
    public  void addByMulti(int a, int b){
        int sum=0;
        for(int i=0;i<b;i++){
            sum+=a;
        }
        System.out.println(sum);
    }
    
    public void addByDiv(int a , int b){
        int sum = 0;
        int c = 0;
        boolean flag = true;
        while(flag){
            if(sum==a){
                System.out.println(c);
                break;
            }
            sum+=b;
            c++;
        }
    }
}
