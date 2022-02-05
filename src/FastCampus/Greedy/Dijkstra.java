package FastCampus.Greedy;

// ���ͽ�Ʈ�� �˰��� : �׸��� + DP

/*
sample input
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
 */

import java.util.*;
import java.io.*;

public class Dijkstra {
	static ArrayList<ArrayList<Node>> graph;
	static int INF = 100000; // ���Ѵ밪 : �������� �־����� �Ÿ��� �ִ밪 + 1
	static int[] d;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		graph = new ArrayList<ArrayList<Node>>();
		for (int i = 0; i < V + 1; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			// ���� �׷��������� ���ͽ�Ʈ�� �˰���.
			graph.get(v1).add(new Node(v2, c));
			// ���� �׷����� ��� �Ʒ� �ּ� �ڵ� Ǯ��
			// graph.get(v2).add(new Node(v1, c));
		}
		
		d = new int[V+1];
		Arrays.fill(d, INF);
		dijkstra(start);
	}
	
	// Dikstra Algo
	public static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.add(new Node(start, 0));
		d[start] = 0;
		
		while(!queue.isEmpty()) {
			Node curNode = queue.poll();
			if(d[curNode.idx] < curNode.cost)
				continue;
			
			for (int i = 0; i < graph.get(curNode.idx).size(); i++) {
				Node nextNode = graph.get(curNode.idx).get(i);
				if (d[nextNode.idx] > curNode.cost + nextNode.cost) {
					d[nextNode.idx] = curNode.cost + nextNode.cost;
					// ���ŵ� ��쿡�� ť�� �ִ´�.
					queue.add(new Node(nextNode.idx, d[nextNode.idx]));
				}
			}
		}
		System.out.println(Arrays.toString(d));
		// 0 ��°�� ����!!
	}

}

class Node implements Comparable<Node>{// ���� ����� �ε�����, �� ���� ���µ� �ʿ��� ����� ��� �ִ�.
	int idx, cost;

	Node(int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node node) {
		// TODO Auto-generated method stub
		return this.cost - node.cost;
	}
}

