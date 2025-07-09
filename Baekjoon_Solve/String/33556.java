import java.io.*;
import java.util.*;

// Java String Equals (33556번)
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String A = br.readLine();
        String B = br.readLine();
        if ("null".equals(A)) {
            bw.write("NullPointerException\n");
            bw.write("NullPointerException\n");
        } else {
            if (A.equals(B) && !"null".equals(B)) {
                bw.write("true\n");
            } else {
                bw.write("false\n");
            }
            if (A.equalsIgnoreCase(B) && !"null".equals(B)) {
                bw.write("true\n");
            } else {
                bw.write("false\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

