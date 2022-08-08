package AlgoStudy.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1027 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] height = new int[N + 1];
		float[][] lean = new float[N + 2][N + 2];
		int max = 0;
		float l;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			height[i] = Integer.parseInt(st.nextToken());
		// x ��ǥ�� ���Ͽ� �� ��ǥ�� ���⸦ ��Ÿ���� ������ �迭 �����
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				l = (float)(height[j] - height[i]) / (j - i);
				lean[i][j] = l;
				lean[j][i] = l;
			}
		}

		if (N == 1)
			max = 0;
		else if (N == 2)
			max = 1;
		else {
			// �ִ� 50���� �ǹ��� ���Ͽ� �� �� �ִ� �ǹ��� ���� ���Ѵ�.
			// ���� ������ �迭�� ���� ���Ⱑ �����ϴ� ���� �ľ� (���Ƶ� �ȵ�)
			for (int i = 1; i <= N; i++) {
				int cnt;
				if (i > 1 && i < N)
					cnt = 2;
				else
					cnt = 1;
				l = lean[i][i - 1];
				// �������� ������ ���� Ž��
				for (int j = i - 2; j > 0; j--) {
					if (lean[i][j] < l) {
						cnt++;
						l = lean[i][j];
					}
				}
				l = lean[i][i + 1];
				for (int j = i + 2; j <= N; j++) {
					if (lean[i][j] > l) {
						cnt++;
						l = lean[i][j];
					}
				}
				// ���� �����ϴ� Ƚ���� ���� ���� ���� �ǹ��� �� �� �ִ� ��
				max = Math.max(max, cnt);
			}

		}
		System.out.println(max);
	}

}
