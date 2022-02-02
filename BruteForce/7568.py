# 덩치(7568번)
#######################################################
    # 문제: https://www.acmicpc.net/problem/7568
    # 브루트포스 알고리즘
    # 11개월 전에는 못 풀었는데, 다시 도전했더니 풀었다. 이 문제가 어려워서 그런 것도 아니고, 내가 실력이 많이 늘어서 그런 건 더 아니다.
    # 다만, 다만 11개월 전과 비교했을 때, 코드의 간결성이 늘었다는 점이다.
    # 심지어 처음에 다시 어떻게 풀지 했을 때, visited 배열로 중복을 피하기위해 방문을 체크할까 고민을 했었는데, 11개월 전의 내가 이미 했다는 점에서 놀라웠다.
    # 그렇지만 굳이 그럴 필요 없었다. 게다가 맨 처음 랭크 테이블을 모두 1로 초기화하고, 시작했다는 점은 동일하다.
    # 풀이 과정은 이렇다. # 모든 사람에 대해 제일 처음 순위는 모두 1이다. 그후 중복없이, 서로 간 비교를 해서 어느 한쪽이 다른 한쪽보다 덩치가 작으면,
    # 해당 인덱스에 있는 랭크 테이블+=1을 해준다. 단, if문을 2번 사용하여, A와 B를 비교했을 때 A가 덩치가 작으면 A의 랭크+=1을, B의 덩치가 작으면 B의 랭크+=1을 해줬다.
    # 11개월 전에 나의 풀이가 잘못된 이유는 간단하다. 로직에서는 크게 틀린 부분이 없었으나 x,y를 입력받았을 때, 정수가 아니라 문자열 그대로 넣었기 때문이다.
    # 문자열을 넣게 되면 print("8">"40") 했을 때, True가 출력된다. 이는 정수값으로 따졌을 때 올바른 비교가 아니다.
#######################################################
import sys
N=int(input())
rank=[1 for i in range(N)]
compare_lst=[]
for i in range(N):
    x,y=map(int,input().split())
    compare_lst.append((x,y))

for i in range(N):
    x1,y1=compare_lst[i]
    for j in range(i+1,N):
        x2,y2=compare_lst[j]
        if x1<x2 and y1<y2:
            rank[i]+=1
        if x1>x2 and y1>y2:
            rank[j]+=1
print(*rank)

############# 11개월 전 코드 ###########################
N=int(input())
lst,result=[],[]
for _ in range(N):
    x,y=input().split(" ") # 틀린 이유) x,y를 문자열로 받았기 때문에, 비교 연산에서 의도했던 대로 작동하지 못함. 
    lst.append((x,y))
    result.append(1)
visited=[[False]*N for i in range(N)]
for i,info1 in enumerate(lst):
    for j,info2 in enumerate(lst):
        if i==j:
            continue
        if visited[i][j]==False:
            visited[i][j]=True
            if info1[0]>info2[0] and info1[1]>info2[1]: # x,y를 문자열로 받았기 때문에, (8,9)와 (10,8)은 서로 비교 불가능인데, 문자열 비교 시 ("8","9") > ("10","8")로 나옴
                result[j]+=1
for n in result:
    print(n, end=" ")
