package FastCampus.DP;

// BJ 1495�� ��Ÿ����Ʈ
// DP

import java.io.*;

public class BJ1495 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]); 	// N : ���� ����
		int S = Integer.parseInt(s[1]); 	// S : ���� ��
		int M = Integer.parseInt(s[2]);		// M : �ִ� ����
		int[][] ary = new int[N+1][M+1];
		
		ary[0][S] = 1;
		s = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			int V = Integer.parseInt(s[i]);	// V : ���� ������ ����
			for(int j = 0; j <= M; j++) {
				if(ary[i][j] == 1) {
					if(j+V <= M) 
						ary[i+1][j+V] = 1;
					if(j-V >= 0)
						ary[i+1][j-V] = 1;
				}
			}
		}
		for(int i = M; i >= 0; i--) {
			if(ary[N][i] == 1) {
				System.out.println(i);
				break;
			}
			if(i == 0)
				System.out.println(-1);
		}
	}

}
