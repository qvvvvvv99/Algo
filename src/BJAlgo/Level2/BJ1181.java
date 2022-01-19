package BJAlgo.Level2;

import java.util.*;

// 1181�� �ܾ� ����
// N���� �ܾ ������ 1.���̰� ª�� �ͺ��� 2. ���̰� ������ ���� ������ ����

public class BJ1181 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++)
			list.add(sc.next());

		Collections.sort(list, new SortList());
		
		System.out.println(list.get(0));
		for(int i = 1; i < N; i++) {
			if(!list.get(i).equals(list.get(i-1)))
				System.out.println(list.get(i));
		}
	}
}

class SortList implements Comparator<String> {
	int ret = 0;

	@Override
	public int compare(String s1, String s2) {
		// TODO Auto-generated method stub
		if(s1.length() == s2.length())
			return s1.compareTo(s2);
		else {
			return s1.length() - s2.length();
		}
	}

}