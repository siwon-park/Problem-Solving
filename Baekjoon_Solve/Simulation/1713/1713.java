import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {

    static int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 사진 틀의 개수
        int K = Integer.parseInt(br.readLine()); // 추천의 개수

        int[] day = new int[K + 1]; // 후보자들의 사진첩에 있던 일 수
        for (int i = 0; i < K + 1; i++) {
            day[i] = MAX;
        }
        int[] counts = new int[K + 1]; // 후보자들의 추천 횟수
        int cur = 0; // 현재 수
        int d = 1; // 현재 일 자
        HashSet<Integer> hashSet = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int r = Integer.parseInt(st.nextToken());
            counts[r] += 1; // 후보자의 추천횟수를 증가
            if (cur < N && !hashSet.contains(r)) { // 사진첩에 올라갈 수 있으면 올라간다
                hashSet.add(r);
                day[r] = d;
                cur += 1;
            } else if (cur == N && !hashSet.contains(r)) { // 비어있는 사진이 없으면 삭제한 뒤에 올라간다
                int del = 0;
                int min_r = MAX;
                int min_d = MAX;
                for (Integer c : hashSet) {
                    if (counts[c] < min_r) { // 가장 작은 추천 횟수의 후보자를 찾음
                        min_r = counts[c];
                        min_d = day[c];
                        del = c;
                    } else if (counts[c] == min_r) { // 가장 작은 추천 횟수의 후보자가 여러 명이면
                        if (day[c] < min_d) { // 가장 오래된 후보자를 찾음
                            del = c;
                            min_d = day[c];
                        }
                    }
                }
                // 사진이 삭제되는 경우 추천횟수 0으로 초기화 & 일자도 초기화
                hashSet.remove(del); // 삭제 대상을 삭제
                counts[del] = 0;
                day[del] = MAX;

                hashSet.add(r);
                day[r] = d;
            }
            d += 1;
        }

        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.addAll(hashSet);

        Collections.sort(arrayList);
        for (Integer i : arrayList) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }
}