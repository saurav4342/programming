package project1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EncodeDecode {
    public static void main(String[] args){
        int input = 2;
        String str = "oppeeen";
        int key = 123;
       // driverMethod(input, str, key);
        int [] arr = {4,3,2,-5};
       
        //System.out.println(findQualifiedNumbers(arr));
        //System.out.println(requiredAmountAtStart(arr));
    }
    
    public static int requiredAmountAtStart(List<Integer> netSaving) {
        int sum = 0;
        int res = 0;
        for(int i=0;i<netSaving.size();i++){
            sum+=netSaving.get(i);
            if(sum<0){
                res+=1-sum;
            }
        }
        return res;
        }
    static String findQualifiedNumbers(int[] numberArray) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<numberArray.length;i++){
            String str = String.valueOf(numberArray[i]);
            if(str.indexOf("1")!=-1 && str.indexOf("2")!=-1&&str.indexOf("3")!=-1){
                res.add(Integer.parseInt(str));
            }
        }
        Collections.sort(res);
        StringBuilder strB = new StringBuilder();
        for(int i=0;i<res.size();i++){
            
            strB.append(res.get(i));
            if(i<res.size()-1){
                strB.append(",");
            }
        }
        if(res.size()!=0){
        return strB.toString();
        }
        else{
            return "-1";
        }
       }
    public static void driverMethod(int input, String str, int key){
        if(input == 1){
            encode(str, key);
        }
        else{
            decode(str,key);
        }
    }
    
    public static void encode(String str, int key){
        String keyStr = String.valueOf(key);
        StringBuilder res = new StringBuilder();
        int repValue = 0;
        for(int i =0; i<str.length();i++){
            if(i<keyStr.length()){
            Character c = keyStr.charAt(i);
                repValue = Character.getNumericValue(c);
            }
            else{
                repValue = 1;
            }
            for(int j=0;j<repValue;j++){
                res.append(str.charAt(i));
            }
        }
        System.out.println(res.toString());
    }
    public static void decode(String str, int key){
        String keyStr = String.valueOf(key);
        StringBuilder res = new StringBuilder();
        int repValue = 0;
        int j=0,i = 0;
       while(i<str.length()){
            res.append(str.charAt(i));
           
            if(j<keyStr.length()){
            i=i+Character.getNumericValue(keyStr.charAt(j));
            }
            else i++;
            j++;
        }
        System.out.println(res.toString());
    }
}
