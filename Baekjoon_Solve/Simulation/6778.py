# Which Alien? (6778번)
import sys
input = sys.stdin.readline

antenna = int(input().rstrip())
eyes = int(input().rstrip())

if antenna >= 3 and eyes <= 4:
    print("TroyMartian")
if antenna <= 6 and eyes >= 2:
    print("VladSaturnian")
if antenna <= 2 and eyes <= 3:
    print("GraemeMercurian")

