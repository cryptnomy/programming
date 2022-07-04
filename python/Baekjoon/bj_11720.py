import sys
read = sys.stdin.readline

n = int(read())
answer = sum(map(int, list(read().rstrip())))
print(answer)

'''
input()
print(sum(map(lambda x: int(x), input())))
'''