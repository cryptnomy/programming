# 4.1 Computing the parity of a word
# Count the number of 1's in x

# Shifting and masking to avoid hard-coding
def count_bits(x):
    num_bits = 0
    while x:
        num_bits += x & 1
        x >>= 1
    return num_bits
# Compute the parity of a very large number of 64-bit words
def parity(x):  # ~ O(n) where n = # of bits of x
    result = 0
    while x:
        # Maintain if the LSB is 0 else reverse
        result ^= x & 1
        x >>= 1
    return result
# The first improvement
# Erasing the lowest set bit in a word in a single operation,
# thereby improving performance in the best- and average-cases.
def parity(x):  # ~ O(k) where k = # of 1's
    result = 0
    while x:
        result ^= 1
        # x & (x-1) equals x with its lowest set bit erased
        x &= x - 1  # Drops the lowest set bit of x
    return result

PRECOMPUTED_PARITY = {}
# Caching & bit mask
def parity(x):  # ~ O(n/L) where L: word width, n: word size
    MASK_SIZE = 16
    BIT_MASK = 0xFFFF
    return (PRECOMPUTED_PARITY[x >> (3 * MASK_SIZE)] ^
            PRECOMPUTED_PARITY[x >> (2 * MASK_SIZE) & BIT_MASK] ^
            PRECOMPUTED_PARITY[x >> MASK_SIZE & BIT_MASK] ^
            PRECOMPUTED_PARITY[x & BIT_MASK])
# XOR has the property of being associative
def parity(x):  # ~ O(log n)
    x ^= x >> 32
    x ^= x >> 16
    x ^= x >> 8
    x ^= x >> 4
    x ^= x >> 2
    x ^= x >> 1
    return x & 0x1

# 4.2 Swap bits
# Implement code that takes as input a 64-bit integer
# and swaps the bits at in dicices i and j.
# Hint: When is the swap necessary?

def swap_bits(x, i, j): # ~ O(1) independent of the word size
    # Extract the i-th and j-th bits, and see if they differ.
    if (x >> i) & 1 != (x >> j) & 1:
        # i-th and j-th bits differ. We will swap them
        # by flipping their values.
        # Select the bits to flip with bit_mask.
        # Since x ^ 1 = 0 when x = 1 and 1 when x = 0,
        # we can perform the flip XOR.
        bit_mask = (1 << i) | (1 << j)
        x ^= bit_mask
    return x

# swap_bits function without if statement
# for comparing the execution time to the above
def swap_bits_noif(x, i, j):
    x ^= (1 << i) | ( 1 << j)
    return x

'''
Execution time for swap bits function
(1) with if statement       about 4e-7 ~ 6e-7
(2) without if statement    about 4e-7

Conclusion: better to use without if statement
'''

# 4.3 Reverse bits
# Write a program that takes a 64-bit unsigned integer and
# returns the 64-bit unsigned integer consisting of the bits
# of the input in reverse order.
# (ex) 10011 -> 11001

PRECOMPUTED_REVERSE = {}
# ~ O(n/L) for n-bit integers and L-bit cache keys
def reverse_bits(x):
    MASK_SIZE = 16
    BIT_MASK = 0xFFFF
    return (PRECOMPUTED_REVERSE[x&BIT_MASK]<<(3*MASK_SIZE) |
            PRECOMPUTED_REVERSE[(x>>MASK_SIZE)&BIT_MASK]<<(2*MASK_SIZE) |
            PRECOMPUTED_REVERSE[(x>>2*MASK_SIZE)&BIT_MASK]<<MASK_SIZE |
            PRECOMPUTED_REVERSE[(x>>3*MASK_SIZE)&BIT_MASK])

# 4.4 Find a closest integer with the same weight
# Write a program which takes as input a nonnegative integer x
# and returns a number y which is not equal to x, but has
# the same weight as x and their difference, |y-x|, is
# as small as possible.
def closest_int_same_bit_count(x):  # ~ O(n)
    NUM_UNSIGNED_BITS = 64
    for i in range(NUM_UNSIGNED_BITS - 1):
        if (x >> i) & 1 != (x >> (i+1)) & 1:
            x ^= (1 << i) | (1 << (i+1))  # Swaps bit-i and bit-(i+1)
            return x
    # Raise error if all bits of x are 0 or 1.
    raise ValueError('All bits are 0 or 1')

# 4.5 Compute x * y without arithmetical operators
# Write a program that multiplies two nonnegative integers.
# The only operators you are allowed to use are
# - assignment
# - the bitwise operators >>, <<, |, &, ~, ^ and
# - equality checks and Boolean combinations thereof.
def multiply(x, y):
    def add(a, b):
        running_sum, carryin, k, temp_a, temp_b = 0, 0, 1, a, b
        while temp_a or temp_b:
            ak, bk = a & k, b & k
            carryout = (ak & bk) | (ak & carryin) | (bk & carryin)
            running_sum |= ak ^ bk ^ carryin
            carryin, k, temp_a, temp_b = (carryout << 1, k << 1,
                                          temp_a >> 1, temp_b >> 1)
        return running_sum | carryin

    running_sum = 0
    while x:    # Examines each bit of x.
        if x & 1:
            running_sum = add(running_sum, y)
        x, y = x >> 1, y << 1
    return running_sum

if __name__ == '__main__':
    pass
'''
    import time

    x = 173 # 0b1010_1101
    i, j = 3, 3
    time1 = []
    time2 = []
    for _ in range(10000):
        start1 = time.perf_counter()
        swap_bits(x, i, j)
        end1 = time.perf_counter()
        time1.append(end1 - start1)
    for _ in range(10000):
        start2 = time.perf_counter()
        swap_bits_noif(x, i, j)
        end2 = time.perf_counter()
        time2.append(end2 - start2)
    print('swap bits with if statement: ', sum(time1)/len(time1))
    print('swap bits without if statement: ', sum(time2)/len(time2))
'''
