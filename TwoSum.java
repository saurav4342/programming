package project1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
            Map<Integer,Integer> arrMap = new HashMap<Integer,Integer>();
            for(int i=0;i<alice.length;i++)
            arrMap.put(alice[i],i);
            Arrays.sort(alice);
            int lastIndex = alice.length-1;
            System.out.println(alice.toString());
            int [] rankArr = new int[alice.length];
            int i=0;
            int k=0;
            while(i<alice.length){
               int j=0;
                int skipCount = 0;
                int currNum = 0;
               while(j >-1){
                   if(j ==scores.length-1){
                       rankArr[k]=scores.length+1;
                       break;
                   }
                   if(currNum == scores[j])
                   {
                       skipCount++;
                   }
                   currNum = scores[j];
                   if(alice[lastIndex-i]>=scores[j]){
                       i=i+j+skipCount;
                       rankArr[k]=j+1;
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
                finalRes[arrMap.get(alice[x])] = alice[x];
            }
            return finalRes;
       }
  public static void main(String [] args){
            Scanner in = new Scanner(System.in);
            int t = in.nextInt();
            for(int i=0;i<t;i++){
                int n = in.nextInt();
                int [] arr = new int[n];
                for(int j=0;j<n;j++){
                    arr[j] = in.nextInt();
                }
                int counter = 0;
                boolean result = true;
                boolean startCounter = false;
                for(int j=0;j<arr.length;j++){
                    if(arr[j]==1 && counter==6)
                        counter = 0;
                    
                    if(arr[j]==1 && counter!=0){
                        result = false;
                        break;
                    }
                    
                    
                    if(arr[j]==1)
                    startCounter = true;
                    
                    if(startCounter == true)
                    counter++;
                    
                }
                System.out.println(result?"YES":"NO");
            }
        }
}
