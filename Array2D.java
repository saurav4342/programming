package project1;

import java.util.Scanner;

public class Array2D {
    static long arrayManipulation(int n, int[][] queries) {
            long [] arr = new long[n];
            for(int i=0; i<queries.length;i++){
                int a = queries[i][0] -1;
                int b = queries[i][1] -1;
                int k = queries[i][2];
                arr[a]+= k;
                if(b<n){
                    arr[b+1]-=k;
                }
            }
            long maxSum = 0, tempSum = 0;
            for(int i=0;i<n;i++){
                tempSum+=arr[i];
                if(tempSum>maxSum){
                    maxSum = tempSum;
                }
            }
    return maxSum;
        }
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
                
        //This will be the "difference array". The entry arr[i]=k indicates that arr[i] is exactly k units larger than arr[i-1]
        long[] arr = new long[n];
                
        int lower;
        int upper;
        long sum;

        for(int i=0;i<n;i++) arr[i]=0;

        for(int i=0;i<m;i++){
            lower=scan.nextInt();
            upper=scan.nextInt();
            sum=scan.nextInt();
            arr[lower-1]+=sum;
            if(upper<n) arr[upper]-=sum; 
        }
                
        long max=0;
        long temp=0;

        for(int i=0;i<n;i++){
            temp += arr[i];
            if(temp> max) max=temp;
        }

        System.out.println(max);
    }
}
