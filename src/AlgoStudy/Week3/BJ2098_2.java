package AlgoStudy.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2098_2 {
	private static final int INF = 16000001; //TSP�� �ִ밪���� �� ū ��.
    static int N;
	static int[][] map;
    static int visited;
    private static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visited = (1 << N) - 1; // 1...1(N��) -> N���� ������ �湮 �ߴ��� ���� 
        map = new int[N][N];
        dp = new int[16][visited];
        // dp[�湮 ����][�̹� �湮�� ���õ��� ��Ʈ����ũ]
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < N; i++) 
            Arrays.fill(dp[i], -1);
        
        System.out.println(dfs(0, 1));
    }

    //dp[cur][visit] : cur�������� visit(bitmask) ��ŭ ������ �湮�� ������ ��,
    //                 ������ ���� ��� �湮 �� �ٽ� 0�� �������� ���ư��� �ּҺ��
    public static int dfs(int cur, int visit) {
        if (visit == visited) // ��� ������ �湮�ߴ� ���
        	return map[cur][0] == 0 ? INF : map[cur][0];
        if (dp[cur][visit] != -1) 
        	return dp[cur][visit];

        dp[cur][visit] = INF;
        for(int i = 0; i < N; i++) {
            int next = 1 << i;
            // ���� cur���� 
            if(map[cur][i] != 0 && ((visit & next) == 0)) {
                dp[cur][visit] = Math.min(dp[cur][visit], dfs(i, (visit|next)) + map[cur][i]);
            }
        }
        return dp[cur][visit];
    }

}
