class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if((nums[i]+nums[j])==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}
思路：
    1.遍历所有的两数之和情况找出符合情况的输出
