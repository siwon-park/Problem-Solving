# 헬멧과 조끼 (15781번)
n, m = map(int, input().rstrip().split())
helmet = list(map(int, input().rstrip().split()))
vest = list(map(int, input().rstrip().split()))

print(max(helmet) + max(vest))
