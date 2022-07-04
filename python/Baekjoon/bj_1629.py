def divide(a, b, c):
    if b == 1:
        return a % c
    else:
        tmp = divide(a, b//2, c)
        if b % 2 == 0:
            return (tmp * tmp) % c
        else:
            return (tmp * tmp * a) % c

a, b, c = map(int, input().split())
print(divide(a, b ,c))