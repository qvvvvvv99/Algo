package AlgoStudy.Week13;

import java.util.*;

public class Prog60062 {
	static int N, INF = 987654321, min;
	static int[] Weak;
	static int[] Dist;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 12;
		int[] weak = { 1, 5, 6, 10 };
		int[] dist = { 1, 2, 3, 4 };
		System.out.println(solution(n, weak, dist));
	}

	public static int solution(int n, int[] weak, int[] dist) {
		int answer = 0;
		min = INF;
		N = n;
		Weak = weak;
		Arrays.sort(dist);
		Dist = dist;
		for (int i = 0; i < weak.length; i++) {
			permutaion(1, i, new boolean[weak.length]);
		}

		answer = min == INF ? -1 : min;
		return answer;
	}

	static void permutaion(int depth, int pos, boolean visit[]) {
		if (depth > Dist.length)
			return;
		if (min <= depth)
			return;
		boolean[] copyVisit = Arrays.copyOf(visit, visit.length);
		for (int i = 0; i < Weak.length; i++) {
			int nextPos = (pos + i) % Weak.length;
			int diff = nextPos >= pos ? Weak[nextPos] - Weak[pos] : Weak[nextPos] + N - Weak[pos];
			if (diff <= Dist[Dist.length - depth]) {
				copyVisit[nextPos] = true;
			} else
				break;
		}
		if (isValid(copyVisit)) {
			min = Math.min(min, depth);
			return;
		}
		for (int i = 0; i < Weak.length; i++) {
			if (!copyVisit[i])
				permutaion(depth + 1, i, copyVisit);
		}
	}

	static boolean isValid(boolean visit[]) {
		for (int i = 0; i < visit.length; i++) {
			if (!visit[i])
				return false;
		}
		return true;
	}
}