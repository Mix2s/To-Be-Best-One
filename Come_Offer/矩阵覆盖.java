public class Solution {
    public int RectCover(int target) {
        /*
        经过实测画图 斐波那契数列
        当 target==1 1
           target==2  2
           target==3  3
           target==4  5
        */
        if(target<=0){
            return 0;
        }
      if(target==1){
          return 1;
      }else if(target==2){
          return 2;
      }else{
          return RectCover(target-1)+RectCover(target-2);
      }
    }
}

总结：
    1.斐波那契
