# 회문 (17609번)
import sys
sys.setrecursionlimit(int(1e6))
input = sys.stdin.readline


def recur(line: str, s: int, e: int, flag: bool) -> int:
    while s < e:
        if line[s] == line[e]:
            s += 1
            e -= 1
        else:
            if flag:
                # 시작점을 옮김
                if recur(line, s + 1, e, False) == 0:
                    return 1
                # 끝점을 옮김
                elif recur(line, s, e - 1, False) == 0:
                    return 1
            return 2
    return 0 # 회문


T = int(input().rstrip())
for t in range(T):
    ln = input().rstrip()
    print(recur(ln, 0, len(ln) - 1, True))