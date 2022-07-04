import sys
read = sys.stdin.readline

n = int(read())
lst_in = list(map(int, read().split()))
dp = [0 for _ in range(n)]

for i in range(n):
    for j in range(i):
        if lst_in[j] < lst_in[i] and dp[i] < dp[j]:
            dp[i] = dp[j]
    dp[i] += 1
print(dp)
print(max(dp))

'''
import sys
read = sys.stdin.readline

n = int(read())
li = list(map(int, read().split()))
dp = [li[0]]

for i in range(1, n):
    if li[i] > dp[-1]:
        dp.append(li[i])
        print('dp.append', dp)
    else:
        j = len(dp) - 1
        while j > 0:
            if dp[j-1] < li[i]:
                break
            j -= 1
        dp[j] = li[i]
        print('dp[j] = li[i]', dp)
print(len(dp))


input
8
10 20 10 50 30 5 40 60
을 넣으니 dp로 5 20 30 40 60을 제시함. 풀이 틀린 코드.
'''