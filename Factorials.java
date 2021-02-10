package project1;

import java.math.BigInteger;

import java.util.Scanner;

public class Factorials {
    static void extraLongFactorials(int n) {
            BigInteger bigInt = new BigInteger("1");
            for(int i=2;i<=n;i++){
                bigInt = bigInt.multiply(BigInteger.valueOf(i));
            }
            System.out.println(bigInt);
       }

       private static final Scanner scanner = new Scanner(System.in);

       public static void main(String[] args) {
           int n = scanner.nextInt();
           scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

           extraLongFactorials(n);

           scanner.close();
       }
}
