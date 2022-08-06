# 용감한 용사 진수(14718번)
########################################################################################
    # 문제: https://www.acmicpc.net/problem/14718
    # 브루트포스
    # Python3로는 1% 시간초과, Pypy3로는 640ms 통과
    # O(N^4)의 시간복잡도를 가진 코드로 풀었다.
    # k번 이겨야하므로, 애초에 정렬을 하여 k번째 힘부터 탐색하게하여 완전탐색으로 해결하였다.
    # 효율성에 대해 고민을 해보았는데, 될지 안 될지 모르겠다.
    # 방법은 이렇다.
    # 애초 내 풀이가 k번째 힘에 대해서부터 출발했으니, lst배열을 총 3개 만들어서 하나는 힘에 대해 정렬하고, 하나는 민첩, 하나는 지력에 대해 정렬한다.
    # 또한 각 능력치에 대해 k번째 탐색 출발 시점을 각 각 k1, k2, k3라 설정하고
    # 그 다음 k1번째 힘에 대해서 출발해서 k2번째 민첩을 골랐을 때, k2번째의 민첩에 해당하는 힘의 값이 k1번째 힘보다 크면 그 힘의 값과, k1번째 힘의 값의 차이
    # k2+1번째 민첩의 값과 k2번째 민첩의 값의 차이를 비교해서 힘과 민첩의 합 그리고 차이의 값에 따라 적절한 선택을 하는 방법이다.(지력에 대해서도 동일하게 진행한다.)
    # 그런데 쓰면서 생각해보니, 그리디적인 선택이라서 최적해를 찾지 못할 것 같다는 생각이 든다. 또 지력을 비교할 때, 힘도 계속 비교해야한다.
    # 차라리 시간복잡도를 포기하고 코드의 간결성을 확보한게 더 나은 것 같다.
    # 다른 사람의 풀이를 참고해보니 Python3로 통과한 O(N^3)에 해결한 코드를 찾을 수 있었다. 왜 나는 저렇게 생각못하고 일일히 다 탐색할 생각을 했는지 모르겠다.
    # 어차피 힘과 민첩까지 고르고나면 나머지는 원본 배열에서 선택해도 되는 부분이었다. 잘 풀었다고 생각해서 코드를 아래에 붙여 놓았다.
########################################################################################
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

##################################### 다른 사람의 O(N^3) 풀이 ###########################################3
import sys
input = sys.stdin.readline
n,k = map(int,input().split())
stats = []

for _ in range(n):
    stats.append([int(i) for i in input().split()])

res = float('inf')
for s in range(n):
    str_ = stats[s][0]
    for d in range(n):
        dex_ = stats[d][1]
        int_ = []
        for s,d,i in stats:
            if str_ >= s and dex_ >= d: #현재 선택한 str과 dex의 크기가 크다면
                int_.append(i) #조건에 만족하는 int값을 추가해준다.
        
        if len(int_) >= k:
            int_.sort()
            sum_of_stat = str_ + dex_ + int_[k-1]
            res = min(res,sum_of_stat)

print(res)
