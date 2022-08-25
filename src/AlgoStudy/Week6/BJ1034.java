package AlgoStudy.Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1034 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] lamp = new int[N][M];
		String line;
		int[] zeroCnt = new int[N];

		for (int i = 0; i < N; i++) {
			line = br.readLine();
			for (int j = 0; j < M; j++) {
				lamp[i][j] = line.charAt(j) - '0';
				if (lamp[i][j] == 0) {
					zeroCnt[i]++;
				}
			}
		}

		int K = Integer.parseInt(br.readLine());
		int max = 0;
		int x, y, cnt;
		for(int i = 0; i < N; i++) {
			cnt = 1;
			// ���� 0�� ������ ���� �ٲٴ� Ƚ���� K ���� ������ �ش� ���� ����� ��� ���� ���� �� ����.
			// ���� 0�� ���� % 2 != K % 2 ��� �ش� ���� ����� ��� ���� ���� �� ����.
			if(zeroCnt[i] > K || zeroCnt[i] % 2 != K % 2)
				continue;
			// ���� ���� �迭�� ���� �迭�� ������ ���� ���� ���� ���� ���� ��
			for(x = 0; x < N; x++) {
				if(x == i)
					continue;
				for(y = 0; y < M; y++) {
					if(lamp[i][y] != lamp[x][y])
						break;
				}
				if(y == M)
					cnt++;
			}
			max = Math.max(max, cnt);
		}


		System.out.println(max);
	}
}
