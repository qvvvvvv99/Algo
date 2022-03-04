package BJAlgo.Level3;

import java.io.*;
import java.util.*;

public class BJ18870 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		int[] origin = new int[N];	// ���� �迭
		int[] sorted = new int[N];	// ���� �� �迭
		HashMap<Integer, Integer> rankingMap = new HashMap<Integer, Integer>();	// rank�� �ű� HashMap
 
		
		for(int i = 0; i < N; i++) {
			// ������ �迭�� ���� �迭�� ���� �־��ش�.
			sorted[i] = origin[i] = in.nextInt();
		}
		
		// ���� �� �迭�� ���� ������ �������ش�.
		Arrays.sort(sorted);
		
		
		// ���� �� �迭�� ��ȸ�ϸ鼭 map�� �־��ش�.
		int rank = 0;
		for(int v : sorted) {
			if(!rankingMap.containsKey(v)) {
				rankingMap.put(v, rank);
				rank++;		// map�� �ְ��� ���� ������ ����ų �� �ֵ��� 1�� �����ش�.
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int key : origin) {
			int ranking = rankingMap.get(key);	// ���� �迭 ����(key)�� ���� value(����)�� ����´�.
			sb.append(ranking).append(' ');
		}
		
		System.out.println(sb);
	}

}
