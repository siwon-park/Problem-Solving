import sys

input = sys.stdin.readline

# Cupcake Party (24568번)
R = int(input().rstrip())
S = int(input().rstrip())
print((R * 8 + S * 3) - 28)

