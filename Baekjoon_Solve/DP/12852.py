# 1로 만들기2(12852번)
#####################################################################################
    # 문제: https://www.acmicpc.net/problem/12852
    # DP
    # DP와 경로 탐색을 통해서 풀어보았다.
    # 근데 생각보다 비효울적인 것 같아서 다른 사람의 풀이를 보니 그냥 큐를 통해서도 더 빨리 풀 수 있었다.
#####################################################################################
import sys
input = sys.stdin.readline

INF = int(1e9)
dp = [INF] * (int(1e6) + 1)
dp[1] = 0
dp[2], dp[3] = 1, 1

parent = [i for i in range(int(1e6) + 1)] # 경로를 찾기 위한 부모 배열

for i in range(4, int(1e6) + 1):
    div3, div2, sub1 = INF, INF, INF
    if i % 3 == 0:
        div3 = min(div3, dp[i // 3] + 1)
    if i % 2 == 0:
        div2 = min(div2, dp[i // 2] + 1)
    sub1 = min(sub1, dp[i - 1] + 1)
    dp[i] = min(div3, div2, sub1)

    if dp[i] == div3:
        parent[i] = i // 3
    elif dp[i] == div2:
        parent[i] = i // 2
    else:
        parent[i] = i - 1

# 경로를 찾는 함수
def find_path(end):
    while end != 1:
        route.append(parent[end])
        end = parent[end]

N = int(input())
route = [N]

print(dp[N])

parent[2], parent[3] = 1, 1 # 2와 3일 경우 1로 초기화
find_path(N)
print(*route)
