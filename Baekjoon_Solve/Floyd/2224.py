# 명제 증명(2224번)
#########################################################################################
    # 문제: https://www.acmicpc.net/problem/2224
    # 플로이드 워셜
    # 문제 힌트에서 플로이드 워셜인 것을 확인하고 풀 수 있었다. 내 생각대로 했다면, 문제를 제대로 읽지도 않고 BFS로 접근했을 것이다.
    # 처음에 인덱스 에러가 났었는데, 그 이유는 ord('Z')는 90인데, ord('a')는 97이라 사이에 6개의 다른 문자열이 존재해서 그렇다.
    # 그래서 52에서 58로 graph의 크기를 늘렸다.
    # 두 번째에는 틀렸습니다를 받았는데, 'A => A'와 같은 케이스는 출력하면 안 되는데 출력해서 틀렸던 것이다. i != j라는 조건을 추가해주니 해결할 수 있었다.
#########################################################################################
import sys
input = sys.stdin.readline

n = ord("z") - ord("A") + 1
graph = [[0]*n for _ in range(n)]

N = int(input())
for _ in range(N):
    S = input().split()
    a = ord(S[0]) - 65
    b = ord(S[2]) - 65
    graph[a][b] = 1

for k in range(n):
    for a in range(n):
        for b in range(n):
            if graph[a][k] and graph[k][b]:
                graph[a][b] = 1

lst = []
for i in range(n):
    for j in range(n):
        if graph[i][j] and i != j:
            lst.append(f'{chr(i + 65)} => {chr(j + 65)}')

M = len(lst)
print(M)
for i in range(M):
    print(lst[i])
