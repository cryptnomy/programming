import sys
n = int(sys.stdin.readline())
for _ in range(n):
    r, word = sys.stdin.readline().strip().split()
    for w in word:
        print(w * int(r), end='')
    print()