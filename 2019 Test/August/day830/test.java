package main.sort;

public class test {
    public static void main(String[] args) {
        String s1 = "asdfghjqweryulase";
        String s2 = "astyfrtfghjqwsa";
        int index = 0;
        int max = 0;
        int count = 0;
        for(int i=0;i<s1.length();i++){
             count= 0;
             index = 0;
            for(int j=0;j<s2.length();j++){
                int s1i = i;
                int s2j = j;
               while (s1i<s1.length()&&s2j<s2.length()){
                   if(s1.charAt(s1i)==s2.charAt(s2j)){
                       count++;
                   }
                   s1i++;
                   s2j++;
               }
            }
            if(count>max){
                max = count;
                index = i;
            }
        }
        System.out.println(max);
    }
}
