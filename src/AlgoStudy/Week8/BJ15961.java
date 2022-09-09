package AlgoStudy.Week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15961 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());		// ���� ��
		int d = Integer.parseInt(st.nextToken());		// �ʹ� ���� ��
		int k = Integer.parseInt(st.nextToken());		// �����ؾ��ϴ� ��
		int c = Integer.parseInt(st.nextToken());		// �߰��� �־����� ��ȣ
		int res = 1, max = 0;
		
		int[] num = new int[N+1];
		for(int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		int[] cnt = new int[d+1];
		boolean[] select = new boolean[d+1];
		
		cnt[c] = 1;
		select[c] = true;
		
		int front, back;
		for(back = 1; back <= k; back++) {
			cnt[num[back]]++;
			if(select[num[back]] == false) {
				select[num[back]] = true;
				res++;
			}
		}
		max = Math.max(max, res);
		
		for(front = 1; front <= N; front++) {
			back %= N;
			if(back == 0)
				back = N;
			// ����
			cnt[num[front]]--;
			if(cnt[num[front]] == 0) {
				select[num[front]] = false;
				res--;
			}
			cnt[num[back]]++;
			if(select[num[back]] == false) {
				select[num[back]] = true;
				res++;
				max = Math.max(max, res);
			}
			back++;
		}
		
		System.out.println(max);
	}

}
