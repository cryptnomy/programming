import sys
read = sys.stdin.readline
write = sys.stdout.write

a, b = map(int, read().split())
res = []
li1 = sorted([read().rstrip() for _ in range(a)])
li2 = sorted([read().rstrip() for _ in range(b)])
intersection = list(set(li1) & set(li2))
write('{0}\n'.format(len(intersection)))
[write('{0}\n'.format(str(name))) for name in sorted(intersection)]
