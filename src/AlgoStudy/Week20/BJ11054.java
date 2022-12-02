package AlgoStudy.Week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11054 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] ary = new int[N+2];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++)
			ary[i] = Integer.parseInt(st.nextToken());
		
		int[] ascDP = new int[N+2];
		int[] descDP = new int[N+2];
		
		// ���ʿ��� �����ϴ� �κм���
		for(int i = 1; i <= N; i++) {
			int max = 0;
			// �ش� �� ���� ��� ���� ����
			for(int j = i-1; j >= 0; j--) {
				// �ش� ������ �۴ٸ� �����ϴ� �κ� ����
				if(ary[i] > ary[j])
					max = Math.max(max, ascDP[j]);
			}
			// �����ϴ� �κм��� �� ���� ū��
			ascDP[i] = max+1;
		}
		
		// �����ʿ��� �����ϴ� �κм���
		for(int i = N; i > 0; i--) {
			int max = 0;
			for(int j = i+1; j <= N+1; j++) {
				if(ary[i] > ary[j])
					max = Math.max(max, descDP[j]);
			}
			descDP[i] = max+1;
		}
		
		int res = 0;
		for(int i = 1; i <= N; i++)
			res = Math.max(res, ascDP[i] + descDP[i]);
		
		System.out.println(res-1);
	}

}
