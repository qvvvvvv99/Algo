package AlgoStudy.Week4;

import java.util.Scanner;

public class BJ15927 {
	static String str;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		str = sc.next();
		int len = -1;
		boolean palindrome = true;
		
		// ȸ�� �Ǻ�
		for(int i = 0; i < str.length()/2; i++) {
			if(str.charAt(i) != str.charAt(str.length()-1-i)) {
				palindrome = false;
				// 1. ��ü �迭�� ȸ���� �ƴҰ�� ��ü ����
				len = str.length();
				break;
			}		
		}
		
		// 2. ȸ���� ���
		if(palindrome) {
			//	1) ��� ���� �����̸� -1
			//  2) ���� ���ڰ� �ƴϸ� (��ü ���� -1)
			for(int i = 1; i < str.length(); i++) {
				if(str.charAt(0) != str.charAt(i)) {
					len = str.length()-1;
					break;
				}
			}
		}
		
		System.out.println(len);
		
	}

}
