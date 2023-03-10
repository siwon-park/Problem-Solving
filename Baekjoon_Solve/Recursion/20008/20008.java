import java.io.*;
import java.util.StringTokenizer;


public class Main {

    static class Skill {
        int c;
        int d;
        Skill(int c, int d) {
            this.c = c;
            this.d = d;
        }
    }

    static void backtrack(int left, int t) {
        if (left <= 0) {
            ans = Math.min(ans, t);
            return;
        }
        boolean flag = false; // 쿨타임이 차서 스킬을 사용할 수 있음 유무
        for (int i = 0; i < N; i++) {
            Skill skill = skills[i];
            if (time[i] + skill.c <= t) { // 스킬 i를 사용한 시간에 쿨을 더 했을 때의 시간이 t보다 작거나 같으면 사용 가능
                int tmp = time[i];
                time[i] = t; // i 번째 스킬을 사용한 시간을 기록
                backtrack(left - skill.d, t + 1);
                time[i] = tmp;
                flag = true;
            }
        }
        if (!flag) backtrack(left, t + 1);
    }

    static int N, HP;
    static Skill[] skills;
    static int[] time; // i번 스킬을 사용한 시간
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        HP = Integer.parseInt(st.nextToken());

        time = new int[N];
        skills = new Skill[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            skills[i] = new Skill(c, d);
            time[i] -= c; // 0초에 스킬을 사용하기 위해 음수로 기록
        }
        backtrack(HP, 0);
        
        System.out.println(ans);
    }
}