import java.io.*;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        for (int i = 0; i < L; i++) {
            String studentNum = br.readLine();
            if (linkedHashSet.contains(studentNum)) linkedHashSet.remove(studentNum);
            linkedHashSet.add(studentNum);
        }

        int k = 0;
        for (String s : linkedHashSet) {
            sb.append(s + "\n");
            k++;
            if (k == K) break;
        }

        System.out.println(sb);
    }
}