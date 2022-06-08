# 서버실(17245번)
#######################################################################################
    # 문제: https://www.acmicpc.net/problem/17245
    # 이분탐색, 파라메트릭 서치(매개변수 탐색)
    # 크게 어려운 난이도의 문제는 아니었지만, 실수가 있어서 시간을 조금 잡아먹었다.
    # 시간 복잡도를 줄이려고 배열에서 0을 전부 빼고 s, e = cpu[0], cpu[-1]로 잡고 탐색했는데,
    # N = 2이고, 모든 요소가 2라면 mid = 2이고 s == e이므로 딱 1번 탐색 후 종료하게 된다.
    # 하지만 이 경우 cpu의 절반은 4.0이고, mid = 2일 땐 8, mid = 1일 땐 4여서 1이 정답임에도 불구하고, 탐색을 종료하게 된다.
    # 따라서 이를 해결하기 위해 s = 0부터 출발하게 하였더니 통과할 수 있었다.
#######################################################################################
import sys
from bisect import bisect_right
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

# 적절한 높이를 삽입할 위치를 찾는 함수
def find_CPU_height(arr, h):
    return bisect_right(arr, h)

# 이분 탐색
def binary_search(s, e):
    opt = 0
    half = total_cpu / 2
    while s <= e:
        mid = (s + e) // 2
        m = find_CPU_height(cpu, mid)
        tmp_total = sum(cpu[:m]) + (L - m) * mid
        if tmp_total >= half:
            opt = mid
            e = mid - 1
        else:
            s = mid + 1
    return opt

N = int(input())
cpu = []
total_cpu = 0
for _ in range(N):
    lst = list(map(int, input().split()))
    for i in range(N):
        if lst[i] > 0:
            cpu.append(lst[i])
            total_cpu += lst[i]

s, e = 0, 0
if cpu:
    cpu.sort()
    s, e = 0, cpu[-1]
L = len(cpu)
print(binary_search(s, e))
