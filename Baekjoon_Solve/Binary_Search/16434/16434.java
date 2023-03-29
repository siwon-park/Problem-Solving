import java.io.*;
import java.util.*;


public class Main {

    static long binarySearch() {
        long s = 1L;
        long e = MAX;
        long maxHP = 0;
        while (s <= e) {
            long mid = (s + e) / 2L; // 용사의 적정 최대 HP
            long curHp = mid;
            long curAtk = Hatk;
            boolean flag = true; // 용을 쓰러뜨릴 수 있음
            long aCnt; // 공격횟수((몬스터의 체력 / 용사의 공격력) 값의 올림)

            for (int i = 0; i < N; i++) {
                Room room = rooms[i]; // 방 정보
                if (room.t == 1) { // 몬스터
                    aCnt = (long) Math.ceil(room.h / (double) curAtk);
                    curHp -= (aCnt - 1) * room.a;
                    if (curHp <= 0) {
                        flag = false;
                        break; // 용사의 체력이 0이하면 break
                    }
                } else if (room.t == 2) { // 포션
                    curAtk += room.a;
                    curHp = Math.min(mid, curHp + room.h);
                }
            }

            if (!flag) { // 용을 잡을 수 없으면
                s = mid + 1; // 최대 체력을 늘림
            } else { // 용을 잡을 수 있으면
                e = mid - 1; // 최대 체력을 줄여서 탐색
                maxHP = mid;
            }
        }
        return maxHP;
    }

    static int N, Hatk; // 방의 개수, 용사의 초기 공격력
    static long MAX = 1L;
    static Room[] rooms;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Hatk = Integer.parseInt(st.nextToken());

        rooms = new Room[N];
        int t, a, h;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            rooms[i] = new Room(t, a, h);
            if (t == 1) {
                MAX += (long) Math.ceil(h / (double) Hatk) * a;
            }
        }

        long ret = binarySearch();
        System.out.println(ret);

    }
}

class Room {
    int t;
    int a;
    int h;
    Room(int t, int a, int h) {
        this.t = t;
        this.a = a;
        this.h = h;
    }
}