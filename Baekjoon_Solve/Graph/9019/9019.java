// DSLR (15480번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = 10000;
	static int T, A, B; // 테스트 케이스
	static String[] visited;
	
	
	static String bfs(Queue<Pair> queue) {
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			int n = convert(pair);
			if (n == B) return visited[n];
			
			int mod = (n * 2) % MAX;
			if (visited[mod].isEmpty() && mod != A) {
				visited[mod] = visited[n] + "D";
				queue.add(deconvert(mod));
			}
			
			if (n == 0 && MAX - 1 != A) {
				if (visited[MAX - 1].isEmpty()) {
					visited[MAX - 1] = visited[n] + "S";
					queue.add(deconvert(MAX - 1));
				}
			} else if (1 <= n && n < MAX && n - 1 != A) {
				if (visited[n - 1].isEmpty()) {
					visited[n - 1] = visited[n] + "S";
					queue.add(deconvert(n - 1));
				}
			}

			
			Pair pairL = rotateL(pair);
			int nL = convert(pairL);
			if (visited[nL].isEmpty() && nL != A) {
				visited[nL] = visited[n] + "L";
				queue.add(pairL);
			}
			
			Pair pairR = rotateR(pair);
			int nR = convert(pairR);
			if (visited[nR].isEmpty() && nR != A) {
				visited[nR] = visited[n] + "R";
				queue.add(pairR);
			}
		}
		return "";
	}
	
	
	static int convert(Pair pair) {
		return (((pair.d1 * 10) + pair.d2) * 10 + pair.d3) * 10 + pair.d4;
	}
	
	
	static Pair deconvert(int n) {
		Pair newPair = new Pair();
		int[] tmp = new int[4];
		for (int i = 0; i < 4; i++) {
			int d = n % 10;
			tmp[3 - i] = d;
			n /= 10;
		}
		newPair.d1 = tmp[0];
		newPair.d2 = tmp[1];
		newPair.d3 = tmp[2];
		newPair.d4 = tmp[3];
		return newPair;
	}
	
	
	static Pair rotateR(Pair pair) {
		Pair newPair = new Pair();
		newPair.d1 = pair.d4;
		newPair.d2 = pair.d1;
		newPair.d3 = pair.d2;
		newPair.d4 = pair.d3;
		return newPair;
	}
	
	
	static Pair rotateL(Pair pair) {
		Pair newPair = new Pair();
		newPair.d1 = pair.d2;
		newPair.d2 = pair.d3;
		newPair.d3 = pair.d4;
		newPair.d4 = pair.d1;
		return newPair;
	}
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			visited = new String[MAX];
			for (int i = 0; i < MAX; i++) visited[i] = new String();

			Pair pair = new Pair();
			int[] tmp = new int[4];
			int tmpA = A;
			for (int i = 0; i < 4; i++) {
				int d = tmpA % 10;
				tmp[3 - i] = d;
				tmpA /= 10;
			}
			
			pair.d1 = tmp[0];
			pair.d2 = tmp[1];
			pair.d3 = tmp[2];
			pair.d4 = tmp[3];
			Queue<Pair> queue = new LinkedList<>();
			queue.add(pair);
			bw.write(bfs(queue).toString() + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}


class Pair {
	int d1;
	int d2;
	int d3;
	int d4;
	
	Pair() {
		
	}
	
	Pair(int d1, int d2, int d3, int d4) {
		this.d1 = d1;
		this.d2 = d2;
		this.d3 = d3;
		this.d4 = d4;
	}
}