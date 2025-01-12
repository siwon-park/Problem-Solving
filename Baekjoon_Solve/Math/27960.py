# 사격 내기 (27960번)
import sys
input = sys.stdin.readline

sa, sb = map(int, input().rstrip().split())
# 둘 중 한 명만 맞힌 표적은 다 맞혔는데, 둘 다 못 맞히거나 둘 다 맞힌 건 안 맞힘 => 비트 XOR 연산
print(sa ^ sb)

