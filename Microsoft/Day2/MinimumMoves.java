package Microsoft.Day2;

import java.util.Arrays;

class MinimumMoves{

    public static void main(String[] args) {
        MinimumMoves moves=new MinimumMoves();
        int[] nums={1,5,2,4};
int res=moves.minMoves2(nums);

        System.out.println("Minimum moves to equalize array: " + res);
}
     public int minMoves2(int[] nums){
         Arrays.sort(nums);

         int median=nums[nums.length>>1];

         int moves=0;

         for(int num:nums){
             moves+=Math.abs(num-median);
         }
         return moves;

     }
}
