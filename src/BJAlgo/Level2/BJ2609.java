package BJAlgo.Level2;

// BJ 2609��
// �ִ������� �ּ� �����
import java.util.*;

public class BJ2609 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		
		System.out.println(gcd(n1, n2));
		System.out.println(lcm(n1, n2));
	}
	
	//�ִ�����
	// *** �ִ븦 ���ؾ��ϸ� �ݺ����� ū ������ �۾����鼭 ã�� ���� ȿ����!!!
//	for(int i = Math.min(n1, n2); i > 1 ; i--)
//		if((n1 % i == 0) && (n2 % i == 0)){
//			gcd = i;
//			return gcd; -> �ݺ��� ����	
//		}
	public static int gcd(int n1, int n2) {
		int gcd = 1;
		
		for(int i = 2; i <= Math.min(n1, n2); i++) {
			if((n1 % i == 0) && (n2 % i == 0))
				gcd = i;
		}
		return gcd;
	}
	//�ּҰ����
	public static int lcm(int n1, int n2) {
		int lcm = 1;
		int gcd = gcd(n1, n2);
		
		lcm = n1 / gcd * n2;
		
		return lcm;
	}
}
