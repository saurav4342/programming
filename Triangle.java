package project1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

public class Triangle {
   
   
        public int minimumTotal(List<List<Integer>> triangle) {
            int sumArr[][];
             int sum = Integer.MAX_VALUE;
            sumArr = new int[triangle.size()][triangle.size()];
            for(int i=0;i< triangle.size();i++){
                for(int j=0;j<triangle.size();j++){
                    sumArr[i][j] = Integer.MAX_VALUE;
                }
            }
            sumArr[0][0] = triangle.get(0).get(0);
            for(int i=0;i<triangle.size();i++){
                if(i < triangle.size()-1){
                for(int j=0;j<triangle.get(i).size();j++){
                    if(sumArr[i][j]+triangle.get(i+1).get(j)<sumArr[i+1][j]){
                    sumArr[i+1][j] = sumArr[i][j]+triangle.get(i+1).get(j);
                    
                    }
                    if(sumArr[i][j]+triangle.get(i+1).get(j+1)<sumArr[i+1][j+1]){
                    sumArr[i+1][j+1] = sumArr[i][j]+triangle.get(i+1).get(j+1);
                    }
                }
                }
                else{
                    for(int j=0;j<=i;j++){
                        if(sumArr[i][j]<sum){
                            sum = sumArr[i][j];
                        }
                    }
                }
            }
            return sum;
        }
        
  
}
