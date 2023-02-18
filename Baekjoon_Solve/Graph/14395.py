# 4연산 (14395번)
"""
  문제: https://www.acmicpc.net/problem/14395
  BFS
  1 <= s, t <= 10^9이므로, 방문 체크를 배열로 하면 안 되고, 집합형으로 해야한다.
  만약 자바로 풀었다면 s * s를 했을 때, 10^18이 될 수도 있으므로 long형으로 선언해야 함을 잊지말자.
  s == t이면 0을, s를 t로 바꿀 수 없으면 -1을 출력해야 하는데, 언제 바꿀 수 없을지 잠깐 고민했다.
  하지만 잘 보면, 자기 자신에 대해서 연산을 진행하므로, 나누기(/) 연산은 무조건 1, 빼기(-) 연산은 0이 나오고
  더하기(+), 곱하기(*) 연산은 숫자가 계속해서 커지니까 연산 결과가 무조건 t이하여야 한다.
  가장 빠른 산식을 출력해야하므로 *, +, -, / 순으로 BFS 탐색을 하다가 현재 큐에서 나온 값이 t이면 return하면 된다.
"""
import sys
from collections import deque
input = sys.stdin.readline


op = ["*", "+", "-", "/"]

def bfs(s):
    q = deque([(s, "")])
    _set = set()
    _set.add(s)
    if s == t:
        return 0
    while q:
        cur, opr = q.popleft()
        if cur == t:
            return opr
        if cur * cur <= t and cur * cur not in _set:
            q.append((cur * cur, opr + "*"))
            _set.add(cur * cur)
        if cur + cur <= t and cur + cur not in _set:
            q.append((cur + cur, opr + "+"))
            _set.add(cur + cur)
        if cur - cur <= t and cur - cur not in _set:
            q.append((cur - cur, opr + "-"))
            _set.add(cur - cur)
        if cur > 0 and cur / cur <= t and cur / cur not in _set:
            q.append((cur / cur, opr + "/"))
            _set.add(cur / cur)
    return -1


s, t = map(int, input().split())
print(bfs(s))
