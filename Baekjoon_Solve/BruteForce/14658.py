# 하늘에서 별똥별이 빗발친다 (14658번)
#################################################################################################
    # 문제: https://www.acmicpc.net/problem/14658
    # 브루트포스
    # 이 문제를 어떻게 풀까 많은 고민을 했었다. 그냥 생각 나는대로 구현하면 K * L * K = O(10^9)로 분명히 시간초과가 날 수 밖에 없다.
    # 가만히 생각해보니, x좌표를 기준으로 해당 x좌표의 값 이상, x좌표 + L 이하인 후보 좌표들을 다음 뒤에
    # x좌표 조건을 만족하는 좌표를 대상으로 위에서 했던 것과 유사하게 y좌표를 기준으로 y좌표 이상, y좌표 + L 이하인 후보 좌표들을 구한다.
    # 그렇게 되면 x, y에 대해 L*L 안에 들어가는 좌표군들이 모이므로, K에서 해당 숫자만큼 빼준다.
    # 처음에 이렇게 구현했더니 60%대에서 틀렸습니다를 받았다. N, M을 사용해야만한다고 생각해서 N이나 M을 초과하면 continue하게 했으나
    # 생각해보니 x나 y에 L을 더한 값이 N, M을 초과하더라도 x, y가 N, M보다 작으니 튕겨낼 수 있는 경우가 존재한다.
    # 해당 부분을 주석 처리 해주니 통과할 수 있었다.
#################################################################################################
import sys
input = sys.stdin.readline

N, M, L, K = map(int, input().split())
lst = []
for _ in range(K):
    x, y = map(int, input().split())
    lst.append((x, y))

ans = 0

for cur in lst:
    cur_x, cur_y = cur  # 기준 좌표
    cand = []   # x좌표 조건을 만족하는 좌표를 담을 배열
    max_width = cur_x + L
    # x좌표의 조건을 만족하는 점들을 모두 담음
    # if max_width > N: # if-continue절을 없애니 통과할 수 있었음(아래도 마찬가지)
    #     continue
    for _x, _y in lst:
        if cur_x <= _x <= max_width:
            cand.append((_x, _y))
    # y좌표의 조건을 만족하는 점들을 모두 담음
    for cand_x, cand_y in cand:
        max_height = cand_y + L
        cnt = 0
        # if max_height > M:
        #     continue
        for _x, _y in cand:
            if cand_y <= _y <= max_height:
                cnt += 1
        ans = max(ans, cnt)

print(K - ans)
