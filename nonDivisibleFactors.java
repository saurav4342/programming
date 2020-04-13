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
