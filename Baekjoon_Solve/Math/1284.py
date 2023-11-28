# 집 주소 (1284번)
import sys
input = sys.stdin.readline

while True:
    num = input().rstrip()
    if num == "0":
        break
    n = len(num)
    ans = n + 1  # 숫자 사이의 1센티씩 간격(양 옆 포함)
    for i in range(n):
        if num[i] == "1":
            ans += 2
        elif num[i] == "0":
            ans += 4
        else:
            ans += 3
    print(ans)
