# 동방 프로젝트 (Large) (14595번) - 그리디 풀이
import sys
p = lambda: sys.stdin.readline().rstrip()
n, m = int(p()), int(p())

li = [list(map(int, p().split())) for _ in range(m)]
li.sort()

ct = r = 1
for f, t in li:
    if f <= ct:
        ct = max(ct, t)
    else:
        r += f - ct
        ct = t
r += n - ct
print(r)
