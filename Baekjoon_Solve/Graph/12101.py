#1,2,3 더하기 2(12101번)
#################################################
    # 문제: https://www.acmicpc.net/problem/12101
    # DFS(깊이 우선 탐색)
    # "1+1+...+n" 이런식으로 표현해서 k번째에 오는 수식을 구해야함
    # N에서 i값을 빼면서 0보다 작거나 같을 때 return하는데, 만약 0이 됐으면 result에 append함. 단, 마지막에 붙는 +를 없애야 하므로 [:-1]까지만 넣는다
#################################################
import sys
input=sys.stdin.readline
N,K=map(int,input().split())
result=[]
def dfs(cur,strings):
    if cur<=0:
        if cur==0:
            result.append("".join(strings)[:-1])
        return
    for i in range(1,4):
        strings.append(str(i))
        strings.append("+")
        dfs(cur-i,strings)
        strings.pop()
        strings.pop()    
dfs(N,[])
if len(result)>=K:
    print(result[K-1])
else:
    print(-1)
