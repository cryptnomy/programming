'''
input: in-order & post-order
output: pre-order
'''

import sys
sys.setrecursionlimit(1_000_000)
read = sys.stdin.readline

def preorder(in_start, in_end, post_start, post_end):
    if (in_start > in_end) or (post_start > post_end):
        return

    parent = postorder[post_end]
    print(parent, end=' ')
    left = position[parent] - in_start
    right = in_end - position[parent]

    preorder(in_start, in_start + left - 1, post_start, post_start + left - 1)
    preorder(in_end - right + 1, in_end, post_end - right, post_end - 1)

n = int(read())
inorder = list(map(int, read().split()))
postorder = list(map(int, read().split()))

position = [0] * (n+1)
for i in range(n):
    position[inorder[i]] = i

preorder(0, n - 1, 0, n - 1)

# My second trial; failed due to recusion error and timeout
# import sys

# read = sys.stdin.readline

# n = int(read())
# inorder = list(map(int, read().split()))
# postorder = list(map(int, read().split()))

# class Tree:
#     def __init__(self, n, inorder, postorder):
#         self.len = n
#         self.inorder = inorder
#         self.postorder = postorder
#         self.preorder = []
#         self.post_index = n - 1
    
#     def print_preorder(self):
#         self.fill_preorder(0, self.len - 1)
#         print(' '.join(map(str, reversed(self.preorder))))

#     def fill_preorder(self, start, end):
#         if (start > end):
#             return
#         node = self.postorder[self.post_index]
#         in_index = self.inorder.index(node)
#         self.post_index -= 1
#         self.fill_preorder(in_index + 1, end)
#         self.fill_preorder(start, in_index - 1)
#         self.preorder.append(node)
        
# tree = Tree(n, inorder, postorder)
# tree.print_preorder()

# # My first trial; failed
# import sys

# read = sys.stdin.readline

# n = int(read())
# inorder = list(map(int, read().split()))
# postorder = list(map(int, read().split()))

# def print_preorder(inorder, postorder):
#     if not postorder:
#         return
#     parent = postorder[-1]
#     print(parent, end=' ')

#     if not inorder:
#         return
#     inorder_index_parent = inorder.index(parent)
#     inorder_left = inorder[:inorder_index_parent]
#     inorder_right = inorder[inorder_index_parent+1:]

#     try:
#         right = inorder[inorder_index_parent+1]
#         postorder_index_right = postorder.index(right)
#         postorder.pop()
#         postorder_left = postorder[:postorder_index_right]
#         postorder_right = postorder[postorder_index_right:]
#     except:
#         right = parent
#         postorder.pop()
#         postorder_left = postorder[:]
#         postorder_right = []
    
#     print_preorder(inorder_left, postorder_left)
#     print_preorder(inorder_right, postorder_right)

# print_preorder(inorder, postorder)
