# Binary search of sorted array with duplicates
def binarySearch(arr, target):
    low, high = 1, len(arr) - 1
    while low < high:
        mid = (low + high) // 2
        if arr[mid] > target:
            high = mid - 1
        else:
            low = mid + 1
    if arr[high] > target:
        return high - 1
    else:
        return high

arr = [-1, 1, 1, 2, 4, 5, 5, 8, 8, 9]
target = 1

idx = binarySearch(arr, target)
print(idx)