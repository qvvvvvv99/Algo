package BJAlgo.Level2;

import java.util.Scanner;

// good idea!!!
public class BJ2839 {
	public static void main(String[] args) {
	    
		Scanner in = new Scanner(System.in);
        
		int N = in.nextInt();
		
		// 5�� 3�� ������ ������ ������ ��Ÿ���� ���ϴ� ���� 4�� 7���̴�!!
		if (N == 4 || N == 7) {
			System.out.println(-1);
		}
		else if (N % 5 == 0) {
			System.out.println(N / 5);
		}
		else if (N % 5 == 1 || N % 5 == 3) {
			System.out.println((N / 5) + 1);
		}
		else if (N % 5 == 2 || N % 5 == 4) {
			System.out.println((N / 5) + 2);
		}
	}
}
