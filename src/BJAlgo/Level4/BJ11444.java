package BJAlgo.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class BJ11444 {
	
	final static long MOD = 1000000007;
	public static long[][] origin = {{1, 1} , {1, 0}};	// �ʱⰪ�� �����ִ� ���
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		 *                n
		 *       | 1   1 |    | F(n+1)  F(n)  |
		 * A^n = |       |  = |               |
		 *       | 1   0 |    |  F(n)  F(n-1) |
		 */
		
		long[][] A = {{1, 1} , {1, 0}};
		
		
		long N = Long.parseLong(br.readLine());
		
		
		// Fn �� ���Ϸ���  A����� n-1���� �� �� ��ȯ�� ��� A11 ���Ҹ� ����ϸ� �ȴ�.
		
		System.out.println(pow(A, N - 1)[0][0]);
	}
	
	// ��� ���� �������� �޼ҵ�
	public static long[][] pow(long[][] A, long exp) {
 
		// ������ 1 �Ǵ� 0�� �� A�� return�Ѵ�.
		if(exp == 1 || exp == 0) {
			return A;
		}
		
		// ������ �������� �����Ͽ� ���ȣ��
		long[][] ret = pow(A, exp / 2);
		
		// ���� ��Ϳ��� ���� ����� �������ش�.
		ret = multiply(ret, ret);
		
		// ���� ������ Ȧ����� ��������  A^1 (origin)�� �����ش�.
		if(exp % 2 == 1L) {
			ret = multiply(ret, origin);
		}
		
		return ret;
	}
	
	
	// o1�� o2 ����� �����ִ� �޼ҵ�
	public static long[][] multiply(long[][] o1, long[][] o2) {
		
		long[][] ret = new long[2][2];
 
		ret[0][0] = ((o1[0][0] * o2[0][0]) + (o1[0][1] * o2[1][0])) % MOD;
		ret[0][1] = ((o1[0][0] * o2[0][1]) + (o1[0][1] * o2[1][1])) % MOD;
		ret[1][0] = ((o1[1][0] * o2[0][0]) + (o1[1][1] * o2[1][0])) % MOD;
		ret[1][1] = ((o1[1][0] * o2[0][1]) + (o1[1][1] * o2[1][1])) % MOD;
 
		
		// �ݺ������� �ۼ����־ ������
		/*
		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < 2; i++) {							
				for (int j = 0; j < 2; j++) {
					ret[i][j] += o1[i][k] * o2[k][j];
					ret[i][j] %= MOD;
				}
			}
		}
		*/
		return ret;
	}
 
}
