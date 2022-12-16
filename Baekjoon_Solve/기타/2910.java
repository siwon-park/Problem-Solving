// 빈도 정렬 (2910번)
//////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/2910
  // 정렬, 해시맵
  // 자바의 커스텀 정렬을 처음으로 구현하여 사용해보았다.
  // 누군가 블로그에 글을 정말 잘 정리해놓아서 커스텀 정렬에 대해 보다 많은 이해를 할 수 있었다.
  // 파이썬에서는 간단하게 딕셔너리 자료형으로 해결되는 문제가 자바에서는 이렇게 길게 써야한다.
  // 앞으로 정렬뿐만 아니라, 자바의 자료 구조를 잘 사용할 수 있도록 학습해야겠다.
//////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;

public class Main {

    static class Pair implements Comparable<Pair> {

        int count;
        int index;
        int num;

        Pair(int count, int index, int num) {
            this.count = count;
            this.index = index;
            this.num = num;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.count > o.count) {
                return -1;
            } else if (this.count < o.count) {
                return 1;
            } else {
                if (this.index > o.index) {
                    return 1;
                } else if (this.index < o.index) {
                    return -1;
                }
                return 0;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> indexMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            int number = Integer.parseInt(st2.nextToken());
            indexMap.putIfAbsent(number, i);
            if (countMap.get(number) == null) {
                countMap.put(number, 1);
            } else {
                countMap.put(number, countMap.get(number) + 1);
            }
        }

        ArrayList<Pair> pairs = new ArrayList<>();
        ArrayList<Integer> keys = new ArrayList<>(countMap.keySet());
        for (int key : keys) {
            int cnt = countMap.get(key);
            int idx = indexMap.get(key);
            int number = key;
            pairs.add(new Pair(cnt, idx, number));
        }

        Collections.sort(pairs);
        for (Pair pair : pairs) {
            for (int i=0; i<pair.count; i++) {
                bw.write(pair.num + " ");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
