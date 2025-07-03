import sys

input = sys.stdin.readline

# 31694번
a = list(map(int, input().rstrip().split()))
b = list(map(int, input().rstrip().split()))

arr1, arr2 = [0 for i in range(11)], [0 for i in range(11)]
score_a, score_b = 0, 0
for i in range(18):
    score_a += a[i]
    score_b += b[i]
    arr1[a[i]] += 1
    arr2[b[i]] += 1

if score_a > score_b:
    print("Algosia")
elif score_b > score_a:
    print("Bajtek")
else:
    for i in range(10, -1, -1):
        if arr1[i] > arr2[i]:
            print("Algosia")
            break
        elif arr2[i] > arr1[i]:
            print("Bajtek")
            break
    else:
        print("remis")

