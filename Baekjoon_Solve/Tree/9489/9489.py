import sys
sys.setrecursionlimit(int(1e7))
input = sys.stdin.readline


def dfs(cur: int, lv: int) -> None:
    level[cur] = lv # 현재 노드의 레벨을 기록
    for nxt in graph[cur]: # 단방향이기 때문에 중복 방문 X
        dfs(nxt, lv + 1)


while True:
    n, k = map(int, input().rstrip().split())
    if n == 0 and k == 0: # n, k가 둘 다 0이면 break
        break

    lst = list(map(int, input().rstrip().split()))
    num_dict = dict()
    for i, num in enumerate(lst):
        num_dict[num] = i + 1
    graph = [[] for _ in range(n + 1)]
    p_idx = -1 # 부모의 인덱스 (초기: -1)
    p = num_dict[lst[0]]
    last = lst[0]
    parent = [0] * (n + 1)
    for i in range(n):
        cur = lst[i]
        if last + 1 == cur: # 연속된 수이면 현재의 부모의 자식으로 삽입
            graph[p].append(num_dict[cur])
            parent[num_dict[cur]] = p # 자식의 부모를 기록
        elif last + 1 < cur: # 연속된 수가 아니면
            p_idx += 1 # 부모 인덱스를 증가시키고 부모를 변경한 뒤
            p = num_dict[lst[p_idx]]
            graph[p].append(num_dict[cur]) # 현재 부모의 자식으로 삽입
            parent[num_dict[cur]] = p # 자식의 부모를 기록
        last = cur

    level = [0] * (n + 1)
    dfs(num_dict[lst[0]], 1)

    # 사촌의 수는 레벨이 같으면서 부모의 부모가 같은 노드의 수
    k = num_dict[k] # k를 인덱스로 변환
    k_lv = level[k] # k의 레벨
    cnt = 0
    for i in range(1, n + 1):
        if parent[i] == parent[k]: # 부모가 같으면 형제이므로 continue
            continue
        if level[i] == k_lv and parent[parent[i]] == parent[parent[k]]:
            cnt += 1
    print(cnt)