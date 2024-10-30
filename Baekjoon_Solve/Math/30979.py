# 유치원생 파댕이 돌보기 (30979번)
T = int(input().rstrip())
N = int(input().rstrip())
F = list(map(int, input().rstrip().split()))
if T <= sum(F):
    print("Padaeng_i Happy")
else:
    print("Padaeng_i Cry")