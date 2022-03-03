package BJAlgo.Level3;

import java.io.*;
import java.util.*;

// 50��
public class BJ5525 {
	static String S;
	static int N, M;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	// Pn�� N
		M = Integer.parseInt(br.readLine());	// S ���ڿ� ���� M
		S = br.readLine();	// IO�� �̷���� ���ڿ�
		int cnt = 0;
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0 ; i < 2*N+1; i++) {
			if(i % 2 == 0)
				sb.append("I");
			else
				sb.append("O");
		}
	//	System.out.println(sb);
		
		for(int i = 0; i < M-(N*2); i++) {
			if(S.charAt(i) == 'I') {
				if(sb.toString().equals(S.substring(i, i+2*N+1)))
					cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}

// 100��
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();

        char[] arr = sc.next().toCharArray();
        int[] memo = new int[M];
        int ans = 0;

        for (int i = 1; i < M - 1; i++) {
            if (arr[i] == 'O' && arr[i + 1] == 'I') {
                memo[i + 1] = memo[i - 1] + 1;

                if (memo[i + 1] >= N && arr[i - 2 * N + 1] == 'I')
                    ans++;
            }
        }

        System.out.println(ans);

    }
}
