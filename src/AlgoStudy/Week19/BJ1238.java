package AlgoStudy.Week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1238 {
	static int[][] d;
	static int INF = 100001;
	static int N, M, X;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		ArrayList<Node>[] back_graph = new ArrayList[N+1];
		// �״�� �Է¹ް� x���� ����ϸ� ���ư��±� ��Ÿ���� �׷���
		ArrayList<Node>[] go_graph = new ArrayList[N+1];
		// �ݴ�� �Է¹ް� x���� ����ϸ� ���ñ� ��Ÿ���� �׷���
		for (int i = 1; i <= N; i++) {
			back_graph[i] = new ArrayList<Node>();
			go_graph[i] = new ArrayList<Node>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			back_graph[v1].add(new Node(v2, c));
			go_graph[v2].add(new Node(v1, c));
		}
		
		d = new int[N+1][2];
		for(int i = 0; i <= N; i++)
			Arrays.fill(d[i], INF);
		dijkstra(0, back_graph);
		dijkstra(1, go_graph);
		
		int res = 0;
		for(int i = 1; i <= N; i++) {
			if(res < d[i][0] + d[i][1])
				res = d[i][0] + d[i][1];
		}
		
		System.out.println(res);
	}

	public static void dijkstra(int n, ArrayList<Node>[] graph) {
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.add(new Node(X, 0));
		d[X][n] = 0;
		
		while(!queue.isEmpty()) {
			Node curNode = queue.poll();
			if(d[curNode.idx][n] < curNode.cost)
				continue;
			
			for (int i = 0; i < graph[curNode.idx].size(); i++) {
				Node nextNode = graph[curNode.idx].get(i);
				if (d[nextNode.idx][n] > curNode.cost + nextNode.cost) {
					d[nextNode.idx][n] = curNode.cost + nextNode.cost;
					// ���ŵ� ��쿡�� ť�� �ִ´�.
					queue.add(new Node(nextNode.idx, d[nextNode.idx][n]));
				}
			}
		}
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