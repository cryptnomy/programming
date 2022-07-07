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

