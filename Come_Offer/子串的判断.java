import java.util.*;

public class Substr {
    public boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
         boolean[] aa = new boolean[n];
        for(int i=0;i<n;i++){
            aa[i] = (s.indexOf(p[i])!=-1)?true:false;
        }
        return aa;
    }
}
