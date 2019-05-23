package src.javaTest;

public class day5232 {
    public static void main(String[] args) {
            String str = "()()()";
        System.out.println( chkParenthesis(str,4));
    }
    public static boolean chkParenthesis(String A, int n){
        if(n%2==1){
            return false;
        }
        char[] array = A.toCharArray();
        int top=0;
        char[] stack = new char[n];
        for(int i=0;i<n;i++) {
            if (top==0) {
                stack[top]=array[i];
                top++;
            } else {
                if (cc(stack[top-1], array[i])){
                        stack[top]='0';
                        top--;
                }else{
                    stack[top]=array[i];
                    top++;
                }
            }
        }
        if(top!=0){
            return false;
        }
        return true;
    }
    public static boolean cc(char a,char b){
        if(a=='('&&b==')'){
            return true;
        }
        return false;
    }
}

