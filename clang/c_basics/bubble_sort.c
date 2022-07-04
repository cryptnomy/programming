#include <stdio.h>

void bubble_sort(int *arr, int len);
void swap(int *a), int *b;
void print_arr(int *arr, int len);

int main() {
    int arr[5] = {5, 1, 4, 2, 8};
    int len = sizeof(arr)/sizeof(int);
    printf("Before bubblesort: ");
    print_arr(arr, len);
    bubble_sort(arr, len);
    printf("After bubblesort: ");
    print_arr(arr, len);
    return 0;
}

void bubble_sort(int *arr, int len) {
    int i, j;
    for (i = 0; i < len - 2; i++) {
        for (j = len - 1; j > i; j--) {
            if (arr[j] < arr[j-1])
                swap(&arr[j], &arr[j-1]);
                //print_arr(arr, len);
        }
    }
}
void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}
void print_arr(int *arr, int len) {
    int i;
    for (i = 0; i < len; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}
