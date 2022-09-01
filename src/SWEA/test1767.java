package SWEA;

/////////////////////////////////////////////////////////////////////////////////////////////
//�⺻ �����ڵ�� ���� �����ص� ���� �����ϴ�. ��, ����� ���� ����
//�Ʒ� ǥ�� ����� ���� �ʿ�� �����ϼ���.
//ǥ�� �Է� ����
//int a;
//double b;
//char g;
//String var;
//long AB;
//a = sc.nextInt();                           // int ���� 1�� �Է¹޴� ����
//b = sc.nextDouble();                        // double ���� 1�� �Է¹޴� ����
//g = sc.nextByte();                          // char ���� 1�� �Է¹޴� ����
//var = sc.next();                            // ���ڿ� 1�� �Է¹޴� ����
//AB = sc.nextLong();                         // long ���� 1�� �Է¹޴� ����
/////////////////////////////////////////////////////////////////////////////////////////////
//ǥ�� ��� ����
//int a = 0;                            
//double b = 1.0;               
//char g = 'b';
//String var = "ABCDEFG";
//long AB = 12345678901234567L;
//System.out.println(a);                       // int ���� 1�� ����ϴ� ����
//System.out.println(b); 		       						 // double ���� 1�� ����ϴ� ����
//System.out.println(g);		       						 // char ���� 1�� ����ϴ� ����
//System.out.println(var);		       				   // ���ڿ� 1�� ����ϴ� ����
//System.out.println(AB);		       				     // long ���� 1�� ����ϴ� ����
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;

/*
����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
�̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
*/
public class test1767 {
	static int min, conn, core;

	public static void main(String args[]) throws Exception {
		/*
		 * ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
		 */

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			min = Integer.MAX_VALUE;
			conn = 0;
			core = 0;
			int[][] check = new int[N][4]; // �����¿� ��
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 1)
						core++;
				}
			}

			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (map[0][j] == 1) {
					check[j][0] = 1;
					cnt++;
				}
				if (map[N - 1][j] == 1) {
					check[j][1] = 1;
					cnt++;
				}

			}
			for (int j = 1; j < N - 1; j++) {
				if (map[j][0] == 1) {
					check[j][2] = 1;
					cnt++;
				}
				if (map[j][N - 1] == 1) {
					check[j][3] = 1;
					cnt++;
				}
			}

			DFS(map, N, check, 1, 1, cnt, cnt, 0);

			System.out.println("#" + test_case + " ");
		}
	}

	public static int DFS(int[][] map, int N, int[][] check, int x, int y, int cnt, int visited, int sum) {
		if(visited == core) {
			if(cnt > conn) {
				min = sum;
			}
			else if(cnt == conn) {
				if(min > sum)
					min = sum;
			}
			return min;
		}
		return 0;
		
	}
}