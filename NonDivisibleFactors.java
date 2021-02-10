package project1;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    // Write your code here
public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        int maxSizeOfSubset = 0;
       Set<Integer> nonDivSet = new HashSet<Integer>();
        List<Integer> nonDivList = new ArrayList<Integer>();
        for (int i = 0; i < s.size(); i++) {

           nonDivSet.add(s.get(i)%k);
            nonDivList.add(s.get(i));
            for (int j = 0; j < s.size(); j++) {
                boolean isDiv = true;
                if (i != j) {
                    if ((s.get(i) + s.get(j)) % k != 0) {
//                        for (int num : nonDivSet) {
//                            if ((s.get(j) + num) % k == 0) {
//                                isDiv = false;
//                                break;
//                            }
//                        }
                        if(s.get(j)%k==0){
                            if(nonDivSet.contains(0)){
                                isDiv=false;
                            }
                        }
                        else{
                            if(nonDivSet.contains(k-(s.get(j)%k))){
                               isDiv = false;
                            }
                        }
                        if (isDiv){
                            nonDivSet.add(s.get(j)%k);
                           // arr[(s.get(j)%k)*arr[s.get(j)%k]]++;
                            nonDivList.add(s.get(j));
                            }
                    }
                }
            }
            if (maxSizeOfSubset < nonDivList.size()) {
                maxSizeOfSubset = nonDivList.size();
            }
            nonDivList = new ArrayList<Integer>();
            nonDivSet = new HashSet<Integer>();
        }

        return maxSizeOfSubset;
    }
    

}

public class NonDivisibleFactors {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.nonDivisibleSubset(k, s);
System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}

