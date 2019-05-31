package src.day513;

public class question1 {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4};
        int[] b2 = multiply(A);
        for (int i :
                b2) {
            System.out.print(b2[i] + " ");
        }
    }

    public static int[] multiply(int[] A) {
        int len = A.length;
        int[] B = new int[len];
        B[0] = 1;
        for (int i = 1; i < len; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int tmp = 1;
        for (int j = len - 2; j >= 0; j--) {
            tmp *= A[j + 1];
            B[j] *= tmp;
        }
        return B;
    }
}
