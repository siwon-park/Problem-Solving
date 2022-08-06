# 기상청 인턴 신현수(2435번)
##################################################################################################
    # 문제: https://www.acmicpc.net/problem/2435
    # 브루트포스, 누적합
    # 이 문제는 2 중 for문으로 풀면 시간초과가 난다. 왜냐하면 k의 범위가 1 <= K <= N이기 때문에 최악의 경우 O(N^2)의 시간이 걸린다.
    # 따라서 누적합을 이용해 이전까지의 합을 구해놓고 누적합[i] - 누적합[i-k] 중 가장 큰 값을 찾아서 출력하면 된다. 
##################################################################################################
import sys
input = sys.stdin.readline

N, K = map(int, input().split())
arr = list(map(int, input().split()))
pre_sum = [0]
for i in range(len(arr)):
    pre_sum.append(pre_sum[i] + arr[i])

max_sum = -sys.maxsize
for i in range(K, len(pre_sum)):
    tmp_sum = pre_sum[i] - pre_sum[i - K]
    max_sum = max(max_sum, tmp_sum)
print(max_sum)
