package FastCampus.HashSet;

import java.util.*;

// ���� 4195�� ģ�� ��Ʈ��ũ
// Union-Find �˰���

public class BJ4195 {
	static HashMap<String, String> parent;
	static HashMap<String, Integer> number;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		int F; // ģ�� ���� ��
		String name1, name2;
		
		for(int i = 0; i < tc; i++) {
			F = sc.nextInt();
			number = new HashMap<>();
			parent = new HashMap<>();
			for(int j = 0; j < F; j++) {
				name1 = sc.next();
				name2 = sc.next();
				
				// �ִ��� Ȯ���ϰ� ������ �ֱ�
				if(!parent.containsKey(name1)) {
					parent.put(name1, name1);
					number.put(name1, 1);
				}
				if(!parent.containsKey(name2)) {
					parent.put(name2, name2);
					number.put(name2, 1);
				}
				
				union(name1, name2);
				
				System.out.println(number.get(find(name1)));
			}
		}
	}
	
	// Find �Լ�
	public static String find(String name) {
		if(name.equals(parent.get(name)))
			return name;
		else {
			String p = find(parent.get(name));
			parent.replace(name, p);
			return parent.get(name);
		}
	}
	//
	public static void union(String name1, String name2) {
		name1 = find(name1);
		name2 = find(name2);
		
		if(!name1.equals(name2)) {
			int score = number.get(name1) + number.get(name2);
			parent.replace(name2, name1);
			number.replace(name1, score);
		}
	}
}
