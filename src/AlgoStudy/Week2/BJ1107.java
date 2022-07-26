package AlgoStudy.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1107 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean[] broken = new boolean[10];
		
		if(M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++)
				broken[Integer.parseInt(st.nextToken())] = true;
		}
		
		// �ð����⵵ : 1,000,000 * log 1,000,000 = 6,000,000 -> ���� Ž�� ����
		
		int min = Math.abs(N - 100);
		// ä���� ���Ѵ� ��ŭ �����ϱ⿡ N�� ������ 500,000������ �ƴ� 999,999���� Ž���Ѵ�.
		for(int i = 0; i <= 999999; i++) {
			int temp = i;
			int cnt = 0;
			boolean flag = true;
			
			while(true) {
				// �� �ڸ��� ��ȣ�� ���峪 ������ ���Ѵٸ� ���� ��ȣ�� �̵�
				if(broken[temp%10]) {
					flag = false;
					break;
				}
				temp /= 10;
				cnt++;
				if(temp == 0)
					break;
			}
			// ���峭 ��ȣ�� ������ ��� ���� ���
			if(flag) {
				// cnt : �� �ڸ����� ���� Ƚ��
				// Math.abs(N - i) +, - ��ư�� ���� �̵��� Ƚ��
				int num = cnt + Math.abs(N - i);
				min = Math.min(num, min);
			}
		}
		
		System.out.println(min);
	}

}
