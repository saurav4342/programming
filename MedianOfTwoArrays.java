package project1;

public class MedianOfTwoArrays {
    public static void main(String[] args) {
        int [] nums1 = {1,3,7,8};
        int [] nums2 = {2,4,5,9};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length+nums2.length;
           int nums[] = new int[n];
           int i=0,j=0;
           for(int k=0;k<n;k++){
               int x = Integer.MAX_VALUE;
               int y = Integer.MAX_VALUE;
               if(i<nums1.length){
                x = nums1[i];
               }
               if(j<nums2.length){
                   y = nums2[j];
               }
               
               if(x < y){
                   nums[k] = x;
                   i++;
               }
               else{
                   nums[k] = y;
                   j++;
               }
               
           }
          
           //System.out.println((nums[(n/2)-1]+nums[(n/2)])/2d);
           return n%2!=0?nums[((n+1)/2)-1]:(nums[(n/2)-1]+nums[(n/2)])/2d; 
       }
}
