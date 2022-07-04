#include <iostream>

int main() {
    int lucky_number = 3;
    std::cout << "Guess my secret number~" << std::endl;

    int user_input;

    while (1) {
        std::cout << "Input: ";
        std::cin >> user_input;
        if (lucky_number == user_input) {
            std::cout << "Correct" << std::endl;
            break;
        }
        else {
            std::cout << "Rethink again!" << std::endl;
        }
    }
    return 0;
}