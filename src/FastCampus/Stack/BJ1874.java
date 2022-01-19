package FastCampus.Stack;

// ���� 1874�� ���� ����
// 1. ���ÿ� ���Ҹ� ������ ����, �ܼ��� Ư�� ���� ������ ������ ����
// 2. ���ÿ��� ���Ҹ� ���޾� ���� �� ���������� ������ �� �ִ��� Ȯ��

import java.util.*;

public class BJ1874 {
	static int stack[] = new int[100000];
	static char opAry[] = new char[200001];
	static int top = -1;
	static int opCnt = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ary[] = new int[n];
		int newAry[] = new int[n];
		for(int i = 0; i < n; i++)
			ary[i] = sc.nextInt();
		
		int cnt = 1, aryNum = 0, naryNum = 0;
		while(cnt <= n) {
			push(cnt++);
			while ((top >= 0) && (stack[top] == ary[aryNum])) {
				newAry[naryNum++] = pop();
				aryNum++;
			}
		}
		while(top >= 0) {
			newAry[naryNum++] = pop();
		}
		
		for(int i = 0; i < n; i++) {
			if(ary[i] != newAry[i]) {
				System.out.println("NO");
				return;
			}
		}
		
		for(int i = 0; i < 2*n; i++) 
			System.out.println(opAry[i]);
	}
	
	public static void push(int num) {
		opAry[opCnt++] = '+';
		stack[++top] = num;
	}
	
	public static int pop() {
		opAry[opCnt++] = '-';
		return stack[top--];
	}

}
