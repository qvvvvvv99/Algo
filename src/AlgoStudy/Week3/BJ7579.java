package AlgoStudy.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ7579 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] m = new int[N + 1];
		int[] c = new int[N + 1];
		// �� ��� ����
		int cost = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			m[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			c[i] = Integer.parseInt(st.nextToken());
			cost += c[i];
		}

		// �޸� ũ�⿡ ���� �ּ��� ��� -> M�� ũ�Ⱑ �ſ� ũ�⿡ ���� �ݺ� �䱸
		// ��뿡 ���� Ȯ�� ������ �ִ� �޸� ũ��
		// ��ȭ�� : dp[cost] = max(dp[cost], dp[cost - c[i]] + m[i])
		int dp[] = new int[cost + 1];
		for (int i = 1; i <= N; i++) {
			// ���� c[0] -> cost ������ �����Ѵٸ�, i��° app�� ���� �� ���.
			// �������� �����ؾ� dp[j-c[i]]�� i��° app�� ������� ���� cost.
			for (int j = cost; j >= c[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - c[i]] + m[i]);
			}
		}
		
		// ��뿡 ���� Ȯ�������� �ִ��� �޸� ũ�⸦ ������ dp �迭���� ���� ���� M �̻��� �޸𸮸� ������ ����� �ּ� ����� �ȴ�.
		int res;
		for(res = 0; res <= cost; res++) {
			if(dp[res] >= M)
				break;
		}
		
		System.out.println(res);
	}

}
