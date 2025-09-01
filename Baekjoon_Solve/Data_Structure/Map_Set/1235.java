import java.io.*;
import java.util.*;

// 학생 번호 (1235번)
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(br.readLine());

        int M = list.get(0).length();
        int k = M;
        for (int i = 0; i < M; i++) {
            Set<String> set = new HashSet<>();
            for (String s : list) {
                set.add(s.substring(M - 1 - i, M));
            }
            if (set.size() == list.size()) {
                k = i + 1;
                break;
            }
        }

        System.out.println(k);
    }
}
