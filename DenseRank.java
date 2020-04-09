    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int scoresLength = scores.length;
        int [] rank = new int[alice.length];
        int i=0;
        int currNum=0;
        int k=0;
        int [] uniqueArr = new int[scores.length]; 
        for(int j=0;j<scores.length;j++){
            if(currNum!=scores[j]){
                uniqueArr[k] = scores[j];
                k++;
            }
            currNum = scores[j];
        }
        for(int num:alice){
            rank[i] = binarySearch(uniqueArr,num,0,k-1);
            i++;
        }
        return rank;
        }
    static int binarySearch(int[] scores,int num, int startIndex, int endIndex){
        if(num >= scores[startIndex]) return startIndex+1;
        if(num < scores[endIndex]) return endIndex+2;
        if((startIndex-endIndex)== -1){
            return startIndex+2;
            
        }
        int midpoint = (startIndex+endIndex)/2 ;
        if(scores[midpoint] == num){
            return midpoint+1;
        }
        
        if(num>scores[midpoint]){
            return binarySearch(scores,num,startIndex, midpoint);
        }
        else {
            return binarySearch(scores,num,midpoint, endIndex);
        }
       
    }