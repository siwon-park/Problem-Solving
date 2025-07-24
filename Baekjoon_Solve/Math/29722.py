import sys

input = sys.stdin.readline

# 브실혜성 (29722번)
yymmdd = input().rstrip().split("-")
n = int(input().rstrip())
yy = int(yymmdd[0])
mm = int(yymmdd[1])
dd = int(yymmdd[2])

dd += n
mm += (dd - 1) // 30
dd = (dd - 1) % 30 + 1
yy += (mm - 1) // 12
mm = (mm - 1) % 12 + 1

print(str(yy) + "-" + str(mm).zfill(2) + "-" + str(dd).zfill(2))

