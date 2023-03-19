import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Heap heap = new Heap(N);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                heap.add(Integer.parseInt(st.nextToken()));
                if (heap.isFull()) heap.poll();
            }
        }

        int ret = heap.peek();
        System.out.println(ret);
    }
}

class Heap {
    int last;
    int[] tree;
    int maxSize;

    Heap(int n) {
        this.last = 0;
        this.maxSize = n + 1;
        this.tree = new int[n + 2]; // 크기가 n + 2인 힙 선언
    }

    boolean isFull() {
        return last == maxSize;
    }

    void add(int data) {
        tree[++last] = data;
        int c = last;
        int p = c / 2;
        while (p > 0 && tree[p] > tree[c]) {
            int tmp = tree[c];
            tree[c] = tree[p];
            tree[p] = tmp;
            c = p;
            p = c / 2;
        }
    }

    int poll() {
        int val = tree[1];
        tree[1] = tree[last--];
        int p = 1;
        int c = 2 * p;
        while (c <= last) {
            if (c + 1 <= last && tree[c + 1] < tree[c]) {
                c++;
            }
            if (tree[p] > tree[c]) {
                int tmp = tree[c];
                tree[c] = tree[p];
                tree[p] = tmp;
                p = c;
                c = 2 * p;
            } else {
                break;
            }
        }
        return val;
    }

    int peek() {
        return tree[1];
    }
}