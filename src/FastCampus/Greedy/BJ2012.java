package FastCampus.Greedy;

import java.util.*;

public class BJ2012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ary[] = new int[N+1];
		long res = 0;
		// �־��� ��� �ڷ��� ũ�� �����ϱ�!!
		// int�� 4byte �� -20��~20��
		// long�� 8byte ��û����....
		
		for(int i = 1; i <= N; i++)
			ary[i] = sc.nextInt();
		
		Arrays.sort(ary);
		
		for(int i = 1; i <= N; i++) 
			res += Math.abs(ary[i] - i);
		
		System.out.println(res);
	}

}
