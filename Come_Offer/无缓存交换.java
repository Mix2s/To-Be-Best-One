import java.util.*;

public class Exchange {
    public int[] exchangeAB(int[] AB) {
           Stack<Integer> stack = new Stack();
        stack.add(AB[0]);
        stack.add(AB[1]);
        AB[0] = stack.pop();
        AB[1] = stack.pop();
        return AB;
        /****
          AB[0]=AB[0]^AB[1];
       AB[1]=AB[0]^AB[1];
       AB[0]=AB[0]^AB[1];
       return AB;****/
        /*****
        AB[0]=AB[0]+AB[1];
        AB[1]=AB[0]-AB[1];
        AB[0]=AB[0]-AB[1];
        return AB;****/
    }
}
