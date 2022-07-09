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
        # i =th and j-th bits differ. We will swap them
        # by flipping their values.
        # Select the bits to flip with bit_mask.
        # Since x ^ 1 = 0 when x = 1 and 1 when x = 0,
        # we can perform the flip XOR.
        bit_mask = (1 << i) | (1 << j)
        x ^= bit_mask
    return x

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
    return (PRECOMPUTED_REVERSE[x&BIT_MASK] << (3*MASK_SIZE) |
            PRECOMPUTED_REVERSE[(x>>MASK_SIZE)&BIT_MASK] << (2*MASK_SIZE) |
            PRECOMPUTED_REVERSE[(x>>2*MASK_SIZE)&BIT_MASK] << MASK_SIZE |
            PRECOMPUTED_REVERSE[(x>>3*MASK_SIZE)&BIT_MASK])

# 4.4 Find a closest integer with the same weight
