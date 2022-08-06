# 전공책(16508번)
####################################################################################################
    # 문제: https://www.acmicpc.net/problem/16508
    # 브루트포스, 백트랙킹
    # 조합 백트랙킹과 단어의 등장 빈도를 담은 count 배열을 활용해서 문제를 풀었다.
    # 처음에 이 문제를 접하고, 그리디가 아닌가 싶었는데 브루트포스였고, 그리디는 매번 한 선택에 대해 최적의 선택을 한다고 가정하지만
    # 해당 해가 최적해가 아닐 수도 있기 때문에 결국엔 그리디가 아니다라는 것은 캐치했다.
    # 물론 단어를 만들 수 있냐를 확인하는 것은 길이가 26인 count배열 활용을 기본 베이스로 깔고 있었다.
    # 문제는 어떻게 모든 경우를 탐색하느냐 였는데, 내가 떠올린 방법은 결국 백트랙킹 조합이었다.
    # 자세한 풀이는 주석을 참조
####################################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

T = input().rstrip()
count = [0] * 26 # 목표 조합 단어의 등장 빈도수를 담는 배열
for t in T:
    count[ord(t) - 65] += 1

N = int(input())
lst = []
for _ in range(N):
    tmp_count = [0] * 26 # W에 있는 각 문자의 등장 빈도수를 담는 배열
    C, W = input().split()
    for w in W:
        tmp_count[ord(w) - 65] += 1
    lst.append((int(C), tmp_count)) # lst에 가격과 W의 문자 등장 빈도수 배열을 담는다

INF = sys.maxsize
min_cost = INF

def combine(s, cost, cnt_arr): # 조합 백트랙킹
    global min_cost
    flag = True # 등장한 모든 각 문자에 대해 목표 단어의 등장 빈도 수 >= 현재 등장 빈도 수일 경우에만 True(기본값은 True로 설정)
    if cost > min_cost:
        return
    for k in range(26): # 모든 알파벳 대문자에 대해 체크
        if cnt_arr[k] < count[k]:
            flag = False # 현재 등장 빈도 수가 목표 단어의 등장 빈도 수 보다 작으면 Flase로 토글링한 뒤에 탐색 종료(break)
            break
    if flag: # 모든 각 문자의 등장 빈도가 목표 단어의 각 문자 등장 빈도보다 많거나 같을 경우
        min_cost = min(min_cost, cost) # 최솟값을 갱신
    if s == N:
        return
    for i in range(s, N):
        for j in range(26): # 현재 빈도 배열에 이번에 뽑은 빈도를 더 함
            cnt_arr[j] += lst[i][1][j]
        combine(i + 1, cost + lst[i][0], cnt_arr) # 백트랙킹
        for j in range(26): # 이번에 뽑은 빈도를 빼줌(백트랙킹 처리)
            cnt_arr[j] -= lst[i][1][j]

combine(0, 0, [0]*26)

if min_cost == INF:
    print(-1)
else:
    print(min_cost)
