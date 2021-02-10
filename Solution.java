package project1;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the climbingLeaderboard function below.
              static int[] climbingLeaderboard1(int[] scores, int[] alice) {
            Map<Integer,Integer> arrMap = new HashMap<Integer,Integer>();
            for(int i=0;i<alice.length;i++)
            arrMap.put(alice[i],i);
            Arrays.sort(alice);
            int lastIndex = alice.length-1;
            System.out.println(alice.toString());
            int [] rankArr = new int[alice.length];
            int i=0;
            int k=0;
           int currNum = 0;
            while(i<alice.length){
               int j=0;
                int skipCount = 0;
               
               while(j >-1){
                   if(j ==scores.length-1){
                       rankArr[k]=scores.length+1;
                       break;
                   }
                   if(currNum == scores[i+j])
                   {
                       skipCount++;
                   }
                   currNum = scores[i+j];
                   if(alice[lastIndex-k]>=scores[i+j]){
                       rankArr[k]=i+j+1-skipCount;
                       i=i+j;
                      
                       break;
                   }
                   else{
                       j++;
                   }
                       
               }
                i++;
                k++;
           }
            int [] finalRes = new int[alice.length];
            for(int x=0;x<alice.length;x++){
                finalRes[arrMap.get(alice[x])] = rankArr[x];
            }
            return finalRes;
       }
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int scoresLength = scores.length;
        int [] rank = new int[alice.length];
        int i=0;
        int currNum=0;
        int k=0;
        int [] uniqueArr = new int[scores.length]; 
        for(int j=0;j<scores.length;j++){
            if(currNum!=scores[j]){
                uniqueArr[k] = scores[j];
                k++;
            }
            currNum = scores[j];
        }
        for(int num:alice){
            rank[i] = binarySearch(uniqueArr,num,0,k-1);
            i++;
        }
        return rank;
        }
    static int binarySearch(int[] scores,int num, int startIndex, int endIndex){
        if(num >= scores[startIndex]) return startIndex+1;
        if(num < scores[endIndex]) return endIndex+2;
        if((startIndex-endIndex)== -1){
            return startIndex+2;
            
        }
        int midpoint = (startIndex+endIndex)/2 ;
        if(scores[midpoint] == num){
            return midpoint+1;
        }
        
        if(num>scores[midpoint]){
            return binarySearch(scores,num,startIndex, midpoint);
        }
        else {
            return binarySearch(scores,num,midpoint, endIndex);
        }
       
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard1(scores, alice);

//        for (int i = 0; i < result.length; i++) {
//            bufferedWriter.write(String.valueOf(result[i]));
//
//            if (i != result.length - 1) {
//                bufferedWriter.write("\n");
//            }
//        }
//
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
