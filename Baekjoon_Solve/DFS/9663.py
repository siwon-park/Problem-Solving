#N-Queen(9663번)
########################################
    # 백트랙킹
    # 13 이상부터 연산에 많은 시간이 소비되므로 최대한 시간을 줄여야한다.
    # 퀸을 놓을 수 있냐 없냐를 따지는 함수에서 x(열)가 지금까지 놓은 퀸의 좌표들의 집합에 있거나, 대각선에 위치하는 좌표가 있으면(abs(qi-y)==abs(qj-x)) False, 아니면 True.
    # 퀸을 놓을 수 있는 유무를 판별하는 함수에서 x(열)만 고려하는 이유는 solve함수의 인자를 row로 둬서 놓을 수 있으면 row+1을 고려하므로 퀸이 놓여진 좌표에 같은 y(행)은 없기 때문임.
    # visited 배열을 만들어서 해당 x(열)에 퀸을 놓았다면, visited[x]=True로 체크하고, visited[x]==True면 continue를 해서 조금이라도 덜 반복하게 했음.
########################################
n=int(input())
answer=0
qlst=set()
def Qpossible(qlst,y,x):
    for qi,qj in qlst:
        if qj==x or abs(qi-y)==abs(qj-x):
            return False
    return True
visited=[False for i in range(n)]
def solve(row,QN):
    global answer,visited
    if row==n:
        if QN==n:
            answer+=1
        return
    for x in range(n):
        if visited[x]:
            continue
        if Qpossible(qlst,row,x):
            qlst.add((row,x))
            visited[x]=True
            solve(row+1,QN+1)
            qlst.remove((row,x))
            visited[x]=False
solve(0,0)
print(answer)
