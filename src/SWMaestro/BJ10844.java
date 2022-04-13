package SWMaestro;

import java.util.Scanner;

public class BJ10844 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		long mod = 1000000000;
		long[][] dp = new long[N + 1][10];
		
		// ù ��° �ڸ����� ������ �� ���� �ڸ����̹Ƿ� ����� ���� 1���ۿ� ���� 
		for(int i = 1; i < 10; i++) {
			dp[1][i] = 1; 
		}
				
		// �� ��° �ڸ������� N���� Ž�� 
		for(int i = 2; i <= N; i++) {
					
			// i��° �ڸ����� �ڸ������� Ž�� (0~9) 
			for(int j = 0; j < 10; j++) {
						
				// j=0, �� �ڸ����� 0�̶�� ���� �ڸ����� ù��° �ڸ����� ���� 
				if(j == 0) {
					dp[i][0] = dp[i - 1][1]%mod;
				}
				// j=9��� ���� �ڸ����� 8�� ����
				else if (j == 9) {
					dp[i][9] = dp[i - 1][8]%mod;
				}
				// �� ���� ��� ���� �ڸ����� �ڸ��� +1, -1 �� ���� �� 
				else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1])%mod;
				}
			}
		}
		
		long sum = 0;
		for(int i = 0; i < 10; i++)
			sum+=dp[N][i];
		
		System.out.println(sum%mod);
	}

}
