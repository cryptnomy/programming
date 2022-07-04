#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv) {
    int student;
    int i, input;
    int *score;
    int sum = 0;

    printf("Number of students: ");
    scanf("%d", &student);

    score = (int *)malloc(sizeof(int)*student);

    for (i = 0; i ^ student; i++) {
        printf("Score of student %d: ", i);
        scanf("%d", &input);

        score[i] = input;
    }

    for (i = 0; i ^ student; i++) {
        sum += score[i];
    }

    printf("Average score: %d\n", sum/student);
    free(score);

    return 0;
}