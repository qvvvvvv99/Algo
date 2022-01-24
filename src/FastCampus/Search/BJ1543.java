package FastCampus.Search;

// BJ 1543�� ���� �˻�
// ���ڿ��� ���ĺ� �ҹ��ڿ� '����'���� �̷���� �ִ�.
// ���� ����� ���͸� �������� �и��ϴ� Scanner�� ����ϱ� ���ٴ�
// ���͸� �������� ���ڿ��� �и��ϴ� BufferedReader�� ����Ѵ�.
// �ð����⵵ : O(MN) -> 2500 * 50 = 125000
// ����Ž�������� ���� ��

import java.io.*;

public class BJ1543 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String data = br.readLine();
		String search = br.readLine();
		int cnt = 0, i = 0;

		while(data.length()-i >= search.length()) {
			for (int j = 0; j < search.length(); j++) {
				if (search.charAt(j) != data.charAt(i + j)) {
					i++;
					break;
				}
				if (j == search.length()-1) {
					cnt++;
					i += search.length();
				}
			}
		}
		
		System.out.println(cnt);
	}

}
