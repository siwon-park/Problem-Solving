T = int(input().rstrip())
for i in range(T):
    N, M = map(int, input().rstrip().split())
    cut = 2 * M - N
    print(cut, M - cut)