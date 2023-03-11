package BJAlgo.Level5;

import java.io.*;
import java.util.*;

// 2342 Dance Dance Revolution
public class BJ2342 {

	static ArrayList<Integer> input; // ������ �� ����� ��
	// dp[ i ] [ j ] [ k ] : �޹�(j) ��ġ, ������(k) ��ġ�̰� - i��° �����϶� �ִ�
	static int[][][] dp; // [ i ] <= 10��
	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		input = new ArrayList<Integer>();
		for (;;) {
			int in = Integer.parseInt(st.nextToken());
			if (in==0) break;
			input.add(in);
		}

		N = input.size();
		dp = new int[N+1][5][5];
		
		int ans = DDR(0, 0, 0);
		bw.write(ans + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

	static int DDR(int step, int left, int right) {
		// 1. ������ ���� �����ϸ� ��
		if (step == N)
			return 0;

		// 2. dp�� ���� �������� return
		if (dp[step][left][right] != 0) {
			return dp[step][left][right];
		}

		// 3. ������ ����� �� �� ���� ���� ���� �����ϰ� return
		// �޹� �����̴� ��� vs ������ �����̴� ���
		int leftScore = score(left, input.get(step)) + DDR(step + 1, input.get(step), right); 
		int rightScore = score(right, input.get(step)) + DDR(step + 1, left, input.get(step)); 
		
		return dp[step][left][right] = Math.min(leftScore, rightScore);
	}

    static int score(int from, int to){
    	// 0. ���� ��ġ�� ������ 1
    	if(from==to) return 1;
    	// 1. ��� ��� 2
        if(from==0) return 2;
        // 3. ũ�ν� �ؼ� ������ 4
        if(Math.abs(from-to) ==2) return 4;
        // 4. ���� ���� ������ 3
        return 3;
    }
}