# FBI (2857번)
import sys
input = sys.stdin.readline

ans = ""
for i in range(1, 6):
    agent = input().rstrip()
    if "FBI" in agent:
        ans += str(i)
        ans += " "

print("HE GOT AWAY!" if ans == "" else ans)

