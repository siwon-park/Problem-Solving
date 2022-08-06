#단어 수학(1339번)
########################################################
    # 문제: https://www.acmicpc.net/problem/1339
    # 그리디 알고리즘, 정렬
    # 편의를 위해 defaultdict와 deque를 사용함
    # 처음 접근했을 때는, 각 자리별로 알파벳의 등장횟수에 따른 가중치에 따라 번호를 9 ~ 0을 부여하는 방식을 택했는데, ValueError가 떴을 뿐더러, 반례 또한 존재하였음
    # 반례: N=10, ABB, BB, BB, ..., BB (ABB 1번, BB 9번)
    # 단순히 어떤 알파벳의 빈도를 각 자리별로 비교하는 것이 아니라 전체적으로 비교해야 했었음
    # 따라서 해당 알파벳의 위치(n)에 따라 등장횟수를 10**n씩 더해서 딕셔최너리에 추가/변경하는 형식을 택했다. 예를 들어 ABB에서 A는 100번 등장, B는 11번 등장
    # 최종적으로 등장한 횟수를 내림차순 기준으로 하여 정렬하였고 등장한 횟수*(9 ~ 0)을 해준 값들을 더 해주면 정답
########################################################
import sys
from collections import deque,defaultdict
input=sys.stdin.readline
N=int(input())
count_dic=defaultdict(int)
for i in range(N):
    q=deque(list(input().rstrip()))
    n,dec=0,1
    while q:
        alpha=q.pop()
        count_dic[alpha]+=dec
        dec=10**(n+1)
        n+=1
count_lst=sorted(list(count_dic.items()),key=lambda x: -x[1])
answer=0
num=9
for alpha,cnt in count_lst:
    answer+=cnt*num
    num-=1
print(answer)    
