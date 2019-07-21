public class Solution {
    public int JumpFloorII(int target) {
        int ret = 1;
        for(int i=1;i<target;i++){
            ret = 2*ret;
        }
        return ret;
    }
}
