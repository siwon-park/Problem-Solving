// 개미굴(14725번)
////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/14725
  // 트라이 자료형을 배워보고자 배운 다음 풀어보았다.
  // 자바가 아직 익숙치 않다보니 실수를 좀 하는 바람에 많은 시간을 할애해버렸다.
  // 파이썬이였으면, 바로 슬라이싱이나 인덱싱으로 쉽게 해결했을 것인데, 그냥 생각없이 배열을 슬라이싱하는 바람에
  // 앞에 숫자가 2자리 이상 들어오면 문자열만 들어가는 것이 아니라 공백이 들어가버리는 현상이 발생하고 있었다.
  // 풀이를 하면서 느끼는 거지만 파이썬에 비해 비효율적인 듯한데, 그래도 앞으로 한 동안 자바로 계속 풀어봐야겠다.
  // 어렵고 시간이 많이 들지만, 확실히 뭔가 모듈적, 객체지향적으로 코드를 짜게되는 듯하다.
////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    static class Node {
        Map<String, Node> childNode = new HashMap<String, Node>();
    }
    
    // 트라이 구현
    static class Trie {
        Node rootNode = new Node();

        void insert(String[] strList) {

            Node node = this.rootNode;

            for (int i=0; i<strList.length; i++) {
                node = node.childNode.computeIfAbsent(strList[i], key -> new Node());
            }
        }
        // dfs
        static void dfs(Node cur, int depth) {
            if (cur.childNode != null) {
                List<String> keyList = new ArrayList<>(cur.childNode.keySet());
                Collections.sort(keyList);
                for (String key: keyList) {
                    sb.append("--".repeat(depth) + key + "\n");
                    dfs(cur.childNode.get(key), depth + 1);
                }
            }
        }
    }

    static int N;
    static String[][] stringList;
    static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = parseInt(br.readLine());
        stringList = new String[N][];
        sb = new StringBuffer();

        Trie trie = new Trie();

        for (int i=0; i<N; i++) {
            String[] tmpString = br.readLine().split(" ");
            String[] tmpStringList = new String[tmpString.length - 1];
            for (int j=1; j<tmpString.length; j++) {
                tmpStringList[j - 1] = tmpString[j];
            }
            stringList[i] = tmpStringList;
            trie.insert(tmpStringList);
        }

        trie.dfs(trie.rootNode, 0);
        System.out.print(sb.toString());
    }
}
