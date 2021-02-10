package project1;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
    Map<String,Integer> map = new HashMap<String,Integer>();
    for(String word: magazine){
        if(map.containsKey(word)){
            int count = map.get(word);
            map.put(word,count+1);
        }
        else{
            map.put(word,1);
        }
    }
    boolean result = true;
    for(int i=0;i<note.length;i++){
        if(map.containsKey(note[i]) && map.get(note[i])>0){
            map.put(note[i],map.get(note[i])-1);
            continue;
        }
        else{
            result = false;
            break;
        }
    }
    System.out.println(result?"Yes":"No");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}

