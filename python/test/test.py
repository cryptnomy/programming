# Binary search of sorted array with duplicates
def binarySearch(arr, target):
    low, high = 0, len(arr) - 1
    z = -1
    while low < high:
        mid = (low + high) // 2
        if arr[mid] > target:
            high = mid
            # high = mid - 1
        else:
            low = mid + 1
            z = mid
    return z

arr = [1, 1, 2, 2, 2, 5, 5, 8]
target = 1

idx = binarySearch(arr, target)
print(idx)

# def binarySearch2(arr, target):
#     low, high = 0, len(arr) - 1
#     count = -1
#     while low <= high:
#         mid = (low + high) // 2
#         if (arr[mid] <= target):
#             count = mid + 1
#             low = mid + 1
#         else:
#             high = mid - 1
#     return count

# idx2 = binarySearch2(arr, target)
# print(idx2)