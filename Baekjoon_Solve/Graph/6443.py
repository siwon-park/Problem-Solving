# 애너그램(6443번)
####################################################################
    # 문제: https://www.acmicpc.net/problem/6443
    # 백트랙킹, 조합
    # 중복제거 및 메모리 제한이 128MB라 뭔가 있을 줄 알았는데, 생각보다 크게 고려할 것은 없었다.
    # 순열을 구성하되, 중복없이 구성하면 되는 문제이다.
    # 알파벳이 나온 횟수 count배열을 만들어서 백트랙킹으로 순열을 만드는데 활용하였다.
    # 시간이 852ms로 크게 빠른 편이 아니었는데, 아마 count배열의 길이인 26번씩 매번 확인해야해서 그럴 것이라고 생각한다.
    # 지금 이 풀이를 쓰면서 생각했는데, 딕셔너리를 썼으면 아마 더 빨랐을 것 같다.
####################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

def dfs(k, s):
    if k == N:
        print("".join(s))
        return
    for i in range(26):
        if count[i]:
            count[i] -= 1
            s.append(chr(i+97))
            dfs(k+1, s)
            s.pop()
            count[i] += 1
            
T = int(input())
for _ in range(T):
    count = [0] * 26
    a = input().rstrip()
    N = len(a)
    for i in range(N):
        count[ord(a[i]) - 97] += 1
    dfs(0, [])
