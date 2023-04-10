import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 문제의 개수
        Problem[] problems = new Problem[N];
        Heap<MaxComp> maxHeap = new Heap<>(100000, new MaxComp());
        Heap<MinComp> minHeap = new Heap<>(100000, new MinComp());

        int P, L;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            P = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            problems[i] = new Problem(P, L);
            maxHeap.add(problems[i]);
            minHeap.add(problems[i]);
        }

        int M = Integer.parseInt(br.readLine()); // 쿼리의 개수
        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            if (line[0].equals("add")) {
                P = Integer.parseInt(line[1]); // 문제 번호
                L = Integer.parseInt(line[2]); // 난이도
                maxHeap.add(new Problem(P, L));
                minHeap.add(new Problem(P, L));
            } else if (line[0].equals("recommend")) {
                int x = Integer.parseInt(line[1]);
                if (x == 1) bw.write(maxHeap.peek().pNo + "\n");
                else bw.write(minHeap.peek().pNo + "\n");
            } else {
                P = Integer.parseInt(line[1]);
                maxHeap.remove(P);
                minHeap.remove(P);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

class Problem {
    int pNo; // 문제 번호
    int lvl; // 난이도

    Problem(int pNo, int lvl) {
        this.pNo = pNo;
        this.lvl = lvl;
    }
}

interface ProblemComparator {
    boolean comparator(Problem o1, Problem o2);
}

class MaxComp implements ProblemComparator {
    @Override
    public boolean comparator(Problem o1, Problem o2) {
        if (o1.lvl > o2.lvl) return true;
        else if (o1.lvl == o2.lvl && o1.pNo > o2.pNo) return true;
        return false;
    }
}

class MinComp implements ProblemComparator {
    @Override
    public boolean comparator(Problem o1, Problem o2) {
        if (o1.lvl < o2.lvl) return true;
        else if (o1.lvl == o2.lvl && o1.pNo < o2.pNo) return true;
        return false;
    }
}

class Heap <Comp extends ProblemComparator> {
    Comp comp;
    int last;
    int maxSize;
    int[] memo;
    Problem[] heap;

    Heap(int n, Comp comp) {
        this.last = 0;
        this.maxSize = n;
        this.memo = new int[n + 1];
        this.heap = new Problem[n + 1];
        this.comp = comp;
    }

    void add(Problem o) {
        if (last == maxSize) return;
        heap[++last] = o;
        memo[o.pNo] = last;

        int c = last;
        int p = c / 2;
        while (p > 0 && comp.comparator(heap[c], heap[p])) {
            swap(p, c);
            memo[heap[p].pNo] = p;
            memo[heap[c].pNo] = c;
            c = p;
            p = c / 2;
        }
    }

    Problem peek() {
        return heap[1];
    }

    void remove(int pNo) {
        int rmIdx = memo[pNo];
        if (rmIdx > last) return;
        heap[rmIdx] = heap[last--];
        memo[heap[rmIdx].pNo] = rmIdx;

        int c = rmIdx;
        int p = c / 2;
        while (p > 0 && comp.comparator(heap[c], heap[p])) {
            swap(p, c);
            memo[heap[p].pNo] = p;
            memo[heap[c].pNo] = c;
            c = p;
            p = c / 2;
        }

        p = rmIdx;
        c = 2 * p;
        while (c <= last) {
            if (c + 1 <= last && comp.comparator(heap[c + 1], heap[c])) c += 1;
            if (comp.comparator(heap[c], heap[p])) {
                swap(p, c);
                memo[heap[p].pNo] = p;
                memo[heap[c].pNo] = c;
                p = c;
                c = 2 * p;
            } else break;
        }
    }

    void swap(int p, int c) {
        Problem tmp = heap[c];
        heap[c] = heap[p];
        heap[p] = tmp;
    }
}