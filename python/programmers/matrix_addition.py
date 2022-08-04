# def add_matrix(mat1, mat2):
#     return [[e1 + e2 for e1, e2 in zip(row1, row2)] for row1, row2 in zip(mat1, mat2)]

def add_matrix(mat1, mat2):
    return [[sum(e) for e in zip(row1, row2)] for row1, row2 in zip(mat1, mat2)]

def add_matrix_np(mat1, mat2):
    import numpy as np
    mat1, mat2 = np.array(mat1), np.array(mat2)
    answer = mat1 + mat2
    return answer.tolist()    

def solution(mat1, mat2):
    return add_matrix(mat1, mat2)

if __name__ == "__main__":
    mat1, mat2 = [[1,2],[2,3]], [[3,4],[5,6]]
    print(add_matrix(mat1, mat2))
    # print(add_matrix_np(mat1, mat2))