# 이중 우선순위 큐(7662번)
######################################################################################
    # 문제: https://www.acmicpc.net/problem/7662
    # 우선순위 큐, 딕셔너리(맵)
    # 괜한 오기 때문에 한 3시간은 날렸다
    # 이 문제를 처음 틀렸을 때, 다음에 왠지 딕셔너리를 사용하면 될 것 같다곤 생각했는데, 왜 끝까지 우선순위 큐 2개로만 풀려고했는지 모르겠다
    # k가 100만이라서 충분히 while 구문을 내부에서 돌려도 되었는데, 실수가 아니라 실력인듯하다
######################################################################################
import sys, heapq
input = sys.stdin.readline

# 최소 힙과 최대 힙을 활용
T = int(input()) # 테스트케이스
for tc in range(T):
    n = 0  # 힙의 길이
    N = int(input()) # 입력의 개수
    min_heapq, max_heapq = [], []
    num_dic = dict()
    for _ in range(N):
        cmd = input().split()
        if cmd[0] == "I":
            num = int(cmd[1])
            # I면 최소힙, 최대힙에 삽입
            heapq.heappush(min_heapq, num)
            heapq.heappush(max_heapq, -num)
            n += 1 # 힙의 길이를 1증가
            num_dic[num] = num_dic.get(num, 0) + 1
        elif cmd[0] == "D" and n > 0:
            if cmd[1] == "1": # 최댓값 삭제
                while max_heapq:
                    max_num = -heapq.heappop(max_heapq)
                    if num_dic[max_num] != 0:
                        num_dic[max_num] -= 1
                        break
            elif cmd[1] == "-1": # 최솟값 삭제
                while min_heapq:
                    min_num = heapq.heappop(min_heapq)
                    if num_dic[min_num] != 0:
                        num_dic[min_num] -= 1
                        break
            n -= 1
    # n == 0이면 힙이 비어있으므로 EMPTY 출력
    if not n:
        print("EMPTY")
    else:
        while max_heapq:
            max_num = -heapq.heappop(max_heapq)
            if num_dic[max_num] != 0:
                break
        while min_heapq:
            min_num = heapq.heappop(min_heapq)
            if num_dic[min_num] != 0:
                break
        print(max_num, min_num)
