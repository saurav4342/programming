package project1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Substring {
    public static void main(String [] args){
        String str = "abcd";
        Map <Integer,List<String>> map = new HashMap<Integer,List<String>>(); 
        for(int i=0;i<str.length();i++){
            for(int j=i;j<str.length();j++){
               String substr = str.substring(i, j+1);
                int len = substr.length();
                if(map.containsKey(len)){
                    map.get(len).add(substr);
                }
                else{
                    List<String> list = new ArrayList<String>();
                    list.add(substr);
                    map.put(len,list);    
                }
                
            }
           
        }
        for(int i=0;i<str.length();i++){
            
        }
    }
}
