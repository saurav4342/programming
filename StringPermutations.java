package project1;

public class StringPermutations {
    static char [] arr = {'A','B','C','D'};
    public static void main(String[] args) {
        StringPermutations stringPermutations = new StringPermutations();
        permutate(arr,0,arr.length);
    }
    
    public static void permutate(char[] strArr, int start, int end){
        if(start == (arr.length)-1){
            System.out.println(arr);
            //return;
        }
        for(int i=start;i<end;i++){
            swap(start,i);
            permutate(strArr,start+1,end);
            swap(start,i);
        }
    }
    public static void swap(int a,int b){
        char temp = arr[a];
        arr [a] = arr[b];
        arr[b] = temp;
    }
}
