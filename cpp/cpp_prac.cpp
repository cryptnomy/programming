#include <iostream>

void draw1(int h) {
    if (h == 0) {
        return;
    }
    draw1(h - 1);
    for (int i = 0; i < h; ++i) {
        printf("*");
    }
    printf(" ");
}

void draw2(int h) {
    for (int o = 0; o < h; ++o) {
        for (int i = 0; i < o; ++i) {
            printf("*");
        }
        printf(" ");
    }
}

int main() {
    /*int a, b;
    std::cin >> a >> b;
    std::cout << a + b << std::endl;
    return 0;*/
    int square[3][3] = {{4, 9, 2},
                        {3, 5, 7},
                        {8, 1, 6}};
    printf("%d\n", square[1][1]);
    printf("%d\n", square[1][-1]);
    printf("%d\n", square[1][4]);
    
    draw1(5);
    printf("\n");
    draw2(5);
}