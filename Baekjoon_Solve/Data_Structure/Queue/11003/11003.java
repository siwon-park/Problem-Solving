import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        MyDeque deque = new MyDeque();
        for (int i = 1; i < N + 1; i++) {
            int A = Integer.parseInt(st.nextToken());
            // 덱에서 나보다 큰 값을 삭제함
            while (!deque.isEmpty() && deque.peekLast().val > A) {
                deque.pollLast();
            }
            // 범위를 벗어난 값이 있다면 삭제함
            while (!deque.isEmpty() && deque.peekFirst().idx < i - L + 1) {
                deque.pollFirst();
            }

            deque.addLast(new Node(A, i));
            sb.append(deque.peekFirst().val + " ");
        }

        System.out.println(sb.toString());
    }
}

class Node {
    int val;
    int idx;
    Node prev;
    Node next;
    Node() {}
    Node(int val , int idx) {
        this.val = val;
        this.idx = idx;
    }
}

class MyDeque {
    Node HEAD;
    Node TAIL;
    int size;

    MyDeque() {
        this.size = 0;
        this.HEAD = this.TAIL = null;
    }

    void addFirst(Node newNode) { // 맨 앞에 새로운 노드를 삽입
        newNode.next = this.HEAD; // 새로운 노드의 다음을 현재의 HEAD로 연결함
        if (this.HEAD != null) this.HEAD.prev = newNode; // 현재의 HEAD의 이전을 새로운 노드로 연결함
        this.HEAD = newNode; // 현재의 HEAD를 새로운 노드로 갱신함
        this.size ++;
        if (this.HEAD.next == null) this.TAIL = this.HEAD; // 노드가 1개라면 HEAD가 TAIL임
    }

    void addLast(Node newNode) {
        if (size == 0) {
            addFirst(newNode);
            return;
        }
        this.TAIL.next = newNode; // 현재의 TAIL의 다음을 새로운 노드로 연결함
        newNode.prev = this.TAIL; // 새로운 노드의 이전을 현재의 TAIL로 연결함
        this.TAIL = newNode; // 현재의 TAIL을 새로운 노드로 갱신함
        this.size ++;
    }

    Node pollFirst() { // 맨 앞의 노드 값을 뽑고 출력함
        Node node = this.HEAD;
        Node nextNode = this.HEAD.next; // HEAD의 다음 노드
        if (nextNode != null) nextNode.prev = null;
        this.HEAD = nextNode;
        this.size --;
        if (this.size == 0) this.TAIL = null;
        return node;
    }

    Node peekFirst() { // 맨 앞의 노드 값을 출력함
        return this.HEAD;
    }

    Node pollLast() { // 맨 뒤의 노드 값을 뽑고 출력함
       Node node = this.TAIL;
       Node prevNode = this.TAIL.prev;
       if (prevNode != null) prevNode.next = null;
       this.TAIL = prevNode;
       this.size--;
       if (this.size == 0) this.HEAD = null;
       return node;
    }

    Node peekLast() { // 맨 뒤의 노드 값을 출력함
        return this.TAIL;
    }

    int size() {
        return this.size;
    }

    boolean isEmpty() {
        return this.size == 0;
    }
}