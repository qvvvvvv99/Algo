package FastCampus.HashSet;

//���� 1920 �� ã��
//Ư�� �ڷᰡ ���տ� �����ϴ��� Ȯ�� -> Set ����Ͽ� �ð� ���̱�

import java.util.*;

public class BJ1920 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> set1 = new HashSet<>();

		int N = sc.nextInt();
		for (int i = 0; i < N; i++)
			set1.add(sc.nextInt());

		int M = sc.nextInt();
		int[] ary2 = new int[M];
		for (int i = 0; i < M; i++)
			ary2[i] = sc.nextInt();

		for (int i = 0; i < M; i++) {
			if (set1.contains(ary2[i]))
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
}
