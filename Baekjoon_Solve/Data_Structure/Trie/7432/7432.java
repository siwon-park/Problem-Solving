// 디스크 트리 (7432번)
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Trie trie = new Trie();
		for (int i = 0; i < N; i++) {
			trie.insert(br.readLine());
		}
		
		trie.search(trie.root, "", bw);
		
		bw.flush();
		bw.close();
		br.close();
	}
}

class Node {
	TreeMap<String, Node> children = new TreeMap<>();
}

class Trie {
	Node root = new Node();
	
	void insert(String hierachy) {
		Node node = this.root;
		String[] words = hierachy.split("\\\\");
		for (String word : words) {
			if (!node.children.containsKey(word)) {
				node.children.put(word, new Node());
			}
			node = node.children.get(word);
		}
	}
	
	void search(Node node, String prefix, BufferedWriter bw) throws IOException {
		for (String word : node.children.keySet()) {
			bw.write(prefix + word + "\n");
			search(node.children.get(word), prefix + " ", bw);
		}
	}
}
