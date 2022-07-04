import sys

li = list(map(int, sys.stdin.readline().split()))
li_ascending = sorted(li)
print([li[i] for i in range(len(li)-1, -1, -1)])

if li == li_ascending:
    print('ascending')
elif li == [li_ascending[i] for i in range(len(li)-1, -1, -1)]:
    print('descending')
else:
    print('mixed')