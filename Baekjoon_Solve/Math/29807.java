// 학번을 찾아줘! (29807번)
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		int[] scores = new int[5];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < T; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
		}
		
		long stdNum = 0L;
		if (scores[0] > scores[2]) {
			stdNum += (scores[0] - scores[2]) * 508;
		} else {
			stdNum += (scores[2] - scores[0]) * 108;
		}
		
		if (scores[1] > scores[3]) {
			stdNum += (scores[1] - scores[3]) * 212;
		} else {
			stdNum += (scores[3] - scores[1]) * 305;
		}
		
		stdNum += scores[4] * 707;
		stdNum *= 4763;
		
		bw.write(stdNum + "");
		bw.flush();
		bw.close();
		br.close();
	}
}