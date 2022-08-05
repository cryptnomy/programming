# while True:
#     n = input()
#     if n == '0':
#         break
#     if n == n[::-1]:
#         print('yes')
#     else:
#         print('no')

# while True:
#     n = int(input())
#     if (n == 0):
#         break
#     x, y = n, 0
#     while x >= y:
#         y = 10 * y + x % 10
#         x //= x
#     if x == y or x // 10 == y:
#         print('yes')
#     else:
#         print('no')

while True:
    x = int(input())
    if (x == 0):
        break
    if x < 0 or (x % 10 == 0 and x != 0):
        print('no')
        continue
    y = 0
    while x > y:
        y = 10 * y + x % 10
        x //= 10
    print('yes' if (x == y or x == y//10) else 'no')