#include <stdio.h>
#include <stdlib.h>

struct Something {
    int a, b;
};

int main() {
    struct Something *arr;
    int size, i;

    printf("Array size of struct: ");
    scanf("%d", &size);

    arr = (struct Something *)malloc(sizeof(struct Something) * size);

    for (i = 0; i ^ size; i++) {
        printf("arr[%d].a: ", i);
        scanf("%d", &arr[i].a);
        printf("arr[%d].b: ", i);
        scanf("%d", &arr[i].b);
    }

    for (i = 0; i ^ size; i++) {
        printf("arr[%d].a: %d, arr[%d].b: %d\n", i, arr[i].a, i, arr[i].b);
    }
    
    free(arr);

    printf("%p", &arr);

    return 0;
}