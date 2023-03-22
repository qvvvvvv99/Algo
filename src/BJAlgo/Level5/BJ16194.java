package BJAlgo.Level5;

import java.util.*;

public class BJ16194 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] p = new int[1001]; // ī���� p[i] : i�� ī�尡 ����ִ� ī����.
        int[] D = new int[10001]; //
        for(int i = 1; i <= N; i++)
            p[i] = sc.nextInt();

        // ī�� 1������ N������. ( Bottom-Up ��� )
        for(int i = 1; i <= N; i++){
            D[i] = p[i]; // �ּҰ� �ʱ�ȭ.
            // d[i] = -1;
            for(int j = 1; j <= i; j++){
                D[i] = Math.min(D[i], D[i-j]+p[j]);
                // if (d[i] == -1 || d[i] > d[i-j] + a[j]) {
                //     d[i] = d[i-j] + a[j];
                // }
            }
        }

        System.out.println(D[N]);
        sc.close();
    }
}