import sys

input = sys.stdin.readline

# N번째 큰 수 (2693번)
# 메모리 제한이 32MB인데 OOM 안 뜨는 이유가 있나?
N = int(input().rstrip())
for _ in range(N):
    lst = list(map(int, input().rstrip().split()))
    lst.sort(key=lambda x: -x)
    print(lst[2])

