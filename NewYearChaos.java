package project1;

import java.util.Scanner;
//1 2 5 3 7 8 6 4
//1 2 3 4 5 6 7 8
public class NewYearChaos {
        static int minimumSwaps(int[] arr) {
            int temp=0;
            int mSwaps = 0;
            for(int i =0 ; i<arr.length;i++){
               if(arr[i] != (i+1))
                   for(int j=i; j<arr.length;j++){
                       if(arr[j] == (i+1)){
                           temp = arr[j];
                           arr[j] = arr[i];
                           arr[i] = temp;
                           mSwaps++;
                           break;
                       }
                   }
            }
            return mSwaps;
            }
        
        static long arrayManipulation(int n, int[][] queries) {
            long maxNum = 0;
            
return 12231231;
           }

    static void minimumBribes(int[] q) {
        int minBribes = 0;
        boolean tooChaotic = false; 
        for(int i=1;i<=q.length;i++){
            if((q[i-1] - i) > 2){
            tooChaotic = true;
            break;
            }    
            if(( i - q[i-1]) > 0){
                minBribes+= i - q[i-1];
            }
        }
        if(tooChaotic){
            System.out.println("Too chaotic");
        }
        else{
        System.out.println(minBribes);
        }
    }
        

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            int t = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int tItr = 0; tItr < t; tItr++) {
                int n = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                int[] q = new int[n];

                String[] qItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int i = 0; i < n; i++) {
                    int qItem = Integer.parseInt(qItems[i]);
                    q[i] = qItem;
                }

                minimumBribes(q);
            }

            scanner.close();
        }
    }