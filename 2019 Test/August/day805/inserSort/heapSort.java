package main.SortPackge.inserSort;

public class heapSort {
    public static void main(String[] args) {
        int[] a = new int[]{32,43,16,13,21,2};
        heapSort(a);
    }

    public static void heapSort(int[] a){
        int len = a.length;   //数组长度
        int index = len-1;      //数组下标
        for(int i=(index-1)/2;i>=0;i--){    //heap堆的根节点子节点-1/2
            adjust(a,i,len-1);
        }
        for(int i=0;i<len-1;i++){
            int tmp = a[0];
            a[0] = a[len-1-i];
            a[len-1-i] = tmp;
            adjust(a,0,a.length-1-i);
        }
    }

    private static void adjust(int[] a, int start, int end) {
        int tmp = a[start];
        for(int i=2*start-1;i<=end;i=2*i+1){
            if((i<end)&&(a[i]<a[i+1])){         //如果左子树小于右子树i++拿到右子树下标否则就是左子树
                i++;
            }
            if(a[i]>tmp){    //当前子树的节点大于根节点
                a[start] = a[i];
                start = i;  //将下标移动到子树 比较子树为根节点的数调整为大根堆
            }else if(a[i]<tmp){
                break;
            }
        }
        a[start] = tmp;
    }
}
