import sys

input = sys.stdin.readline

# 당신은 운명을 믿나요? (27930번)
S = input().rstrip()
idx1, idx2 = 0, 0
K = "KOREA"
Y = "YONSEI"
ans1, ans2 = int(1e9), int(1e9)
for i in range(len(S)):
    if idx1 < len(K) and S[i] == K[idx1]:
        idx1 += 1
        ans1 = i
    if idx2 < len(Y) and S[i] == Y[idx2]:
        idx2 += 1
        ans2 = i

if ans1 < ans2:
    print("KOREA")
else:
    print("YONSEI")
