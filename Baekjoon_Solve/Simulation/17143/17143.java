// 낚시왕 (17143번)
import java.io.*;
import java.util.*;

public class Main {

	static int R, C, M; // 행, 열, 상어 수
	static int[][] graph; // 격자판
	static Fish[] fishes;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static Queue<Fish> aliveFishes;
	
	/*
	 * 물고기가 움직임
	 * */
	static void moveFish() {
		ArrayList<Fish> tempFishList = new ArrayList<>();
		while (!aliveFishes.isEmpty()) {
			Fish fish = aliveFishes.poll();
			if (!fish.alive) continue;
			graph[fish.r][fish.c] = 0;
			fish = move(fish); // 움직인 후의 물고기
			tempFishList.add(fish);
		}
		
		tempFishList.sort((o1, o2) -> Integer.compare(o2.z, o1.z)); // 크기 기준 내림차순 정렬
		for (Fish tmpFish : tempFishList) {
			if (graph[tmpFish.r][tmpFish.c] == 0) { // 빈 칸에 크기가 큰 순서대로 위치 시킴
				graph[tmpFish.r][tmpFish.c] = tmpFish.no;
				aliveFishes.add(tmpFish); // 현재 살아있는 물고기만 큐에 삽입
			}
		}
	}
	
	/*
	 * 이동 방법 -> 일단 제일 가까운 양 끝으로 이동
	 * 양끝에서 방향 전환한 다음에 행/열 - 1을 나눈 값으로 나눈 몫과 나머지를 활용
	 * 몫이 홀수일 경우 반대쪽 끝으로 이동하고 방향이 반대
	 * 몫이 짝수일 경우 방향이 같고 현재 위치 그대로
	 * 나머지 칸 수 만큼 (전환된) 방향으로 이동
	 * */
	static Fish move(Fish fish) {
		int left = fish.s; // 이동해야 할 남은 칸 수
		int q, rmd; // 몫, 나머지
		if (fish.d == 0) { // 상
			if (fish.r - fish.s >= 0) { // 방향 전환 없이 이동이 가능할 경우
				fish.r -= fish.s;
				if (fish.r == 0) fish.d = 1; // 아래로 방향 전환
			} else {
				// r을 0으로 이동 후 방향 전환 함
				left -= fish.r;
				fish.r = 0;
				fish.d = 1;
				q = left / (R - 1);
				rmd = left % (R - 1);
				if (q % 2 == 0) fish.r += rmd; // 짝수일 경우 방향, 위치 그대로이고 칸 수만 이동
				else { // 홀수일 경우 위치는 반대쪽 끝이고, 방향 전환 후 남은 칸 수 이동
					fish.r = R - 1 - rmd;
					fish.d = 0;
				}
			}
		} else if (fish.d == 1) { // 하
			if (fish.r + fish.s < R) { // 방향 전환 없이 이동이 가능할 경우
				fish.r += fish.s;
				if (fish.r == R - 1) fish.d = 0; // 위로 방향 전환
			} else {
				// r을 R - 1로 이동 후 방향 전환 함
				left -= (R - 1 - fish.r);
				fish.r = R - 1;
				fish.d = 0;
				q = left / (R - 1);
				rmd = left % (R - 1);
				if (q % 2 == 0) fish.r -= rmd; // 짝수일 경우 방향, 위치 그대로이고 칸 수만 이동
				else { // 홀수일 경우 위치는 반대쪽 끝이고, 방향 전환 후 남은 칸 수 이동
					fish.r = rmd;
					fish.d = 1;
				}
			}
		} else if (fish.d == 2) { // 우
			if (fish.c + fish.s < C) { // 방향 전환 없이 이동이 가능할 경우
				fish.c += fish.s;
				if (fish.c == C - 1) fish.d = 3; // 좌로 방향 전환
			} else {
				// c을 C - 1로 이동 후 방향 전환 함
				left -= (C - 1 - fish.c);
				fish.c = C - 1;
				fish.d = 3;
				q = left / (C - 1);
				rmd = left % (C - 1);
				if (q % 2 == 0) fish.c -= rmd; // 짝수일 경우 방향, 위치 그대로이고 칸 수만 이동
				else { // 홀수일 경우 위치는 반대쪽 끝이고, 방향 전환 후 남은 칸 수 이동
					fish.c = rmd;
					fish.d = 2;
				}
			}
		} else { // 좌
			if (fish.c - fish.s >= 0) { // 방향 전환 없이 이동이 가능할 경우
				fish.c -= fish.s;
				if (fish.c == 0) fish.d = 2; // 우로 방향 전환
			} else {
				// c을 0으로 이동 후 방향 전환 함
				left -= fish.c;
				fish.c = 0;
				fish.d = 2;
				q = left / (C - 1);
				rmd = left % (C - 1);
				if (q % 2 == 0) fish.c += rmd; // 짝수일 경우 방향, 위치 그대로이고 칸 수만 이동
				else { // 홀수일 경우 위치는 반대쪽 끝이고, 방향 전환 후 남은 칸 수 이동
					fish.c = (C - 1 - rmd);
					fish.d = 3;
				}
			}
		}
		return fish; // 변경된 물고기 반환
	}
	
	/*
	 * 물고기를 잡는 함수
	 * */
	static int catchFish(int c) {
		int fishNo = 0;
		for (int r = 0; r < R; r++) {
			if (graph[r][c] != 0) {
				fishNo = graph[r][c];
				graph[r][c] = 0;
				break;
			}
		}
		if (fishNo == 0) return 0;
		
		fishes[fishNo].alive = false;
		return fishes[fishNo].z;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[R][C];
		fishes = new Fish[M + 1];
		aliveFishes = new LinkedList<>();
		
		int r, c, s, d, z;
		for (int i = 1; i < M + 1; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			fishes[i] = new Fish(i, r - 1, c - 1, s, d - 1, z);
			fishes[i].alive = true;
			graph[r - 1][c - 1] = i;
			aliveFishes.add(fishes[i]);
		}
		
		int ans = 0;
		for (int i = 0; i < C; i++) {
			ans += catchFish(i);
			moveFish();
		}
		
		System.out.println(ans);
	}
}


class Fish {
	int no;
	int r;
	int c;
	int s;
	int d;
	int z;
	boolean alive;
	
	Fish() {
		
	}
	
	Fish(int no, int r, int c, int s, int d, int z) {
		this.no = no;
		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
	}
}