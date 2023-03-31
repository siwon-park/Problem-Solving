import java.util.*;
import java.io.*;

public class Main {

    static class Place implements Comparable<Place>{
        int r; // 행
        int c; // 열
        int empty; // 비어있음
        int likes; // 좋아하는 학생 수

        Place(int r, int c) {
        	this.r = r;
        	this.c = c;
        	this.empty = 0;
        	this.likes = 0;
        }
        
        @Override
        public int compareTo(Place o) {
        	if (this.likes < o.likes) return 1;
        	else if (this.likes > o.likes) return -1;
            else {
                if (this.empty < o.empty) return 1;
                else if (this.empty > o.empty) return -1;
                else {
                    if (this.r > o.r) return 1;
                    else if (this.r < o.r) return -1;
                    else return Integer.compare(this.c, o.c);
                }
            }
        }
    }

    static ArrayList<Place> findCandidates(int cur) {
        ArrayList<Place> candidates = new ArrayList<>();
        HashSet<Integer> likeSet = hashMap.get(cur); // 현재 학생이 좋아하는 학생 집합
        int ni, nj;
        
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++) {
        		if (graph[i][j] == 0) { // 빈 칸이면 정보를 확인하여 리스트에 삽입함
        			Place newPlace = new Place(i, j);
        			for (int k = 0; k < 4; k++) {
        				ni = i + dy[k];
        				nj = j + dx[k];
        				if (ni < 0 || ni >= N || nj < 0 || nj >= N) continue;
        				if (graph[ni][nj] == 0) newPlace.empty += 1; // 주변이 빈 칸이면 빈 칸의 수 증가
        				else if (likeSet.contains(graph[ni][nj])) newPlace.likes += 1; // 주변이 좋아하는 학생이면 좋아하는 수 증가 
        			}
        			candidates.add(newPlace); // 후보지 삽입
        		}
        	}
        }
        
        Collections.sort(candidates, Place::compareTo); // 후보지를 정렬함
        return candidates;
    }

    static int N; // 격자판의 크기
    static int[][] graph;
    static int[] like;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static HashMap<Integer, HashSet<Integer>> hashMap; // 학생 번호 : 좋아하는 학생 집합
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        like = new int[N * N];
        hashMap = new HashMap<>();
        
        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            HashSet<Integer> hashSet = new HashSet<>();
            like[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) hashSet.add(Integer.parseInt(st.nextToken())); 
            hashMap.put(like[i], hashSet);
        }

        for (int i = 0; i < N * N; i++) {
        	int cur = like[i]; // 현재 학생 번호
        	ArrayList<Place> candidates = findCandidates(cur);
        	Place bestPlace = candidates.get(0); // 가장 위에 있는 장소가 최적의 장소
        	graph[bestPlace.r][bestPlace.c] = cur;
        }
        
        // 만족도의 합 계산
        int sat = 0;
        int ni, nj;
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++) {
        		int cnt = 0; // 주변에 존재하는 좋아하는 학생 수
        		HashSet<Integer> likeSet = hashMap.get(graph[i][j]); // 현재 학생이 좋아하는 학생 집합
    			for (int k = 0; k < 4; k++) {
    				ni = i + dy[k];
    				nj = j + dx[k];
    				if (ni < 0 || ni >= N || nj < 0 || nj >= N) continue;
    				if (likeSet.contains(graph[ni][nj])) cnt += 1; // 주변이 좋아하는 학생이면 좋아하는 수 증가
    			}
    			switch (cnt) {
    				case 1: sat += 1; break;
    				case 2: sat += 10; break;
    				case 3: sat += 100; break;
    				case 4: sat += 1000; break;
    			}
        	}
        }
        
        System.out.println(sat);
    }
}