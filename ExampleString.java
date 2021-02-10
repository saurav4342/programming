package project1;

public class ExampleString {
    public static void main(String[] args) {
        ExampleString exampleString = new ExampleString();
        String s = "How are you";
        int index = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                //index = i;
                for(int j=i;j>=index;j--){
                    System.out.println(s.charAt(j));
                        
                }
                index = i+1;
            }
        }
    }
}
