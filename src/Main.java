import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();	// ����
		int B = sc.nextInt();	// ����
		int C = sc.nextInt();	// �ǸŰ���
		int res;
		
		// A + n * B < C * n -> n�� �ּ�
		if(B >= C)
			res = -1;
		else 
			res = A / (C - B) + 1;
		
		System.out.println(res);
	}

}
