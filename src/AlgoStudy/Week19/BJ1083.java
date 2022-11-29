package AlgoStudy.Week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ1083 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++)
			list.add(Integer.parseInt(st.nextToken()));
		int S = Integer.parseInt(br.readLine());

		ArrayList<Integer> sort = new ArrayList<>(list);
		Collections.sort(sort, Collections.reverseOrder());

		// cnt : Ȯ���� �ڸ� ��
		int cnt = 0;
		for (int i = 0; i < N-1; i++) {
			// i��° ���� �� �ִ� �ִ� ��
			int max = sort.get(i);
			// �迭���� max�� �ε�����ȣ
			int idx = list.indexOf(max);
			// idx - cnt : �ش� ���� �̵��ؾ��� �Ÿ�
			if (S >= idx - cnt) {
				// �̵�
				list.remove(idx);
				list.add(cnt, max);
				S -= (idx - cnt);
				if(S == 0)
					break;
				cnt++;	// �ڸ��� ����
			}
		}

		StringBuffer sb = new StringBuffer();
		for (int i: list)
			sb.append(i + " ");
		System.out.print(sb.toString());
	}

}
