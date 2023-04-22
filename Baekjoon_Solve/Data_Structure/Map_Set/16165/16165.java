package BOJ;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        HashMap<String, TreeSet<String>> girlGroupMap = new HashMap<>(); // 걸그룹: 멤버 집합
        HashMap<String, String> memberMap = new HashMap<>(); // 멤버 이름 : 걸그룹 명
        
        for (int i = 0; i < N; i++) {
        	String girlGroupName = br.readLine(); // 걸그룹 명
        	int cnt = Integer.parseInt(br.readLine()); // 걸그룹의 수
        	girlGroupMap.put(girlGroupName, new TreeSet<>());
        	for (int j = 0; j < cnt; j++) {
        		String memberName = br.readLine(); // 멤버 이름
        		girlGroupMap.get(girlGroupName).add(memberName); // 걸그룹에 멤버 이름 추가
        		memberMap.put(memberName, girlGroupName);
        	}
        }
        
        for (int i = 0; i < M; i++) {
        	String name = br.readLine(); // 걸그룹 명 또는 멤버 이름
        	int x = Integer.parseInt(br.readLine()); // 쿼리의 종류
        	if (x == 0) { // 걸그룹 명이면
        		TreeSet<String> girlGroup = girlGroupMap.get(name);
        		for (String member : girlGroup) bw.write(member + "\n");
        	} else if (x == 1) { // 멤버 명이면
        		bw.write(memberMap.get(name) + "\n");
        	}
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}