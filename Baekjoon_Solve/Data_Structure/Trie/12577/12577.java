// File Fix-it (Small) (12577번)
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Trie trie = new Trie();
			for (int i = 0; i < N; i++) {
				trie.insert(br.readLine());
			}
			
			int ans = 0;
			for (int i = 0; i < M; i++) {
				ans += trie.insert(br.readLine());
			}
			bw.write("Case #" + tc + ": " + ans + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

class Node {
	HashMap<String, Node> children = new HashMap<>();
}

class Trie {
	Node root = new Node();
	
	int insert(String dir) {
		Node node = this.root;
		int cnt = 0;
		String[] dirArr = dir.split("\\/"); // /로 파싱하면 맨 앞은 공백이므로 인덱스를 1부터 시작함
		for (int i = 1; i < dirArr.length; i++) {
			if (!node.children.containsKey(dirArr[i])) {
				node.children.put(dirArr[i], new Node());
				cnt += 1;
			}
			node = node.children.get(dirArr[i]);
		}
		
		return cnt;
	}
}
