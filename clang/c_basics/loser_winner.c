#include <stdio.h>

struct HUMAN {
    int age;
    int height;
    int weight;
    int gender;
};
typedef struct HUMAN Human;
int print_status(struct HUMAN human);

int main() {
    Human Adam = {31, 182, 75, 0};
    Human Eve = {27, 166, 48, 1};

    print_status(Adam);
    print_status(Eve);
}

int print_status(Human human) {
    if (human.gender == 0) {
        printf("MALE\n");
    }
    else {
        printf("FEMALE\n");
    }
    printf("AGE: %d // HEIGHT: %d // WEIGHT: %d\n",
           human.age, human.height, human.weight);
    if (human.gender == 0 && human.height >= 180) {
        printf("HE IS A WINNER\n");
    }
    else if (human.gender == 0 && human.height < 180) {
        printf("HE IS A LOSER\n");
    }
    printf("---------------\n");

    return 0;
}