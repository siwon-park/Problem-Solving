import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long ans = 0L;

        Customer[] customers = new Customer[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            customers[i] = new Customer(id, w);
        }

        // 계산 중 우선순위 큐
        PriorityQueue<Customer> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.w > o2.w) return Integer.compare(o1.w, o2.w);
            else if (o1.w == o2.w) return Integer.compare(o2.k, o1.k);
            return -1;
        });

        PriorityQueue<Integer> kpq = new PriorityQueue<>(); // 빈 계산대 우선순위 큐
        for (int i = 1; i < K + 1; i++) kpq.add(i);

        int k = 0;
        int t = 0; // 현재 시간
        ArrayList<Integer> idList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Customer customer = customers[i]; // 현재 고객
            if (pq.size() < K) { // 계산대가 비어있으면 계산하러 감
                k = kpq.poll(); // 가장 빠른 계산대 번호
                pq.add(new Customer(customer.id, customer.w + t, k)); // 고객 아이디, 고객이 계산을 마치는 시간, 계산대 번호
            } else { // 계산대가 가득 찼으면
                t = pq.peek().w; // 현재 시간을 계산이 제일 빨리 끝나는 시간으로 갱신
                while (!pq.isEmpty() && pq.peek().w <= t) { // 현재 시간 이하인 고객들은 계산대에서 빠짐
                    Customer outCustomer = pq.poll();
                    kpq.add(outCustomer.k); // 계산이 끝난 계산대를 빈 계산대 큐에 삽입
                    idList.add(outCustomer.id); // 고객의 아이디를 담음
                }
                k = kpq.poll(); // 가장 빠른 계산대 번호
                pq.add(new Customer(customer.id, customer.w + t, k)); // 현재 고객을 계산 중인 큐로 삽입
            }
        }
        // 남은 계산 중인 큐에서 요소를 뽑아서 리스트에 담음
        while (!pq.isEmpty()) {
            idList.add(pq.poll().id);
        }

        int i = 1;
        for (Integer id : idList) {
            ans += (long) id * i;
            i += 1;
        }

        System.out.println(ans);
    }
}

class Customer {
    int id;
    int w;
    int k;
    Customer(int id, int w) {
        this.id = id;
        this.w = w;
    }
    Customer(int id, int w, int k) {
        this.id = id;
        this.w = w;
        this.k = k;
    }
}