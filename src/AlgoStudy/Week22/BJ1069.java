package AlgoStudy.Week22;

import java.util.Scanner;

public class BJ1069 {
	static int X, Y, D, T;
	static double res = Double.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		Y = sc.nextInt();
		D = sc.nextInt();
		T = sc.nextInt();

		sol();

		System.out.println(res);
	}

	static void sol() {
		double diagoLen = Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2));
		int div = 0;

		// �ɾ��
		res = diagoLen;
		div = (int) (diagoLen / D);
		// �ѹ��� ������ ���������� �Ÿ����� �� ��
		if (div == 0) {
			// ���� �ѹ��ϰ� ���� �Ÿ� ���ƿ���
			res = Math.min(res, T + D - diagoLen);
			// �ι� ���� �����ؼ� �����ϱ�
			res = Math.min(res, 2 * T);
		} 
		// �ѹ��� ������ ���������� �Ÿ����� ª�� ��
		else {
			// �������� �����ϰ� �ɾ �����ϱ�
			res = Math.min(res, T * div + diagoLen - D * div);
			// �������� �����ϰ� �ι� ���� �����ؼ� �����ϱ�
			if(T * (div + 1) < res)
				res = T * (div + 1);
		}

	}

}
