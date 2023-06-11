# 선분 교차 2 (17387번)
import sys
input = sys.stdin.readline


def ccw(x1: int, y1: int, x2: int, y2: int, x3: int, y3: int) -> int:
    return (x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)


def is_intersect(x1: int, y1: int, x2: int, y2: int, x3: int, y3: int, x4: int, y4: int) -> bool:
    ab = ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4)
    cd = ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2)

    if ab == 0 and cd == 0:
        mx1, my1 = min(x1, x2), min(y1, y2)
        mx2, my2 = max(x1, x2), max(y1, y2)

        mx3, my3 = min(x3, x4), min(y3, y4)
        mx4, my4 = max(x3, x4), max(y3, y4)

        if mx4 >= mx1 and my4 >= my1 and mx2 >= mx3 and my2 >= my3:
            return True
        return False
    return ab <= 0 and cd <= 0


x1, y1, x2, y2 = map(int, input().rstrip().split())
x3, y3, x4, y4 = map(int, input().rstrip().split())

flag = is_intersect(x1, y1, x2, y2, x3, y3, x4, y4)
print(1 if flag else 0)