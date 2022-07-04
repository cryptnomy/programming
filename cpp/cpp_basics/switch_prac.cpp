#include <iostream>

using std::cout;
using std::endl;
using std::cin;

int main() {
    int user_input;
    cout << "Show my information" << endl;
    cout << "1. Name" << endl;
    cout << "2. Age" << endl;
    cout << "3. Sex" << endl;
    cin >> user_input;

    switch (user_input) {
        case 1:
            cout << "Psi ! " << endl;
            break;
        case 2:
            cout << "99 age" << endl;
            break;
        case 3:
            cout << "Male" << endl;
            break;
        default:
            cout << "No question?" << endl;
            break;
    }
    return 0;
}