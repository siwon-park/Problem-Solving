import java.io.*;
import java.util.*;

// 학생 인기도 측정 (25325번)
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> map = new TreeMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) map.put(st.nextToken(), 0);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                map.compute(st.nextToken(), (k, v) -> v + 1);
            }
        }

        Pair[] pairs = new Pair[n];
        int idx = 0;
        for (String key : map.keySet()) {
            pairs[idx++] = new Pair(key, map.get(key));
        }
        Arrays.sort(pairs, (o1, o2) -> {
            if (o1.value < o2.value) return 1;
            else if (o1.value > o2.value) return -1;
            else return o1.name.compareTo(o2.name);
        });

        for (Pair pair : pairs) {
            bw.write(pair.name + " " + pair.value + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

class Pair {
    String name;
    int value;

    Pair(String name, int value) {
        this.name = name;
        this.value = value;
    }
}

