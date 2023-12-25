# 바구니 뒤집기 (10811번)
import sys
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
lst = [i for i in range(1, N + 1)]
for _ in range(M):
    s, e = map(lambda x: int(x) - 1, input().rstrip().split())
    # 특정 범위의 배열을 뒤집으려면 리스트 슬라이싱을 먼저한 배열에 [::-1]을 적용시켜줘야 한다.
    lst = lst[:s] + lst[s:e + 1][::-1] + lst[e + 1:]

print(*lst)
