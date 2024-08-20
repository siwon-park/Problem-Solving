// 게임 닉네임 (16934번)
import java.io.*;
import java.util.*;

public class Main {
	
	static void insert(Trie trie, String words) {
		int len = words.length(); // 문자열의 길이
		for (int i = 0; i < len; i++) {
			char c = words.charAt(i);
			if (trie.children.get(c) == null) {
				trie.children.put(c, new Trie());
				trie.isUnique = true;
			} else {
				trie.isUnique = false; // 이미 있는 단어면 isUnique를 false로 함
			}
			trie = trie.children.get(c);
		}
		trie.isEnd = true;
	}
	
	static StringBuilder searchPrefix(Trie trie, String words) {
		StringBuilder sb = new StringBuilder();
		int len = words.length();
		for (int i = 0; i < len; i++) {
			char c = words.charAt(i);
			sb.append(c);
			if (trie.isUnique) return sb; // 단어가 unique하면 return;
			trie = trie.children.get(c);
		}
		return sb;
	}
	
	static HashMap<String, Integer> trieHashMap; // 트라이 안에 있는 단어
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		trieHashMap = new HashMap<>();
		int N = Integer.parseInt(br.readLine());
		Trie root = new Trie();
		StringBuilder sb;
		for (int i = 0; i < N; i++) {
			String words = br.readLine(); // 유저 이름
			if (trieHashMap.get(words) == null) { // 새로운 유저일 경우
				trieHashMap.put(words, 1);
				insert(root, words);
				sb = searchPrefix(root, words);
				bw.write(sb.toString() + "\n");
			} else {
				trieHashMap.computeIfPresent(words, (k, v) -> v + 1);
				bw.write(words + trieHashMap.get(words) + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
 	}
}


class Trie {
	boolean isEnd;
	boolean isUnique = false; // 유일성 유무
	HashMap<Character, Trie> children = new HashMap<>();
	Trie() {}
}