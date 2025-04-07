import sys

input = sys.stdin.readline

# Keys, Phone, Wallet (33643번)
N = int(input().rstrip())
_set = set(input().rstrip() for _ in range(N))
lst = []
if "keys" not in _set:
    lst.append("keys")
if "phone" not in _set:
    lst.append("phone")
if "wallet" not in _set:
    lst.append("wallet")

if not lst:
    print("ready")
else:
    for s in lst:
        print(s)

