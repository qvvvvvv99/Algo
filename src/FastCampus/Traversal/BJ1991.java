package FastCampus.Traversal;

import java.io.*;

//BJ 1991�� Ʈ�� ��ȸ
//���� ��ȸ : ��Ʈ ��� -> ���� �ڽ� -> ������ �ڽ�
//���� ��ȸ : ���� �ڽ� -> ��Ʈ ��� -> ������ �ڽ�
//���� ��ȸ : ���� �ڽ� -> ������ �ڽ� -> ��Ʈ ���

public class BJ1991 {
	// inner class ���� �� �ݵ�� �������� ���� �� static �ʿ��ϹǷ�
	// class���� static �ʿ��ϴ�!!
	// static�� ������ �ð��� �̹� ���� �ǹǷ�
	// class�� static ���� �������� ������
	// class�� ��������� �ʾҴµ�
	// ���������� static���� ���� �ǹǷ� ���� class�� �����ϴ� �Ͱ� ����
	// ���� nullpointererror�� ���!!
	static class Node {
		public char root;
		public char left;
		public char right;
		
		public Node(char root, char left, char right){
			this.root = root;
			this.left = left;
			this.right = right;
		}
	}
	
	static Node[] tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		tree = new Node[N + 1];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			tree[i] = new Node(input[0].charAt(0), input[1].charAt(0), input[2].charAt(0));
		}
		Node root = tree[0];

		preorder(root);
		System.out.println();
		inorder(root);
		System.out.println();
		postorder(root);
		System.out.println();
	}

	public static void preorder(Node node) {
		System.out.print(node.root);
		if (node.left != '.') {
			int i = 0;
			while(true) {
				if(tree[i].root == node.left)
					break;
				i++;
			}
			preorder(tree[i]);
		}
		if (node.right != '.') {
			int i = 0;
			while(true) {
				if(tree[i].root == node.right)
					break;
				i++;
			}
			preorder(tree[i]);
		}
	}

	public static void inorder(Node node) {
		if (node.left != '.') {
			int i = 0;
			while(true) {
				if(tree[i].root == node.left)
					break;
				i++;
			}
			inorder(tree[i]);
		}
		System.out.print(node.root);
		if (node.right != '.') {
			int i = 0;
			while(true) {
				if(tree[i].root == node.right)
					break;
				i++;
			}
			inorder(tree[i]);
		}
	}

	public static void postorder(Node node) {
		if (node.left != '.') {
			int i = 0;
			while(true) {
				if(tree[i].root == node.left)
					break;
				i++;
			}
			postorder(tree[i]);
		}
		if (node.right != '.') {
			int i = 0;
			while(true) {
				if(tree[i].root == node.right)
					break;
				i++;
			}
			postorder(tree[i]);
		}
		System.out.print(node.root);
	}

}