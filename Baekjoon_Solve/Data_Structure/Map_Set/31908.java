import java.io.*;
import java.util.*;

// 커플링 매치 (31908번)
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Map<String, ArrayList<String>> coupleRingMap = new HashMap<>();
        Map<String, String> ringCoupleMap = new HashMap<>();
        String p, s;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            // p: 사람, s: 반지
            p = st.nextToken();
            s = st.nextToken();
            if ("-".equals(s)) continue;
	    // coupleRingMap.computeIfAbsent(s, k -> new ArrayList<>()).add(p);
            if (!coupleRingMap.containsKey(s)) {
                coupleRingMap.put(s, new ArrayList<>());
                coupleRingMap.get(s).add(p);
            } else {
                coupleRingMap.get(s).add(p);
                if (coupleRingMap.get(s).size() == 2) {
                    ringCoupleMap.put(s, coupleRingMap.get(s).get(0) + " " + coupleRingMap.get(s).get(1));
                } else if (coupleRingMap.get(s).size() > 2) {
                    ringCoupleMap.remove(s);
                }
            }
        }

        System.out.println(ringCoupleMap.size());
        for (String couple: ringCoupleMap.values()) {
            System.out.println(couple);
        }

    }
}
