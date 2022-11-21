# 악덕 사장 (14233번)
###################################################################################
    # 문제: https://www.acmicpc.net/problem/14233
    # 이분탐색, 매개변수 탐색
    # 문제에서 주어진 내용이 문제를 풀기에 모든 조건이 주어진 것이 아니라고 생각한다. 보완이 필요하다고 생각한다.
    # i + 1 * mid가 A[i]보다 작거나 같을 경우에 해당 일을 완료할 수 있다.(구글링을 통해서 알아내었다...)
###################################################################################
import sys
input = sys.stdin.readline

n = int(input().rstrip())
A = list(map(int, input().split()))

s = 1
e = int(1e9)
k = 0
A.sort()
while s <= e:
    mid = (s + e) // 2
    flag = True
    for i in range(n):
        if mid * (i + 1) > A[i]:
            flag = False

    if flag:
        s = mid + 1
        k = mid
    else:
        e = mid - 1

print(k)
