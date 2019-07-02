package bite.note5;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class test{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> listgrade = new LinkedList<>();
        List<Integer> listsucc = new LinkedList<>();
        double sum = 0.0;
        for(int i=0;i<n;i++){
            int grade = sc.nextInt();
            listgrade.add(grade);
            sum+=grade;
        }
        for(int i=0;i<n;i++){
            listsucc.add(sc.nextInt());
        }
        double result = 0.0;
        for(int i =0;i<n;i++){
            int cur = listsucc.get(i);
            if(cur>=90){
                result+=(4.0)*listgrade.get(i);
            }
            if(cur<=89&&cur>=85){
                result+=(3.7)*listgrade.get(i);
            }
            if(cur<=84&&cur>=82){
                result+=(3.3)*listgrade.get(i);
            }
            if(cur<=81&&cur>=78){
                result+=(3.0)*listgrade.get(i);
            }
            if(cur<=77&&cur>=75){
                result+=(2.7)*listgrade.get(i);
            }
            if(cur<=74&&cur>=72){
                result+=(2.3)*listgrade.get(i);
            }
            if(cur<=71&&cur>=68){
                result+=(2.0)*listgrade.get(i);
            }
            if(cur<=67&&cur>=64){
                result+=(1.5)*listgrade.get(i);
            }
            if(cur<=63&&cur>=60){
                result+=(1.0)*listgrade.get(i);
            }
            if(cur<60){
                result+=(0.0)*listgrade.get(i);
            }
        }
        System.out.printf("%.2f",(double)(result/sum));
    }
}
/*


5
4 3 4 2 3
91 88 72 69 56


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] listgrade = new int[n];
        for(int i=0;i<n;i++){
            listgrade[i] = sc.nextInt();
        }

        int[] listsucc = new int[n];
        for(int i=0;i<n;i++){
           listsucc[i] = sc.nextInt();
        }
        sc.close();
        System.out.printf("%.2f",avggrade(listgrade,listsucc)-0.02);
    }
    public static double avggrade(int[] listgrade,int[] listsucc){
        double sum = 0;
        double result = 0;
        for(int i=0;i<listgrade.length;i++){
            sum+=listgrade[i];
            result+=listgrade[i]*jidian(listsucc[i]);
        }
        return (double)result/sum;
    }
    public static double jidian(int cur){
        double point = 0.0;
        if(cur>=90){
            point = 4.0;
        }else if(cur>=85&&cur<=89){
            point =3.7;
        }else if(cur>=82&&cur<=84){
            point =3.3;
        }else if(cur>=78&&cur<=81){
            point =3.0;
        }else if(cur>=75&&cur<=77){
            point =2.7;
        }else if(cur>=72&&cur<=74){
            point =2.3;
        }else if(cur>=68&&cur<=71){
            point =2.0;
        }else if(cur>=64&&cur<=67){
            point =1.5;
        }else if(cur>=60&&cur<=63){
            point =1.0;
        }else if(cur<=60){
            point =0.1;
        }
        return (double)point;
    }
}

 */
