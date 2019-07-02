package bite.note5;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            double zhengmoney = sc.nextDouble();
            StringBuffer res = new StringBuffer();
            String[] money = new String[]{"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖", "拾"};
            int yi = (int) (zhengmoney / 100000000);
            int wan = (int) ((zhengmoney - yi * 1000000000) / 10000);
            int ge = (int) (zhengmoney - yi * 1000000000 - wan * 10000);
            System.out.print("人民币");
            if (yi != 0) {
                res.append(change(yi) + "亿");
            }
            if (wan != 0) {
                res.append(change(wan) + "万");
            }
            if (ge != 0) {
                res.append(change(ge) + "元");
            }
            int lingmoney = (int) ((zhengmoney - yi * 100000000 - wan * 10000 - ge + 0.001) * 100);

            int jiao = lingmoney / 10;
            int fen = lingmoney % 10;

            if (jiao != 0 && fen != 0) {
                res.append(money[jiao] + "角" + money[fen] + "分");
            } else if (jiao != 0 && fen == 0) {
                res.append(money[jiao] + "角");
            } else if (jiao == 0 && fen != 0) {
                res.append( money[fen] + "分");
            } else if (jiao == 0 && fen == 0) {
                res.append("整");
            }
            String strr = res.toString();
            System.out.println(strr);
        }
        sc.close();
    }
    public static String change(int a){
        String[] money = new String[]{"零","壹","贰","叁","肆","伍","陆","柒","捌","玖","拾"};
        int qian = a/1000;
        int bai = (a-qian*1000)/100;
        int shi = (a-bai*100-qian*1000)/10;
        int ge = a-qian*1000-bai*100-shi*10;

        StringBuffer sb = new StringBuffer();
        if(qian!=0){
            sb.append(money[qian]+"仟");
        }

        if(bai!=0){
            sb.append(money[bai]+"佰");
        }else if(qian!=0&&bai==0&&(shi!=0||ge!=0)){
            sb.append("零");
        }

        if(shi!=0&&shi!=1){
            sb.append(money[shi]+"拾");
        }else if(bai!=0&&ge!=0){
            sb.append("零");
        }

        if(shi==1&&qian==0&&bai==0){
            sb.append("拾");
        }

        if(ge!=0){
            sb.append(money[ge]);
        }
        return sb.toString();
    }
}
