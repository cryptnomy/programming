import sys
read = sys.stdin.readline

seq1, seq2 = read().strip(), read().strip()
row, col = len(seq1), len(seq2)
cache = [[0] * (col + 1) for _ in range(row + 1)]

for i  in range(1, row + 1):
    for j in range(1, col + 1):
        if seq1[i-1] == seq2[j-1]:
            cache[i][j] = cache[i-1][j-1] + 1
        else:
            cache[i][j] = max(cache[i][j-1], cache[i-1][j])

print(cache[-1][-1])