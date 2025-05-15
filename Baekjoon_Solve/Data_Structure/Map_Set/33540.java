import java.io.*;
import java.util.*;

// Helping Out (33540번)
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String M = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            treeMap.computeIfPresent(M, (key, v) -> v + k);
            treeMap.putIfAbsent(M, k);
        }

        for (String key : treeMap.keySet()) {
            bw.write(key + " " + treeMap.get(key) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

