package everyday;

import java.util.Scanner;

public class day6102 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            int n = sc.nextInt();
            dna(str,n);
        }
    }
    public static void dna(String str,int n){
        char[] arr = str.toCharArray();
        char[] tt = new char[5];
        int tmp = 0;
        for(int i=0;i<arr.length-5;i++){
            int count = 0;
            if(arr[i]=='G'||arr[i]=='C'){
                for(int j=i;j<i+5;j++){
                    if(arr[j]=='G'||arr[j]=='C'){
                        count++;
                    }
                }
                if(count>tmp){
                    tmp = count;
                    int k = i;
                    for(int j=i;j<i+5;j++){
                        tt[j-k] = arr[j];
                    }
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<5;i++){
            sb.append(tt[i]);
        }
        System.out.println(sb);
    }
}
//AACTGTGCACGACCTGA
//        5
