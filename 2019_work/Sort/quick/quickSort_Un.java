package src.com.shuihui.sort;
/*
    非递归 实现快排
 */
public class quickSort_Un {
    public static void quickSort_Un(int[] array){
        //使用数组模拟栈
        int[] stack = new int[array.length*2];
        int top=0;
        int low=0;
        int high=array.length-1;
        int par = partion(array,low,high);      //先执行一次找出第一次的par
        if(par>low+1){    //判断左边 符合情况入栈 判断左边是否有两个值
            stack[top++] = low;         //先存左边后存右边
            stack[top++] = par-1;
        }
        if(par<high-1){        //判断右边 符合情况入栈
            stack[top++]=par+1;
            stack[top++] = high;
        }
        while(top>0){          //判断右边是否有两个值
           high = stack[top--];        //第一个元素为high
           par= stack[top--];
           par= partion(array,low,par);
            if(par>low+1){    //判断左边 符合情况入栈 判断左边是否有两个值
                stack[top++] = low;         //先存左边后存右边
                stack[top++] = par-1;
            }
            if(par<high-1){        //判断右边 符合情况入栈
                stack[top++]=par+1;
                stack[top++] = high;
            }
        }
    }

    public static int partion(int[] array,int low,int high){
        int tmp = array[low];
        while(low<high){
            while((low<high)&&array[high]>=tmp) {      //进入的条件当前面的值比目标小  从后面拿到比par小的值
                high--;
            }
            if(low==high){
                break;
            }else{
                array[low]=array[high];
            }

            while((low<high)&&array[low]<=tmp){            //进入条件找目标值大
                low++;
            }
            if(low==high){
                break;
            }else{
                array[high]=array[low];
            }
        }
        array[low]=tmp;
        return low;
    }
}
