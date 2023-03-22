import java.io.*;
import java.util.*;


public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 수열의 크기
        st = new StringTokenizer(br.readLine()); // 수열
        Heap heap = new Heap(N);
        for (int i = 0; i < N; i++) {
            heap.add(new Heap.Pair(Integer.parseInt(st.nextToken()), i + 1));
        }
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("1")) {
                int idx = Integer.parseInt(st.nextToken());
                int newVal = Integer.parseInt(st.nextToken());
                heap.update(idx, newVal);
            } else {
                bw.write(heap.peek().idx + "\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

class Heap {
    static class Pair {
        int val;
        int idx;
        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    int last;
    Pair[] heap;
    int[] memo;
    int maxSize;

    Heap(int n) {
        this.last = 0;
        this.maxSize = n;
        this.memo = new int[n + 1];
        this.heap = new Pair[n + 1];
        for (int i = 0; i < n + 1; i++) {
            heap[i] = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
    }

    boolean isMin(Pair o1, Pair o2) {
        if (o1.val < o2.val) return true;
        else if (o1.val == o2.val && o1.idx < o2.idx) return true;
        return false;
    }


    void add(Pair o) {
        if (last == maxSize) return;
        heap[++last] = o;
        memo[o.idx] = last;
        int c = last;
        int p = c / 2;
        while (p > 0 && !isMin(heap[p], heap[c])) {
            Pair tmp = heap[c];
            heap[c] = heap[p];
            heap[p] = tmp;
            memo[heap[p].idx] = p;
            memo[heap[c].idx] = c;
            c = p;
            p = c / 2;
        }
    }

    Pair poll() {
        if (last == 0) return null;
        Pair pair = heap[1];
        heap[1] = heap[last];
        heap[last--] = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
        int p = 1;
        int c = 2 * p;
        while (c <= last) {
            if (c + 1 <= last && isMin(heap[c + 1], heap[c])) c += 1;
            if (isMin(heap[c], heap[p])) {
                Pair tmp = heap[c];
                heap[c] = heap[p];
                heap[p] = tmp;
                memo[heap[p].idx] = p;
                memo[heap[c].idx] = c;
                p = c;
                c = 2 * p;
            } else break;
        }
        return pair;
    }

    void update(int idx, int newVal) { // idx에 위치한 값을 val로 변경함
        int updateIdx = memo[idx];
        heap[updateIdx].val = newVal;
        int c = updateIdx;
        int p = c / 2;
        while (p > 0 && !isMin(heap[p], heap[c])) {
            Pair tmp = heap[c];
            heap[c] = heap[p];
            heap[p] = tmp;
            memo[heap[p].idx] = p;
            memo[heap[c].idx] = c;
            c = p;
            p = c / 2;
        }

        p = updateIdx;
        c = 2 * p;
        while (c <= last) {
            if (c + 1 <= last && isMin(heap[c + 1], heap[c])) c += 1;
            if (isMin(heap[c], heap[p])) {
                Pair tmp = heap[c];
                heap[c] = heap[p];
                heap[p] = tmp;
                memo[heap[p].idx] = p;
                memo[heap[c].idx] = c;
                p = c;
                c = 2 * p;
            } else break;
        }
    }

    Pair peek() {
        return heap[1];
    }
}