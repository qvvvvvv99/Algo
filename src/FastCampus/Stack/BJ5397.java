package FastCampus.Stack;

// BJ 5397�� Ű�ΰ�
// ���ڿ� ũ�� 1 <= L <= 1,000,000 -> �ð� �ʰ� ���� �����ϱ�!!!
// �� ���� ������ �ΰ� Ŀ���� �����Ѵ�

import java.util.*;

public class BJ5397 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		mySol();
		
		// Stack�� ����� �ùٸ� Ǯ��
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int i = 0; i < tc; i++) {
			Stack<Character> leftStack = new Stack<>();
			Stack<Character> rightStack = new Stack<>();
			StringBuilder sb = new StringBuilder();
			String str = sc.next();
			
			for(int j = 0; j < str.length(); j++) {
				switch(str.charAt(j)) {
				case '<':
					if(!leftStack.isEmpty())
						rightStack.push(leftStack.pop());
					break;
				case '>':
					if(!rightStack.isEmpty())
						leftStack.push(rightStack.pop());
					break;
				case '-':
					if(!leftStack.isEmpty())
						leftStack.pop();
					break;
				default:
					leftStack.push(str.charAt(j));
				}
			}
			
			while(!rightStack.isEmpty())
				leftStack.push(rightStack.pop());
			
			for(int j = 0; j < leftStack.size(); j++)
				sb.append(leftStack.elementAt(j));
			System.out.println(sb);
		}
	}
	
	// ���ڿ� ũ�� �������� ���� �ð� �ʰ�
	public static void mySol() {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int i = 0; i < tc; i++) {
			int cursor = 0;
			String str = sc.next();
			List<Character> password = new ArrayList<>();
			
			for(int j = 0; j < str.length(); j++) {
				switch(str.charAt(j)) {
				case '<':
					if(cursor > 0)
						cursor--;
					break;
				case '>':
					if(cursor < password.size())
						cursor++;
					break;
				case '-':
					if(cursor > 0) {
						password.remove(cursor-1);
						cursor--;
					}
					break;
				default:
					password.add(cursor, str.charAt(j));
					cursor++;
				}
			}

			for(int j = 0; j < password.size(); j++)
				System.out.print(password.get(j));
			System.out.println();
		}
	}
}
