package AlgoStudy.Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ6987 {
	// ��� ��ġ �� �� ����
	static int[][] matches = {
							{0,1},{0,2},{0,3},{0,4},{0,5},
							{1,2},{1,3},{1,4},{1,5},
							{2,3},{2,4},{2,5},
							{3,4},{3,5},
							{4,5}
	};
	static boolean isPossible = false;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		// 4���� ���
		for(int i = 0; i < 4; i++) {
			// ��� ���� �迭
			int[][] gameResult = new int[6][3];
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 6�� ��
			int t;
			for(t = 0; t < 6; t++) {
				// ��, ��, ��
				for(int r = 0; r < 3; r++) {
					gameResult[t][r] = Integer.parseInt(st.nextToken());
				}
			}
			for(t = 0; t < 6; t++) {
				int game = 0;
				for(int a = 0; a < 3; a++) {
					game += gameResult[t][a];
				}
				// �� ���� 5��⸦ ���� �ʾ����� �Ұ����� ���
				if(game != 5) {
					sb.append("0 ");
					break;
				}
			}	
			if(t < 6)
				continue;
			
			// 6���� ���� �հ� ���� ���� �ٸ��� �Ұ����� ���
			int win = 0, lose = 0;
			for(int s = 0; s < 6; s++) {
				win += gameResult[s][0];
				lose += gameResult[s][2];
			}
			if(win != lose) {
				sb.append("0 ");
				continue;
			}
			
			isPossible = false;
			backtracking(gameResult, 0);
			if(isPossible) {
				sb.append("1 ");
			}else {
				sb.append("0 ");
			}
		}
		
		System.out.println(sb);
	}
	
	public static void backtracking(int[][] gameResult, int match) {
		if(isPossible)
			return;
		
		// ��� ��� ����� �����g�ٸ� ������ ���
		if(match == 15) {
			isPossible = true;
			return;
		}
		
		int t1 = matches[match][0];
		int t2 = matches[match][1];
		
		// t1�� ��, t2�� ��
		if(gameResult[t1][0] > 0 && gameResult[t2][2] > 0) {
			gameResult[t1][0]--;
			gameResult[t2][2]--;
			backtracking(gameResult, match+1);
			gameResult[t1][0]++;
			gameResult[t2][2]++;
		}
		
		// t1�� ��, t2�� ��
		if(gameResult[t1][1] > 0 && gameResult[t2][1] > 0) {
			gameResult[t1][1]--;
			gameResult[t2][1]--;
			backtracking(gameResult, match+1);
			gameResult[t1][1]++;
			gameResult[t2][1]++;
		}
		
		// t1�� ��, t2�� ��
		if(gameResult[t1][2] > 0 && gameResult[t2][0] > 0) {
			gameResult[t1][2]--;
			gameResult[t2][0]--;
			backtracking(gameResult, match+1);
			gameResult[t1][2]++;
			gameResult[t2][0]++;
		}		
	}

}
