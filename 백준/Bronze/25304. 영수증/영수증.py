import sys

result = 0

a = int(sys.stdin.readline().strip())
b = int(sys.stdin.readline().strip())

for _ in range(b):
    c, d = map(int, sys.stdin.readline().split())
    result += c * d

if a == result:
    print("Yes")
else:
    print("No")