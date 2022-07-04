from sys import stdin

for _ in range(int(stdin.readline())):
    a, b, c = map(int, stdin.readline().strip().split())
    q = c // a + 1
    r = c % a
    print(str(r) + str(q) if b < 10 else str(r) + '0' + str(q))