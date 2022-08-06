#부등호(2529번)
################################################
    # 백트랙킹 사용
    # 뽑는 숫자의 중복을 피하기 위해 visited배열 사용
    # 입력 받은 부등호의 양 옆에 공백을 추가 시켜주고 인덱스는 0부터 출발해서 2칸씩 옮겨주는 방식을 취함
    # 부등호 배열의 마지막 인덱스는 2*k인데, 2*k에 숫자를 집어 넣고 나면 최종 인덱스는 2*k+2가 되므로 indx==2*k+2일 때, result 배열에 담고 return
    # indx가 2 이상(2번째 숫자를 넣고 난 이후이므로, 사실 이 때부터는 indx는 4임)일 때, indx-4(숫자)와 indx-3(부등호)와 indx-2(숫자) 간의 비교를 실시하여,
    # 수식이 잘못되었으면 return하여 잘못된 값을 걸러준다
    # 최댓값과 최솟값을 출력해야하므로 result[-1]과 result[0]을 출력해야하나 홀수번째 인덱스마다 부등호가 있으므로 문자열 슬라이싱[::2]를 통해 부등호를 건너뛰고 출력한다
################################################
import sys
input=sys.stdin.readline
k=int(input())
arr=[" "]+list(input().rstrip())+[" "]
result=[]
visited=[False]*10
def dfs(arr,indx):
    if indx>2:
        if arr[indx-3]==">":
            if arr[indx-4]<arr[indx-2]:
                return
        elif arr[indx-3]=="<":
            if arr[indx-4]>arr[indx-2]:
                return
    if indx==2*k+2:
        result.append("".join(arr))
        return
    for i in range(10):
        if visited[i]:
            continue
        arr[indx]=str(i)
        indx+=2
        visited[i]=True
        dfs(arr,indx)
        visited[i]=False
        indx-=2
        arr[indx]=" "
dfs(arr,0)
print(result[-1][::2])
print(result[0][::2])
