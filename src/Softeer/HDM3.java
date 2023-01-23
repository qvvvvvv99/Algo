package Softeer;

import java.util.Scanner;

public class HDM3 {
	static int MOD = 1000000007;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int len = input.length();
		// input���� �� �� 13�� �������� �ʴ� ���� ����
		
		int[] num = new int[len];
		for(int i = 0; i < len; i++)
			num[i] = input.charAt(i)-'0';
		

		int[][] dp = new int[len + 1][10];
		// dp[i][j] -> i �ڸ����� ���� �� �ڸ��� j �϶� ������ ��
		// dp[i][0] = dp[i-1][0~9]
		// j�� 1���� ū ��� : dp[i][j] = dp[i][0]
		// j�� 1�� ��� = dp[i-1][0,1,2,4~9]
		// i == len�̰� input�� ���ڸ��� j�� ���
		for (int i = 0; i < 10; i++)
			dp[1][i] = 1;
		
		for (int i = 2; i < len; i++) {
			// ���ڸ� 0�� ���
			for (int j = 0; j < 10; j++)
				dp[i][0] += dp[i-1][j] % MOD;
			
			// ���ڸ� 1�� ���
			for (int j = 0; j < 10; j++) {
				if(j == 3)
					continue;
				dp[i][1] += dp[i-1][j] % MOD;
			}
			
			// ���ڸ� 1���� ū ���
			for(int j = 2; j < 10; j++)
				dp[i][j] = dp[i][0];
		}
		
		int left = num[0];
		// input ���� �迭
		// ���ڸ� 0
		for (int j = 0; j < 10; j++)
			dp[len][0] += dp[len-1][j] % MOD;
		// ���ڸ� 1
		for (int j = 0; j < 10; j++) {
			if(j == 3)
				continue;
			dp[len][1] += dp[len-1][j] % MOD;
		}
		// input�� ������ �� ������
		for (int j = 2; j < left; j++) 
			dp[len][j] = dp[len][0];
		
		// input�� ���ڸ��� ���� ���
		int res = 0;
		int curr, l = len;
		for(int idx = 0; idx <= len; idx++) {	// idx ��° ���ڸ� ���� �ִ�
			if(idx >= 2 && num[idx-2] == 1 && num[idx-1] == 3)
				break;
			if(idx == len) {
				res++;
				break;
			}
			curr = num[idx];
			for(int j = 0; j < curr; j++) {
				if(j == 3 && idx >= 1 && num[idx-1] == 1)
					continue;
				res += dp[l][j] % MOD;
			}
			l--;
		}

		System.out.println((res+MOD-1)%MOD);
	}

}
