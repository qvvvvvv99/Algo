package FastCampus.Mathematics;

import java.util.Scanner;

public class lcm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		// LCM(a, b) = a*b/GCD(a, b)
		// lcm�� gcd�� Ȱ���Ͽ� �������
		// int overflow�� �߻��� �� ������
		// a / gcd(a, b) * b ������ �Ұ�
		
		System.out.println(lcm(a,b));
	}
	
	public static int lcm(int a, int b) {
		return a/gcd(a,b)*b;
	}
	
	public static int gcd(int a, int b) {
		if(a%b == 0)
			return b;
		return gcd(b, a%b);
	}

}
