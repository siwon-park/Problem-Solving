# 풍선 맞추기(11509번)
#####################################################################################
    # 문제: https://www.acmicpc.net/problem/11509
    # 그리디
    # 자세한 문제 풀이는 아래 주석을 참조
    # 화살은 항상 왼쪽에서 쏠 수 있다는 것을 활용하면 된다.
    # 처음에는 O(N^2)의 풀이법만 생각났고 N <= 10^6이기 때문에 그대로 풀었다면 분명 시간초과가 발생했을 것이다.
#####################################################################################
import sys
input = sys.stdin.readline

N = int(input())
balloons = list(map(int, input().split()))
visited = [0] * (int(1e6) + 1) # 날아가고 있는 화살을 체크하기 위한 배열

cnt = 0 # 총 화살의 개수
for i in range(N):
    cur = balloons[i]
    if not visited[cur]: # cur 높이에 해당하는 화살이 없으면 화살의 개수를 추가해준다
        cnt += 1
        visited[cur - 1] += 1 # cur 높이의 풍선을 맞혔으니 cur - 1의 화살을 +=1 해준다
    else: # cur 높이에 해당하는 화살이 있으면 하나 제거하고 cur - 1의 화살을 +=1 해준다
        visited[cur] -= 1 
        visited[cur - 1] += 1

print(cnt)
