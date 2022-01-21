package FastCampus.Sort;

import java.io.*;
import java.util.*;

// BJ 10989�� �� �����ϱ� 3
// �������(counting sort)
// : �迭�� �ε����� Ư���� �������� ������ ����� ����
// : �����Ͱ� ������ Ƚ���� ����

public class BJ10989 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] ary = new int[10001];	// �ԷµǴ� ���� ���� 0~10000
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) 
			ary[Integer.parseInt(br.readLine())]++;
		br.close();
		
		// �ݺ��� �ȿ� System.out.println()�� �־� �Ź� ����� �ϴ� �ͺ���
		// StringBuilder�� ����� ��ü String�� ����� �ѹ��� ����ϴ� ���� �ξ� ȿ����!!
		// -> �ð� ����!!!
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < 10001; i++) {
			if(ary[i] != 0) {
				for(int j = ary[i]; j > 0; j--) {
					sb.append(i).append('\n');
				}
			}
		}
		System.out.println(sb);
	}

}
