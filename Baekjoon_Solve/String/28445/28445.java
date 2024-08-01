// 알록달록 앵무새 (28445번)
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
		
		Collections.sort(arrayList);
		for (Pair p : arrayList) {
			bw.write(p.body + " " + p.tail + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

class Pair implements Comparable<Pair>{
	String body, tail;
	Pair() {}
	Pair(String body, String tail) {
		this.body = body;
		this.tail = tail;
	}
	
	@Override
	public int compareTo(Pair o) {
		if (this.body.compareTo(o.body) < 0) return -1;
		else if (this.body.compareTo(o.body) > 0) return 1;
		else return this.tail.compareTo(o.tail);
	}
}
