package AlgoStudy.Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ21757 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] ary = new long[N + 1];	// �迭 �Է�
		long[] sum = new long[N + 1];	// �Էµ� �迭������ ��
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] cnt = new long[3];	// ���� ���� ���� �� �ִ� ����� ��(0: ù��° ��, 1: �ι�°��, 2: ����°��)
		long zeroCnt = 0;			// ���� 0�� �Ǵ� �� -> �� �κ��� ���� 0�϶� ���

		for (int i = 1; i <= N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
			sum[i] = ary[i] + sum[i - 1];
			if(sum[i] == 0)
				zeroCnt++;
		}
		// ��ü�� ���� 4�� ������ �������� ������ ���� ���� �� �������� ���� �� ����.
		if (sum[N] % 4 == 0) {
			long s = sum[N] / 4;

			// ���� 0�̶��
			if (s == 0) {
				long res;
				// �� ���������� ���� 0�� ���� n����� ���� ���� ���� �� �ִ� ���� n-1,
				// �� n-1���� ���� ���� �� �ִ� �� �߿��� 3���� ���ϸ� 4���� ���� ũ���� �������� ����������. 
				res = (zeroCnt-1)*(zeroCnt-2)*(zeroCnt-3)/6;
				cnt[2] = res;
			}
			// ���� 0�� �ƴ϶��
			// ���� ���� ������ ã���� �ش� �������� ���� �ߴ� ���� ���� ���� ������ ��� ���� �׾����� �ľ��Ͽ� �����ش�.
			else {
				for (int i = 1; i <= N; i++) {
					if (sum[i] == s)
						cnt[0]++;
					if (sum[i] == 2 * s)
						cnt[1] += cnt[0];
					if (sum[i] == 3 * s)
						cnt[2] += cnt[1];
				}
			}
		}

		System.out.println(cnt[2]);

	}

}
