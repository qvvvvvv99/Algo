package FastCampus.Heap;

// BJ 1766�� ������
// ��������

import java.io.*;
import java.util.*;

public class BJ1766 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);	// ������ �� (1<=N<=32000)
		int M = Integer.parseInt(input[1]);	// ���� Ǫ�� ���� ���� ������ ���� ���� �� (1<=N<=100000)
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		ArrayList<ArrayList <Integer>> ary = new ArrayList<>();
		for(int i = 0; i <= N; i++)
			ary.add(new ArrayList<Integer>());
		StringBuilder sb = new StringBuilder();
		int degree[] = new int[N+1];
		
		for(int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			ary.get(a).add(b);
			degree[b] += 1;
		}
		
		// 1) ���� ������ 0�� ������ ť�� ����
		for(int i = 1; i <= N; i++) {
			if(degree[i] == 0)
				heap.add(i);
		}
		// 2) ť���� ���Ҹ� ���� �ش� ���ҿ� ������ ����
		// 3) ���� ���Ŀ� ���� ������ 0�� �� ������ ť�� ����
		while(!heap.isEmpty()) {
			int n = heap.poll();
			sb.append(n + " ");
			for(int i : ary.get(n)) {
				degree[i] -= 1;
				if(degree[i] == 0)
					heap.add(i);
			}
		}
		// 4) ť�� �� ������ 2-3���� �ݺ�
		
		System.out.println(sb);
	}

}