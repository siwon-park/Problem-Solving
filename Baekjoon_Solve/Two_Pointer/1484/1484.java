// 다이어트 (1484번)
import java.io.*;
import java.util.TreeSet;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int G = Integer.parseInt(br.readLine());
        int s = 1;
        int e = 1;
        TreeSet<Integer> set = new TreeSet<>();
        while (true) {
            if ((e * e) - (s * s) == G) set.add(e);
            if ((e * e) - (s * s) >= G) { // 결과가 G 이상이면 s를 증가시켜서 차이를 좁힘
                s += 1;
            }
            if ((e * e) - (s * s) < G) { // 결과가 G보다 작으면 e를 증가시켜 차이를 늘림
                e += 1;
            }
            if (e - s == 1 && (e * e) - (s * s) > G) break; // 차이가 1밖에 안 나는데 결과가 G보다 크면 break
        }

        if (set.isEmpty()) bw.write(-1 + "\n");

        for (Integer i : set) {
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}