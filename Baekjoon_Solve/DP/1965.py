#상자넣기(1965번)
######################################
    # 문제: https://www.acmicpc.net/problem/1965
    # 다이나믹 프로그래밍
    # 11053번 가장 긴 증가하는 부분 수열과 동일한 문제(https://www.acmicpc.net/problem/11053)
    # 상자의 갯수는 결국 가장 긴 증가하는 부분 수열의 길이와 같음
######################################
import sys
input=sys.stdin.readline
n=int(input())
arr=list(map(int,input().split()))
dp=[0]*(n+1)
dp[1]=1
answer=0
for i in range(2,n+1):
    dp[i]=1 # 일단 제일 처음 길이는 1로 초기화
    for j in range(1,i):
        if arr[i-1]>arr[j-1]: # 만약 i번째 요소가 j번째 요소보다 크면, (※dp의 길이가 arr보다 1 크므로, arr[i-1]은 dp[i]에 대응함)
            dp[i]=max(dp[i],dp[j]+1) # dp의 j번째에 있는 값+1과 dp[i]의 값을 비교하여 큰 값을 dp[i]에 저장
    answer=max(answer,dp[i]) # dp테이블의 맨 끝 요소가 항상 최댓값은 아니므로, 매번 나오는 dp[i]값과 비교하여 가장 큰 값을 answer에 저장함      
print(answer)
