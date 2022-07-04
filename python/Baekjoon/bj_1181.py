from sys import stdin

arr = list(set([stdin.readline() for _ in range(int(stdin.readline()))]))
arr = sorted(arr)
arr = sorted(arr, key=len)

print(''.join(arr))