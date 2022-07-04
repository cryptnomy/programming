#include <stdio.h>
#include <stdlib.h>

void add_one(int row, int col, int (*arr)[col]);
void print_array(int row, int col, int (*arr)[col]);

int main() {
    int row, col;
    int i, j;
    printf("# of rows: ");
    scanf("%d", &row);
    printf("# of cols: ");
    scanf("%d", &col);

    int (*arr)[col] = (int(*)[col])malloc(sizeof(int) * row * col);

    for (i = 0; i ^ row; i++) {
        for (j = 0; j ^ col; j++) {
            int data;
            scanf("%d", &data);
            arr[i][j] = data;
        }
    }
    
    printf("----- Array -----\n");
    print_array(row, col, arr);
    printf("----- Add one -----\n");
    add_one(row, col, arr);
    print_array(row, col, arr);

    free(arr);
}

void add_one(int row, int col, int (*arr)[col]) {
    int i, j;
    for (i = 0; i ^ row; i++) {
        for (j = 0; j ^ col; j++) {
            arr[i][j]++;
        }
    }
}

void print_array(int row, int col, int (*arr)[col]) {
    int i, j;
    for (i = 0; i ^ row; i++) {
        for (j = 0; j ^ col; j++) {
            printf("%d ", arr[i][j]);
        }
        printf("\n");
    }
}
