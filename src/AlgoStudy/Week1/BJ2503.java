package AlgoStudy.Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2503 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N : ���� ���� (1 <= N <= 100)
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int[] strike = new int[N];
		int[] ball = new int[N];

		// ���� ���� �Է�
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num[i] = Integer.parseInt(st.nextToken());
			strike[i] = Integer.parseInt(st.nextToken());
			ball[i] = Integer.parseInt(st.nextToken());
		}

		int ans = 0;
		// 9 * 9 * 9 * 100 = 72900 => ���� Ž��
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				// ���� �ٸ� ���ڸ� ����
				if(i == j)
					continue;
				for (int k = 1; k <= 9; k++) {
					// ���� �ٸ� ���ڸ� ����
					if(k == i || k == j)
						continue;
					
					boolean isPossible = true;
					// ���� �� ��ŭ �ݺ�
					for(int q = 0; q < N; q++) {
						int s = 0, b = 0;
						int n = num[q];
						
						// �� �ڸ� ����
						int trd = n % 10;
						n /= 10;
						int scd = n % 10;
						n /= 10;
						int fir = n; 
						
						// ��Ʈ����ũ, �� �Ǵ�
						if(fir == i) s++;
						if(scd == j) s++;
						if(trd == k) s++;
						if(fir == j || fir == k) b++;
						if(scd == i || scd == k) b++;
						if(trd == i || trd == j) b++;
						
						// ���ڸ� ���� �������� �־��� ���� ���� strike, ball�� �ٸ��� ����
						if(strike[q] != s || ball[q] != b) {
							isPossible = false;
							break;
						}
					}
					
					if(isPossible)
						ans++;
				}
			}
		}
		
		System.out.println(ans);
	}

}
