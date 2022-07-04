'''import sys

remainder = []
def divider(x, y, num):
    if x < num and y < num:
        remainder.append(0)
    else:
        if x < num:
            remainder.append(1)
            y -= num
        elif y < num:
            remainder.append(2)
            x -= num
        else:
            remainder.append(3)
            x -= num
            y -= num
    return x, y

n, row, col = map(int, sys.stdin.readline().split())
for i in reversed(range(n)):
    num = 2**i
    row, col = divider(row, col, num)
res = sum([(2**(2*(n-i-1)))*remainder[i] for i in range(n)])
print(res)'''

import sys
n, r, c = map(int, sys.stdin.readline().split())
print(2*int(f'{r:b}', 4) + int(f'{c:b}', 4))

'''
col 0의 index를 각각 2진수로 바꾼 표현식을 4진수로 표현한 후 2를 곱하면 col 0의 tile number가 바로 나옴.
row 0의 index를 각각 2진수로 바꾼 표현식을 4진수로 표현하면 row 0의 tile number가 바로 나옴.
'''