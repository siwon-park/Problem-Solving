import sys

input = sys.stdin.readline

# The Fastest Sorting Algorithm In The World 23235번)
n = 1
while True:
    inp = input().rstrip()
    if inp[0] == "0":
        break
    else:
        print(f"Case {n}: Sorting... done!")
        n += 1

