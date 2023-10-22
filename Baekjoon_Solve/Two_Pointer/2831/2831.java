// 댄스 파티 (2831번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> menLow = new ArrayList<>();
        ArrayList<Integer> menHigh = new ArrayList<>();
        ArrayList<Integer> womenLow = new ArrayList<>();
        ArrayList<Integer> womenHigh = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	int h = Integer.parseInt(st.nextToken());
        	if (h < 0) { // 자신보다 낮은 사람과 매칭
        		menLow.add(h);
        	} else { // 자신보다 높은 사람과 매칭
        		menHigh.add(h);
        	}
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	int h = Integer.parseInt(st.nextToken());
        	if (h < 0) {
        		womenLow.add(h);
        	} else {
        		womenHigh.add(h);
        	}
        }
        
        // 정렬
        Collections.sort(menLow, (o1, o2) -> Integer.compare(o2, o1));
        Collections.sort(womenHigh, (o1, o2) -> Integer.compare(o2, o1));
        int s = menLow.size() - 1;
        int e = 0;
        while (s >= 0 && e < womenHigh.size()) {
        	int mh = Math.abs(menLow.get(s));
        	int wh = womenHigh.get(e);
        	if (mh > wh) {
        		ans += 1;
        		s -= 1;
        		e += 1;
        	} else {
        		e += 1;
        	}
        }
        
        // 정렬
        Collections.sort(menHigh);
        Collections.sort(womenLow);
        s = menHigh.size() - 1;
        e = 0;
        while (s >= 0 && e < womenLow.size()) {
        	int mh = menHigh.get(s);
        	int wh = Math.abs(womenLow.get(e));
        	if (mh < wh) {
        		ans += 1;
        		s -= 1;
        		e += 1;
        	} else {
        		s -= 1;
        	}
        }
        
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
