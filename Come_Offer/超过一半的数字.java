package Everyday;

public class halfArratNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,2,2,2,5,4,2};
        System.out.println(More(arr));
    }
    public static int More(int [] array) {
        if(array.length==0){
            return 0;
        }
        for(int i=0;i<array.length;i++){
            int count = 1;
            for(int j=i+1;j<array.length;j++){
                if(array[i]-array[j]==0){
                    count++;
                }
            }
            if(count>(array.length/2)){
                return array[i];
            }
        }
        return 0;
    }
}
