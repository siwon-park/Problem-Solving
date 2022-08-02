# 순회공연(2109번)
######################################################################################
    # 문제: https://www.acmicpc.net/problem/2109
    # 그리디, 우선순위 큐
    # 도저히 안 풀려서 비용을 기준으로 최대힙을 구성한 뒤에, day를 기준으로 하나씩 빼가면서 아직 체크하지 않았으면
    # 체크하고 비용을 더하는 방법으로 풀었다.
    # 역시 예상한대로 비효율적인 풀이었고, 4612ms로 통과할 수 있었다. 아마 n이 더 컸으면 시간초과가 발생했을 것이다.
    # 훨씬 빠른 풀이를 가져와봤는데, 굉장히 효율적이고 직관적으로 잘 풀었다. 최소힙을 사용한 것도 눈에 띄었다. 해설은 주석 참조
    # 이런 문제에 시간을 많이 잡아먹혀서 굉장히 실력적으로 아직 부족하다고 느낀다. 계속 연습해야겠다.
######################################################################################
import sys, heapq
input = sys.stdin.readline

n = int(input())
pq = []
for _ in range(n):
    p, d = map(int, input().split())
    heapq.heappush(pq, (-p, d))

max_earn = 0

if pq:
    earn, day = heapq.heappop(pq)
    max_earn += -earn
    visited = [False] * 10001
    visited[day] = True
    while pq:
        pay, day = heapq.heappop(pq)
        pay = -pay
        for i in range(day, 0, -1):
            if not visited[i]:
                visited[i] = True
                max_earn += pay
                break

print(max_earn)
#########################################################################################
n = int(sys.stdin.readline())
pd_list = []
result = 0
for i in range(n):
    pd_list.append(list(map(int, sys.stdin.readline().split())))

pd_list.sort(key=lambda x : x[1])   # 날짜를 기준으로 오름차순 정렬
p_list = []
for i in pd_list:
    heapq.heappush(p_list, i[0]) # 비용을 최소힙에 삽입한다
    if len(p_list) > i[1]: # 만약 최소힙의 길이가 현재 일수보다 크면 => 이유: 예를 들어 현재 일수가 2일인데, 최소힙에 3개의 요소가 들어있다면 하루에 하나의 강의를 하지 못한다.
        heapq.heappop(p_list) # 가장 작은 비용을 최소힙에서 pop한다
        
print(sum(p_list))
