from sys import stdin

while True:
    s = stdin.readline().strip()
    if s == '0 0 0':
        break
    a, b, c = sorted(list(map(int, s.split())))
    print('right' if a**2 + b**2 == c**2 else 'wrong')

'''
while True:
    x, y, z = sorted(int(x) for x in input().split())
    if (x, y, z) == (0, 0, 0):
        break
    print("right" if x*x + y*y == z*z else "wrong")

while True:
    a, b, c = sorted(map(int, sys.stdin.readline().strip().split()))
    if a == 0:
        break
    print("wrriognhgt"[a * a + b * b == c * c ::2])
'''