package project1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRep {
    public static void main(String [] args){
        lengthOfLongestSubstring("abba");
    }
    public static int lengthOfLongestSubstring(String s) {
         int n = s.length();
         Map<Character,Integer> map = new HashMap<Character,Integer>();
         int j = 0;
         StringBuilder sb = new StringBuilder();
         int res = 0;
         
         for(int i=0;i<n;i++){
             if(map.containsKey(s.charAt(i))){
                 if(map.get(s.charAt(i))+1>j){
                    j = map.get(s.charAt(i))+1;
                 }
               
             }
             System.out.println(j+" "+i);
             map.put(s.charAt(i),i);
             //System.out.println(map.get(s.charAt(i)));
             if((i-j+1)>res) res = i-j+1;
             
         }
         return res;
       }
}
