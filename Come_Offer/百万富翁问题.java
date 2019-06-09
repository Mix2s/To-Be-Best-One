package everyday;

public class day6101 {
    public static void main(String[] args) {
        int fuhao = 10;
        for(int i = 1;i<=29;i++){
            fuhao+=10;
        }
        int moshengren = 1;
        int sum = 1;
        for(int i=0;i<29;i++){
            moshengren*=2;
            sum+=moshengren;
        }
        System.out.print(fuhao+" "+sum);

    }
}
