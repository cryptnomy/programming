n = int(input())
p = 2
prime_factor = []

while p <= int(n ** .5):
    while n % p == 0:
        prime_factor.append(p)
        n //= p
    p += 1
if n > 1:
    prime_factor.append(n)
print('\n'.join(map(str, prime_factor)))