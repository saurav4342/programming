package project1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {
    public static void main(String [] args){
        int max = 0;
        int n =250;
        List<Long> c = Arrays.asList(41l, 34l, 46l, 9l, 37l, 32l, 42l, 21l, 7l, 13l, 1l, 24l, 3l, 43l, 2l, 23l, 8l, 45l, 19l, 30l, 29l, 18l, 35l, 11l);
       
        long [][] arr = new long[c.size()][n+1];
        for(int i=0;i<n+1;i++){
            if(i% c.get(0)==0){
                arr[0][i] = 1;
            }
            else{
                arr[0][i] = 0;
            }
        }
        for(int i=1;i<c.size();i++){
            for(int j=0;j<n+1;j++){
                if(j==0)arr[i][j]=1;
                else{
                    if(j<c.get(i)){
                        arr[i][j] = arr[i-1][j];
                    }
                    else{
                        arr[i][j] = arr[i-1][j]+arr[i][j-Math.toIntExact(c.get(i))];
                    }
                }
                
            }
        }
        System.out.println(arr[c.size()-1][n]);
    }
}
