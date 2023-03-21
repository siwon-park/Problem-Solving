import sys
input = sys.stdin.readline

N, M = map(int, input().split()) # 연병장의 크기, 조교의 수
H = list(map(int, input().split())) # 각 칸의 높이
p_sum = [0] * (N + 1)

for _ in range(M):
    a, b, k = map(int, input().split()) # a번 칸 부터 b번 칸까지 |k|만큼 높이 변경
    p_sum[a] += k # a 지점의 높이를 변경
    if b + 1 <= N: # b + 1 <= N이면 b + 1 지점의 높이를 반대로 변경
        p_sum[b + 1] += -k

# 누적합을 계산하면서 H의 높이를 변경
for i in range(1, N + 1):
    p_sum[i] += p_sum[i - 1]
    H[i - 1] += p_sum[i]

print(*H)