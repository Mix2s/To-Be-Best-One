

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int stu = sc.nextInt();
            int order = sc.nextInt();
            LinkedList<String>[] numAndname = new LinkedList[101];
            for(int i=0;i<stu;i++){
                String name = sc.next();
                int grade = sc.nextInt();
                if(numAndname[grade]==null){
                    numAndname[grade] = new LinkedList<>();
                }
                numAndname[grade].addLast(name);
            }
            if(order==1){
                for(int i=0;i<=100;i++){
                    if(numAndname[i]!=null){
                        while(!numAndname[i].isEmpty()){
                            System.out.println(numAndname[i].pollFirst()+" "+i);
                        }
                    }
                }
            }
            if(order==0){
                for(int i=100;i>=0;i--){
                    if(numAndname[i]!=null){
                        while(!numAndname[i].isEmpty()){
                            System.out.println(numAndname[i].pollFirst()+" "+i);
                        }
                    }
                }
            }
        }
    }
}
