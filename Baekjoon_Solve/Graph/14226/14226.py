import sys
from collections import deque
input = sys.stdin.readline

S = int(input().rstrip())
visited = [[0 for _ in range(1001)] for _ in range(1001)]


def find_min_time():
    q = deque([(1, 0, 0)]) # 현재 이모티콘의 개수, 클립보드에 있는 수, 시간
    while q:
        cur, clip, t = q.popleft()
        if cur == S:
            return t
        # 모두 복사하여 클립보드에 저장
        if visited[cur][cur] == 0:
            visited[cur][cur] = t + 1
            q.append((cur, cur, t + 1))
        # 클립보드의 내용 화면에 붙여넣기(클립보드 크기 1이상)
        if clip > 0 and cur + clip <= 1000 and visited[cur + clip][clip] == 0:
            visited[cur + clip][clip] = t + 1
            q.append((cur + clip, clip, t + 1))
        # 화면상의 이모티콘 삭제
        if 0 <= cur - 1 <= 1000 == visited[cur - 1][clip]:
            visited[cur - 1][clip] = t + 1
            q.append((cur - 1, clip, t + 1))


print(find_min_time())