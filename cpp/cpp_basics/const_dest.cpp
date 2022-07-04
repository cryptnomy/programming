#include <string.h>
#include <iostream>

class Test {
    char c;

    public:
        Test(char _c) {
            c = _c;
            std::cout << "Constructor " << c
                      << " called" << std::endl;
        }
        ~Test() { std::cout << "Destructor " << c
                            << " called" << std::endl; }
};

void simple_function() { Test b('b'); }

int main() {
    Test a('a');
    simple_function();
    return 0;
}