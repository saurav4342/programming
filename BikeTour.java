package project1;

import java.util.Scanner;

public class BikeTour {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();
        for(int i=0;i<t;i++){
            int n = in.nextInt();
            int [] arr = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = in.nextInt();
            }
            boolean peakStart = false;
            int prevHeight = 0;
            int counter=0;
            for(int k=1;k<n-1;k++){
                if(arr[k-1]<arr[k]&&arr[k]>arr[k+1]) counter++;
            }
            System.out.println("case #"+i+": "+counter);
        }
    }
}
