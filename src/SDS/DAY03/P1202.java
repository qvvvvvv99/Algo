package SDS.DAY03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1202 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N, K �Է� �ޱ� (1 <= N, K <= 300,000)
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Jewelry[] jewelry = new Jewelry[N];
		// N���� ���� ���� �Է¹ޱ�
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			jewelry[i] = new Jewelry(w, p);
		}
		// N���� ������ ���� ���� �������� ����
		Arrays.sort(jewelry);
		
		// K���� ���� ���� �Է¹ޱ�
		int[] bag = new int[K];
		for(int i = 0; i < K; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		// K���� ���� ���� ���� ����(���԰� ���� ������� ä���)
		Arrays.sort(bag);
		
		// idx : ���� ���� ��ġ ����Ű�� �ε��� ��ȣ
		int idx = 0;
		// ���� ���� ������ �ִ���
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		long res = 0;
		
		// �������� : ���濡 ��� ������ ������� ����
		for(int i = 0; i < K; i++) {
			// ������ ������ ��� �ִ� �迭���� ���濡 ���� �� �ִ� ������ ��� ���� ���� �ִ����� �ִ´�.
			while( idx < N && bag[i] >= jewelry[idx].weight) {
				maxHeap.add(jewelry[idx].price);
				idx++;
			}
			// ������ ���Ժ��� �� ū ������ ���Ը� ������ ���� ���濡 ���� �ִ����� �ϼ�
			// �ִ����� top�� �� ���� -> top �� ����
			if(!maxHeap.isEmpty())
				res += maxHeap.poll();
			// ���� ���� ���Կ� ���Ͽ� ���� ���� �������� �ٽ� �ִ����� �߰�	
		}
		
		System.out.println(res);
	}
}

class Jewelry implements Comparable<Jewelry>{
	int weight;
	int price;
	
	public Jewelry(int weight, int price){
		this.weight = weight;
		this.price = price;
	}
	
	public int compareTo(Jewelry j) {
		return this.weight - j.weight;
	}
}