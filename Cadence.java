package project1;

public class Cadence {
    public static void main(String[] args){
        int[] arr = { 1, 2 ,5 ,-2, 6};
        //printMaxSum(arr);\
        new Cadence().getSum(arr);
    }
    static void printMaxSum(int[] arr){
        int finalSum = 0;
        int tempSum = 0;
        for(int i=0;i<arr.length;i++){
            tempSum+=arr[i];
            if(tempSum >finalSum)finalSum=tempSum;
            if(tempSum<0)tempSum=0;
        }
        System.out.println(finalSum);
    }
    
     void getSum(int []arrNew){
        //int [] arrNew = {1,2,3,4,5};
        funct(arrNew);
        System.out.println(arrNew[0]);
     }
    
    static void funct(int[] arrNew){
        arrNew[0] = 8;
        System.out.println("second function"+arrNew[0]);
    }
}
