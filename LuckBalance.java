package project1;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LuckBalance {
    
    static int alternatingCharacters(String s) {
           char currentChar = s.charAt(0);
           int deletions = 0;
           for(int i=1;i<s.length();i++){
               if(s.charAt(i) == currentChar){
                   deletions++;
               }
               else{
                   currentChar = s.charAt(i);
               }
           }
        return deletions;
       }
    static int maxSubsetSum(int[] arr) {
        int sum=0;
        for(int i=0;i<arr.length;i++){
            int tempSum = 0;
            if(arr[i]>0){
                getSum(arr,i, tempSum);
            }
        }
return 0;
       }
   static void getSum(int[] arr, int index, int sum){
       int [] arrNew = {1,2,3,4,5};
       funct(arrNew);
       System.out.println(arrNew);
    }
   
   static void funct(int[] arrNew){
       arrNew[0] = 8;
   }
                            
    static String isValid(String s) {
    Map<Character,Integer> count = new HashMap<Character,Integer>(); 
    int c1 = 0;
    int c2 = 0;
    for(int i=0;i<s.length();i++){
        char c = s.charAt(i);
        if(count.containsKey(c)){
            count.put(c, count.get(c)+1);
        }
        else{
            count.put(c,1);
        }
    }
    Map<Integer,Integer> compare = new HashMap<Integer,Integer>();
    for(char a:count.keySet()){
        int c = count.get(a);
        if(compare.containsKey(c)){
            compare.put(c, compare.get(c)+1);
        }
        else{
            compare.put(c, 1);
        }
    }
    if(compare.keySet().size() > 2){
        return "NO";
    }
    else if(compare.keySet().size() == 1 ){
        return "YES";
    }
    int co1=0,co2=0;
    for(int a:compare.keySet()){
        if(c1==0){c1 = compare.get(a);co1=a;}
        else {c2 = compare.get(a);co2=a;}
    }
    if(c1 >= c2){
        if(c2==1 && Math.abs(co1-co2)==1){
            return "YES";
        }
        else if(c2==1 && co2 ==1){
            return "YES";
        }
    }
    else{
        if(c1==1 && Math.abs(co2-co1)==1){
            return "YES";
        }
        else if(c1==1 && co1==1){
            return "YES";
        }
    }
    return "NO";
       }
    static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c);
        int minCost = 0;
        if(c.length <= k)
        {
            for(int i =0; i<c.length; i++){
                minCost += c[i];
            }
        }
        else{
            int multiplier = 0;
            int counter = 0;
            int n = c.length;
            for(int i=0; i<c.length; i++){
                minCost = minCost+ (multiplier+1)*c[n-1-i];
                counter++;
                if(counter%k == 0){
                    multiplier++;
                }
            }
        }
        return minCost;
    }


    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
    int luckBalance = 0;
    int [] impContest = new int[contests.length];
     int arrIndex = 0;
     for(int i=0;i<contests.length;i++){
         if(contests[i][1] == 0){
             luckBalance+=contests[i][0];
         }
         else{
             impContest[arrIndex]=contests[i][0];
             arrIndex++;
         }
     }
     for(int i =0;i<k;i++){
         int largest = impContest[0];
         int largestIndex = 0;
         for(int j=1;j<impContest.length;j++){
             if(impContest[j]>largest){
                 largest = impContest[j];
                 largestIndex = j;
             }
         }
         System.out.println(largest);
         impContest[largestIndex] = -1;
         luckBalance+=largest;
     }
     for(int i=0;i<impContest.length;i++){
         if(impContest[i]!= -1){
             luckBalance-= impContest[i];
         }
     }
     return luckBalance;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

