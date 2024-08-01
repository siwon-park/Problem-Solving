// 알록달록 앵무새 (28445번) - 람다식 정렬 사용
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		TreeSet<String> treeSet = new TreeSet<>((o1, o2) -> o1.compareTo(o2));
		StringTokenizer st = new StringTokenizer(br.readLine());
		treeSet.add(st.nextToken());
		treeSet.add(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		treeSet.add(st.nextToken());
		treeSet.add(st.nextToken());
		
		ArrayList<Pair> arrayList = new ArrayList<>();
		for (String s1 : treeSet) {
			for (String s2 : treeSet) {
				arrayList.add(new Pair(s1, s2));
			}
		}
		
		arrayList.sort(Comparator
				.comparing(Pair::getBody)
				.thenComparing(Pair::getTail));
		
		for (Pair p : arrayList) {
			bw.write(p.body + " " + p.tail + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

class Pair {
	String body, tail;
	Pair() {}
	Pair(String body, String tail) {
		this.body = body;
		this.tail = tail;
	}
	
	public String getBody() {
		return this.body;
	}
	
	public String getTail() {
		return this.tail;
	}
}
