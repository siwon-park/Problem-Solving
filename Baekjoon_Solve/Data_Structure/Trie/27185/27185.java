// The Tree (27185번)
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Q = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		Trie trie = new Trie();
		trie.c = C;
		String path;
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			if (t == 1) {
				int x = Integer.parseInt(st.nextToken());
				path = br.readLine();
				trie.update(path, x);
			} else {
				path = br.readLine();
				bw.write(trie.getColor(path) + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

class Node {
	Node leftNode;
	Node rightNode;
	int lazy;
	int color;
	
	Node() {
		this.lazy = -1;
		this.color = -1;
	}
}

class Trie {
	Node root = new Node();
	int c;
	
	void lazyProps(Node node) {
		if (node.leftNode == null) node.leftNode = new Node();
		if (node.rightNode == null) node.rightNode = new Node();
		if (node.lazy != -1) {
			node.color = node.lazy;
			node.leftNode.lazy = (node.lazy + 1) % c;
			node.rightNode.lazy = (node.lazy - 1 + c) % c;
			node.lazy = -1;
		}
	}
	
	void update(String path, int x) {
		Node node = this.root;
		for (int i = 0; i < path.length(); i++) {
			lazyProps(node);
			if (path.charAt(i) == 'L') {
				node = node.leftNode;
			} else {
				node = node.rightNode;
			}
		}
		
		node.lazy = x;
		lazyProps(node);
	}
	
	int getColor(String path) {
		Node node = this.root;
		for (int i = 0; i < path.length(); i++) {
			lazyProps(node);
			if (path.charAt(i) == 'L') {
				node = node.leftNode;
			} else {
				node = node.rightNode;
			}
		}
		lazyProps(node);
		return node.color;
	}
}
