package FastCampus.Search;

// BJ 1260�� DFS & BFS
// DFS & BFS �� �ʼ�!!!
// ���� Ǯ����� �帧 �ϱ��ϱ�!!(�ڵ��ڵ�)

import java.util.*;

public class BJ1260 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // ������ ���� 
		int m = sc.nextInt(); // ������ ���� 
		int v = sc.nextInt(); // Ž���� ������ ������ ��ȣ 

		boolean visited[] = new boolean[n + 1]; // �湮 ���θ� �˻��� �迭 

		LinkedList<Integer>[] adjList = new LinkedList[n + 1];

		for (int i = 0; i <= n; i++) {
			adjList[i] = new LinkedList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}

		for (int i = 1; i <= n; i++)
			Collections.sort(adjList[i]);
		// �湮�� �� �ִ� ������ ���� ���� ��쿡�� ���� ��ȣ�� ���� ���� ���� �湮 
		// �ϱ� ���� ��������Ʈ �� ����
		
		dfs(v, adjList, visited);
		Arrays.fill(visited, false);
		System.out.println();
		bfs(v, adjList, visited);
	}
	
	public static void dfs(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");
		
		Iterator<Integer> iter = adjList[v].listIterator();
		while(iter.hasNext()) {
			int w = iter.next();
			if(!visited[w])
				dfs(w, adjList, visited);
		}
	}
	
	public static void bfs(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		visited[v] = true;
		
		while(queue.size() != 0) {
			v = queue.poll();
			System.out.print(v + " ");
			
			Iterator<Integer> iter = adjList[v].listIterator();
			while(iter.hasNext()) {
				int w= iter.next();
				if(!visited[w]) {
					queue.add(w);
					visited[w] = true;
				}
			}
		}
	}

}
