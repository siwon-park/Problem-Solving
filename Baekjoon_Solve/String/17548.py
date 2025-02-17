import sys
input = sys.stdin.readline

# Greetings! (17548번)
S = input().rstrip()
n = len(S)
print('h' + S[1:n - 1] * 2 + 'y')

