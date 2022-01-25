package FastCampus.DFS;

import java.util.*;

public class DFS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // ������ ���� 
		int m = sc.nextInt(); // ������ ���� 
		int v = sc.nextInt(); // Ž���� ������ ������ ��ȣ 

		boolean visited[] = new boolean[n + 1]; // �湮 ���θ� �˻��� �迭 

		LinkedList<Integer>[] adjList = new LinkedList[n + 1];

		for (int i = 0; i <= n; i++) {
			adjList[i] = new LinkedList<Integer>();
		}

		// �� ���� ���̿� ���� ���� ������ ���� �� �ִ�.
		// �Է����� �־����� ������ ������̴�.
		for (int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}

		for (int i = 1; i <= n; i++) { // �湮 ������ ���� �������� ���� 
			Collections.sort(adjList[i]);
		}

		System.out.println("DFS - ��������Ʈ");
		dfs(v, adjList, visited);
	}
	
	// DFS - ��������Ʈ - ��ͷ� ���� 
	public static void dfs(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
		visited[v] = true; // ���� �湮 ǥ��
		System.out.print(v + " "); // ���� ���

		Iterator<Integer> iter = adjList[v].listIterator(); // ���� ��������Ʈ ��ȸ
		while (iter.hasNext()) {
			int w = iter.next();
			if (!visited[w]) // �湮���� ���� �����̶�� 
				dfs(w, adjList, visited); // �ٽ� DFS
		}
	}

}