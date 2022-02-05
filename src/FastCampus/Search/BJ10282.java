package FastCampus.Search;

//BJ 10282�� ��ŷ
//���ͽ�Ʈ�� �˰��� : �׸��� + DP
//���ͽ�Ʈ�� �˰��� -> �׷��� �ּ� �Ÿ� Ž�� �˰���
//�� �������� ������ ���������� �ִ� �Ÿ� ã��

import java.io.*;
import java.util.*;

public class BJ10282 {
	static ArrayList<ArrayList<Computer>> graph;
	static int INF = 10000001;	// 10,000(�ִ� ��ǻ�� ��) * 1,000(������ �ɸ��� �ð�) = �ִ� 10,000,000��
	static int[] distSec;	// ���� �ð� ��Ÿ���� �迭
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= tc; i++) {
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);	// ��ǻ�� ����
			int d = Integer.parseInt(input[1]); // ������ ����
			int c = Integer.parseInt(input[2]); // ��ŷ���� ��ǻ�� ��ȣ
			graph = new ArrayList<ArrayList<Computer>>();
			for(int j = 0; j <= n; j++)
				graph.add(new ArrayList<Computer>());
			
			for(int j = 1; j <= d; j++) {
				input = br.readLine().split(" ");
				int a = Integer.parseInt(input[0]);
				int b = Integer.parseInt(input[1]); 
				int s = Integer.parseInt(input[2]);
				graph.get(b).add(new Computer(a, s));
			}
			
			distSec = new int[n+1];
			Arrays.fill(distSec, INF);
			dijkstra(c);
			
			int cnt = 0;
			int max = 0;
			for(int j = 1; j <= n; j++) {
				if(distSec[j] != INF) {
					cnt++;
					if(max < distSec[j])
						max = distSec[j];
				}
			}
			System.out.println(cnt + " " + max);
		}
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Computer> queue = new PriorityQueue<Computer>();
		queue.add(new Computer(start, 0));
		distSec[start] = 0;
		
		while(!queue.isEmpty()) {
			Computer curCom = queue.poll();
			if(distSec[curCom.dependIdx] < curCom.sec)
				continue;
			
			for(int i = 0; i < graph.get(curCom.dependIdx).size(); i++) {
				Computer nextCom = graph.get(curCom.dependIdx).get(i);
				if(distSec[nextCom.dependIdx] > curCom.sec + nextCom.sec) {
					distSec[nextCom.dependIdx] = curCom.sec + nextCom.sec;
					queue.add(new Computer(nextCom.dependIdx, distSec[nextCom.dependIdx]));
				}
			}
		}
	}

}

class Computer implements Comparable<Computer>{
	int dependIdx;
	int sec;
	
	Computer(int dependIdx, int sec){
		this.dependIdx = dependIdx;
		this.sec = sec;
	}

	@Override
	public int compareTo(Computer c) {
		// TODO Auto-generated method stub
		return this.sec - c.sec;
	}
	
}