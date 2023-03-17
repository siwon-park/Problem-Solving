import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;


        int T = Integer.parseInt(br.readLine()); // 테스트케이스의 수
        for (int tc = 1; tc <= T; tc++) {
            int M = Integer.parseInt(br.readLine()); // 수열의 크기
            MinHeap minHeap = new MinHeap(M); // 크기가 M인 최소힙 생성
            MaxHeap maxHeap = new MaxHeap(M); // 크기가 M인 최대힙 생성
            sb = new StringBuilder(); // 중앙값을 저장할 StringBuilder

            int N = M / 10; // M을 10의 단위로 끊음
            int cnt = 0;
            for (int i = 0; i < N + 1; i++) {
                String[] line = br.readLine().split(" ");
                int m = line.length;
                for (int j = 0; j < m; j++) {
                    int data = Integer.parseInt(line[j]);
                    if (j % 2 == 0) { // 홀수 번째 인덱스라면
                        if (!maxHeap.isEmpty() && data < maxHeap.peek()) { // 진입 값이 최대힙의 루트 값보다 작으면
                            minHeap.add(maxHeap.poll()); // 최대힙의 루트를 뽑아서 최소힙으로 주고
                            maxHeap.add(data); // 최대힙에 삽입
                        } else {
                            minHeap.add(data); // 최소힙에 삽입
                        }
                        cnt ++;
                        sb.append(minHeap.peek() + " ");
                        if (cnt % 10 == 0) {
                            sb.append("\n");
                        }
                    } else { // 짝수 번째 인덱스일 경우
                        if (!minHeap.isEmpty() && data > minHeap.peek()) { // 진입 값이 최소힙의 루트 값보다 크면
                            maxHeap.add(minHeap.poll()); // 최소힙의 루트를 뽑아서 최대\힙으로 주고
                            minHeap.add(data); // 최소힙에 삽입
                        } else { // 진입 값이 최소힙의 루트보다 작으면
                            maxHeap.add(data); // 최대힙에 바로 삽입
                        }
                    }
                }
            }
            bw.write(cnt + "\n"); // 중앙값의 개수
            bw.write(sb + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

class MinHeap {
    int last;
    int maxSize;
    int[] heap;

    MinHeap(int n) {
        this.last = 0;
        this.maxSize = n;
        this.heap = new int[n + 1];
    }

    boolean isEmpty() {
        return last == 0;
    }

    void add(int data) {
        if (last == maxSize) return;
        heap[++last] = data;
        int c = last;
        int p = c / 2;
        while (p > 0 && heap[p] > heap[c]) {
            int tmp = heap[c];
            heap[c] = heap[p];
            heap[p] = tmp;
            c = p;
            p = c / 2;
        }
    }

    int poll() {
        int val = heap[1];
        heap[1] = heap[last--];
        int p = 1;
        int c = 2 * p;
        while (c <= last) {
            if (c + 1 <= last && heap[c + 1] < heap[c]) c++;
            if (heap[p] > heap[c]) {
                int tmp = heap[c];
                heap[c] = heap[p];
                heap[p] = tmp;
                p = c;
                c = 2 * p;
            } else break;
        }
        return val;
    }

    int peek() {
        return heap[1];
    }
}

class MaxHeap {
    int last;
    int maxSize;
    int[] heap;

    MaxHeap(int n) {
        this.last = 0;
        this.maxSize = n;
        this.heap = new int[n + 1];
    }

    boolean isEmpty() {
        return last == 0;
    }

    void add(int data) {
        if (last == maxSize) return;
        heap[++last] = data;
        int c = last;
        int p = c / 2;
        while (p > 0 && heap[p] < heap[c]) {
            int tmp = heap[c];
            heap[c] = heap[p];
            heap[p] = tmp;
            c = p;
            p = c / 2;
        }
    }

    int poll() {
        int val = heap[1];
        heap[1] = heap[last--];
        int p = 1;
        int c = 2 * p;
        while (c <= last) {
            if (c + 1 <= last && heap[c + 1] > heap[c]) c++;
            if (heap[p] < heap[c]) {
                int tmp = heap[c];
                heap[c] = heap[p];
                heap[p] = tmp;
                p = c;
                c = 2 * p;
            } else break;
        }
        return val;
    }

    int peek() {
        return heap[1];
    }
}