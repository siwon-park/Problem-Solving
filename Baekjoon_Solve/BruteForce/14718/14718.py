import sys
input = sys.stdin.readline

N, K = map(int, input().split())
lst = [list(map(int, input().split())) for _ in range(N)]

lst.sort(key=lambda x: (x[0], x[1], x[2]))

# k번 이후의 힘을 선택하고 민첩, 지능을 더해서 이길 수 있는 횟수를 카운트
min_stats = sys.maxsize
for i in range(K-1, N):
    cur_str = lst[i][0]
    for j in range(N):
        cur_dex = lst[j][1]
        for k in range(N):
            cur_int = lst[k][2]
            cnt = 0
            for l in range(N):
                if cur_str >= lst[l][0] and cur_dex >= lst[l][1] and cur_int >= lst[l][2]:
                    cnt += 1
            if cnt >= K:
                min_stats = min(min_stats, cur_str + cur_dex + cur_int)
print(min_stats)