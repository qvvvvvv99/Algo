package AlgoStudy.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20529 {
	enum MBTI {ISTJ, ISFJ, INFJ, INTJ, ISTP, ISFP, INFP, INTP, ESTP, ESFP, ENFP, ENTP, ESTJ, ESFJ, ENFJ, ENTJ};
	static int[] num;
	static String[] strMBTI = {"ISTJ", "ISFJ", "INFJ", "INTJ", "ISTP", "ISFP", "INFP", "INTP", "ESTP", "ESFP", "ENFP", "ENTP", "ESTJ", "ESFJ", "ENFJ", "ENTJ"};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int min;
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 16 ���� ������ ������ �ε��� ��ȣ�� �ޱ��
			num = new int[16];
			for(int j = 0; j < N; j++) {
				MBTI mbti = MBTI.valueOf(st.nextToken()); 
				// �Է��� ���� �� ������ ������ �ľ�
				num[mbti.ordinal()]++;
			}
			min = 99999999;
			// 16 ������ �׷����� 16 * 16 * 16���� ���鼭 Ȯ��
			for(int a = 0; a < 16; a++) {
				// �迭 ����(16���� ���� ��� Ȯ�� ����)
				if(num[a] == 0)
					continue;
				int[] sample = num.clone();
				sample[a]--;
				// ������ 1 �̻��� ������ �������� �ش� ���� -1
				for(int b = 0; b < 16; b++) {
					if(sample[b] == 0) 
						continue;
					// ���� �������� 1�̻� ���� ���� �� ����(���� -1)
					sample[b]--;
					for(int c = 0; c < 16; c++) {
						if(sample[c] == 0)
							continue;
						// 3�� �ݺ� �� �� ã�� �ּڰ� Ȯ��
						sample[c]--;
						min = Math.min(min, check(a, b, c));
						sample[c]++;
					}
				}
			}
			sb.append(min+"\n");
		}
		System.out.print(sb);
	}
	
	static int check(int a, int b, int c) {
		int sum = 0;
		
		for(int i = 0; i < 4; i++) {
			if(strMBTI[a].charAt(i) != strMBTI[b].charAt(i))
				sum++;
			if(strMBTI[b].charAt(i) != strMBTI[c].charAt(i))
				sum++;
			if(strMBTI[a].charAt(i) != strMBTI[c].charAt(i))
				sum++;
		}
		
		return sum;
	}

}
