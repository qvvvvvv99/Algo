package AlgoStudy.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1717 {
	static int[] parent;
	static int[] rank;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// ������ ������ union-find �˰����� �̿��ؼ� �Ѵ�.
		// �� ���Ұ� ���� ���տ� ���ԵǾ� �ִ°��� ���Ҹ� �׷������� ������ ���� �������� ��
		// �̾��������� ���� �����̰� �̾����� �ʾ����� �ٸ� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		rank = new int[N+1];
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i <= N; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
		
		// M * N = 100,000,000,000 => �ð��ʰ�
		// find �˰��� ����ȭ �ʿ�
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int comm = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			if(comm == 0) {
				union(A, B);
			}else {
				A = find(A);
				B = find(B);
				if(A == B)
					sb.append("YES\n");
				else
					sb.append("NO\n");
			}
		}
		
		System.out.print(sb);
	}
	
	// �ð� ���⵵ : O(n-1)
	// ����ȭ �ʿ�! => ����ȭ �� O(logN)
	static int find(int n) {
		if(n == parent[n])
			return n;
		return parent[n] = find(parent[n]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if(a == b)
			return;
		
		if(rank[a] > rank[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		parent[a] = b;
		
		// �� Ʈ���� ���̰� ���� ��� ��� Ʈ���� rank�� 1 �����Ѵ�.
		if(rank[a] == rank[b])
			rank[b]++;
	}

}
