# 히오스 프로게이머(16564번)
#####################################################################################
    # 문제: https://www.acmicpc.net/problem/16564
    # 이분탐색, 파라메트릭 서치(매개변수 탐색)
    # 어렵지 않은 난이도의 이분탐색, 매개변수 탐색 문제이다.
    # 가능한 목표레벨 T를 이분탐색을 통해 찾을 target으로 하여 탐색을 진행하면 된다.
    # 자세한 풀이는 코드 참조
#####################################################################################
import sys
input = sys.stdin.readline

N, K = map(int, input().split())
lvl = [int(input().rstrip()) for _ in range(N)]
lvl.sort() # 이분탐색을 위한 정렬
s, e = lvl[0], lvl[-1] # 최저레벨, 최대레벨

def binary_search(s, e):
    opt = 0
    while s <= e:
        k = 0
        mid = (s + e) // 2
        for lv in lvl:
            if lv < mid: # 레벨이 mid보다 작으면
                k += mid - lv # 작은 만큼 올린다
        if k <= K: # 총 K이하만큼 레벨을 올렸다면
            opt = mid # 현재의 레벨을 최적의 최소 레벨로 저장하고
            s = mid + 1 # 목표 레벨을 올려서 탐색해본다
        else: # 총 K를 초과해서 레벨을 올렸다면
            e = mid - 1 # 목표 레벨을 낮춰서 탐색해본다
    return opt

print(binary_search(s, e))
