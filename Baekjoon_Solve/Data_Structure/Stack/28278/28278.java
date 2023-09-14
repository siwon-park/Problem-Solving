// 스택 2 (28278번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static myStack stack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		stack = new myStack();
		
		int op, x;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			op = Integer.parseInt(st.nextToken());
			switch (op) {
				case 1:
					x = Integer.parseInt(st.nextToken());
					stack.add(x);
					break;
				case 2:
					bw.write(stack.pop() + "\n");
					break;
				case 3:
					bw.write(stack.size() + "\n");
					break;
				case 4:
					int ans = (stack.isEmpty()) ? 1 : 0;
					bw.write(ans + "\n");
					break;
				case 5:
					bw.write(stack.peek() + "\n");
					break;
			}	
		}
		bw.flush();
		bw.close();
		br.close();
	}
}


class myStack {
	int size;
	Node top;
	
	myStack() {
		this.size = 0;
	}
	
	boolean isEmpty() {
		return size == 0;
	}
	
	void add(int x) {
		if (isEmpty()) top = new Node(x);
		Node node = new Node(x); // 새 노드 생성
		node.prev = this.top;
		this.top = node;
		this.size += 1;
	}
	
	int pop() {
		if (isEmpty()) return -1;
		int val = top.x;
		this.top = top.prev;
		this.size -= 1;
		return val;
	}
	
	int peek() {
		if (isEmpty()) return -1; 
		return top.x;
	}
	
	int size() {
		return size;
	}
}


class Node {
	int x;
	Node prev;
	Node() {}
	Node(int x) {
		this.x = x;
	}
}