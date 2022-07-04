def tile(n):
    if n < 4:
        return n
    return tile(n - 1) + tile(n - 2)

tile(int(input()))