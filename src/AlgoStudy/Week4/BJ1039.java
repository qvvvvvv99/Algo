package AlgoStudy.Week4;

import java.util.Arrays;
import java.util.Scanner;

public class BJ1039 {
	static int N, K, length, res;
	static boolean flag = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		length = (int) (Math.log10(N) + 1);
		res = 0;

		int[] num = new int[length];
		for (int i = length - 1; i >= 0; i--) {
			num[i] = N % 10;
			N /= 10;
		}
		
		int[] distinct = Arrays.stream(num).distinct().toArray();
		if(distinct.length != num.length)
			flag = true;

		// ���� �Ұ����� ����
		// 1. ���ڸ� ����
		if (length == 1)
			res = -1;
		// 2. ���ڸ� �����ε� �����ڸ��� 0�� ���
		if (length == 2 && num[1] == 0)
			res = -1;
		if (res == 0) {
			// ������ ��Ģ ã�⿡�� ���� ���ڿ��� ��� �ڸ����� ���ڸ� �����ϴ� ��쿡 �پ��� ���� ���� �߻�
			// -> DFS Ž������ ������ ū���� �ش��ϴ� ��� �� Ž�� : �ð����⵵(5!)
//			int max, idx;
//			for (int i = 1; i <= K; i++) {
//				// ���� ���� �迭�� �ִ��� ������ ����
//				if (digit < length) {
//					max = 0;
//					idx = digit;
//					for (int d = digit; d < length; d++) {
//						if (max <= num[d]) {
//							max = num[d];
//							idx = d;
//						}
//					}
//					if (max == num[digit]) {
//						digit++;
//						i--;
//					} else {
//						int temp = num[digit];
//						num[digit] = num[idx];
//						num[idx] = temp;
//					}
//				}
//				// ���� �迭�� �ִ��� ������ �� �� �߰����� �ڸ� ����
//				else {
//					int temp = num[length - 1];
//					num[length - 1] = num[length - 2];
//					num[length - 2] = temp;
//				}
//			}

			dfs(num, 0, 0);
		}

		System.out.println(res);
	}

	static void dfs(int[] num, int digit, int cnt) {
		if (cnt == K || cnt == length) {
			int n = 0;
			for (int i = 0; i < length; i++) {
				n *= 10;
				n += num[i];
			}
			if (n > res)
				res = n;
			return;
		}
		int max;
		if (digit < length -1) {
			max = 0;
			for (int d = digit; d < length; d++) {
				if (max < num[d])
					max = num[d];
			}
			if (max == num[digit])
				dfs(num, digit + 1, cnt);
			else {
				for (int i = digit + 1; i < length; i++) {
					if(num[i] == max) {
						int[] temp = num.clone();
						temp[i] = num[digit];
						temp[digit] = num[i];
						dfs(temp, digit+1, cnt+1);
					}
				}
			}
		}
		else {
			if(flag) {	// �ߺ��� ���ڰ� �־ �ش� ���ڸ� ��� �ݺ��ؼ� �����ϸ� �ǹǷ� �ִ밪�� ��ȭ�� ����.
				dfs(num, digit, K);
			}
			else {
				if((K - cnt)%2 == 0)
					dfs(num, digit, K);
				else {
					int[] temp = num.clone();
					temp[length - 1] = num[length - 2];
					temp[length - 2] = num[length - 1];
					dfs(temp, digit, K);
				}
			}
		}
	}
}
