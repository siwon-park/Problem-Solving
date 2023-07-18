# 도비의 영어 공부 (2386번)
import sys
input = sys.stdin.readline

while True:
    line = input().rstrip()
    if line[0] == '#':
        break
    s = line[0]
    words = line[1:]
    cnt = 0
    for w in words:
        if ord(w) == ord(s) or ord(w) + 32 == ord(s):
            cnt += 1
    print(s, cnt)
