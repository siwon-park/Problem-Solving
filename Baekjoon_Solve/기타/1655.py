#가운데를 말해요(1655번)
#############################################
    # 우선순위 큐 이용
    # 중간값을 찾기위해 최소 힙과 최대 힙을 사용해야하는 것까진 눈치 챘으나, 세부 구현에서 답을 못찾아 타인의 풀이를 참고함
    # 두 힙의 길이가 같을 때는 최대 힙에 숫자를 밀어 넣고, 아닐 땐 최소 힙에 숫자를 밀어 넣는다
    # 최소 힙에서 뽑은 숫자가 최대 힙에서 뽑은 숫자보다 작으면 해당 숫자들을 최소 힙과 최대 힙에 숫자를 서로 스왑해서 넣는다.
    # 아닐 경우, 원래 뽑았던 힙에 그대로 밀어 넣는다.
    # 매번 최대 힙에 맨 앞에 있는 숫자가 중간 값이다.
#############################################
import sys
import heapq
input=sys.stdin.readline
N=int(input())
max_q,min_q=[],[]
lmx,lmn=0,0
for _ in range(N):
    num=int(input())
    if lmx==lmn:
        heapq.heappush(max_q,-num)
        lmx+=1
    else:
        heapq.heappush(min_q,num)
        lmn+=1
    if min_q:
        max_num=-heapq.heappop(max_q)
        min_num=heapq.heappop(min_q)
        if min_num<max_num:
            heapq.heappush(min_q,max_num)
            heapq.heappush(max_q,-min_num)
        else:
            heapq.heappush(min_q,min_num)
            heapq.heappush(max_q,-max_num)
    print(-max_q[0])
