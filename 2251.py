#백준 물통(2251번)
######################
  #DFS 알고리즘 사용
  #check 집합을 생성해서 방문을 확인 -> 물을 옮겨서 해당 left_A, left_B, left_C의 조합을 이미 만들었다면 return
  #다른 조합의 물을 만드는 경우는 물을 옮기는 방법인 A->B / B->A / C->A / C->B / A->C / B->C 인 경우 6가지
  #그런데, 각 각 옮길 때, 2가지 경우를 고려해줘야함
  #case1) 두 곳의 물을 합쳤을 때, 해당 컵의 용량 보다 큰 경우 -> ex) left_A+left_B > A -> 옮기려는 곳의 용량의 max까지 채우고, 물을 준 쪽은 준만큼 빼고 남으면 됨
  #case2) 두 곳의 물을 합쳤을 때, 해당 컵의 용량 보다 작은 경우 -> 한쪽 컵의 남은 양은 0이 되고 다른 한쪽은 그냥 한쪽에 있었던 양을 더해주기만 하면 됨
######################
import sys
input=sys.stdin.readline
A,B,C=map(int,input().split())
result=[]
check=set()
def dfs(left_A,left_B,left_C):
    if (left_A,left_B) in check:
        return
    check.add((left_A,left_B))
    if left_A==0:
        result.append(left_C)
    #A->B인 경우
    if left_A+left_B>B:
        dfs(left_A+left_B-B,B,left_C)
    else:
        dfs(0,left_A+left_B,left_C)
    #C->B인 경우
    if left_B+left_C>B:
        dfs(left_A,B,left_C+left_B-B)
    else:
        dfs(left_A,left_B+left_C,0)
    #B->A인 경우
    if left_A+left_B>A:
        dfs(A,left_B+left_A-A,left_C)
    else:
        dfs(left_A+left_B,0,left_C)
    #C->A인 경우
    if left_A+left_C>A:
        dfs(A,left_B,left_C+left_A-A)
    else:
        dfs(left_A+left_C,left_B,0)
    #A->C인 경우
    if left_A+left_C>C:
        dfs(left_A+left_C-C,left_B,C)
    else:
        dfs(0,left_B,left_C+left_A)
    #B->C인 경우
    if left_B+left_C>C:
        dfs(left_A,left_B+left_C-C,C)
    else:
        dfs(left_A,0,left_B+left_C)
dfs(0,0,C)
result.sort()
print(*result)
