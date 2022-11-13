package AlgoStudy.Week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ1939 {
	static int start;
	static int end;
	static LinkedList<Route>[] adjList;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]); // ���� ����
		int M = Integer.parseInt(input[1]); // �ٸ��� ����
		visited = new boolean[N + 1]; // �湮 ���� �˻��� �迭
		adjList = new LinkedList[N + 1]; // ������ �ٸ� ���� ��Ÿ�� �׷��� ���� ���� ���Ḯ��Ʈ(�� ��ȣ�� ���Ḯ��Ʈ ��ȣ ��ġ�ϱ� ���� N+1)
		int min = 1000000000, max = 1, mid;
		int res;

		for (int i = 0; i <= N; i++)
			adjList[i] = new LinkedList<Route>(); // ������ ���Ḯ��Ʈ�� ���� ��üȭ

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			adjList[Integer.parseInt(input[0])].add(new Route(Integer.parseInt(input[1]), Integer.parseInt(input[2])));
			adjList[Integer.parseInt(input[1])].add(new Route(Integer.parseInt(input[0]), Integer.parseInt(input[2])));
			max = Math.max(Integer.parseInt(input[2]), max);
			min = Math.min(Integer.parseInt(input[2]), min);
		}

		input = br.readLine().split(" ");
		start = Integer.parseInt(input[0]);
		end = Integer.parseInt(input[1]);

		res = min;
		while (min <= max) {
			mid = (max + min) / 2;
			if (bfs(mid)) {
				res = mid;
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}

		System.out.println(res);
	}

	public static boolean bfs(int value) {
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < visited.length; i++)
			visited[i] = false;
		visited[start] = true;
		queue.add(start);
		while (queue.size() != 0) {
			int x = queue.poll();

			for (Route temp : adjList[x]) {
				int v = temp.desti;
				int w = temp.weight;
				if (visited[v] == false && w >= value) {
					visited[v] = true;
					queue.add(v);
				}
			}
		}
		return visited[end];
	}
}

class Route {
	int desti;
	int weight;

	Route(int desti, int weight) {
		this.desti = desti;
		this.weight = weight;
	}
}