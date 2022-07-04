#include <iostream>

class Sample {
    int num1, num2;
    public:
        Sample(int a, int b);
        Sample(const Sample& sp);
};

Sample::Sample(int a, int b) {
    std::cout << "Default constructor" << std::endl;
    num1 = a;
    num2 = b;
}

Sample::Sample(const Sample& sp) {
    std::cout << "Copy constructor" << std::endl;
    num1 = sp.num1;
    num2 = sp.num2;
}

int main() {
    Sample sp1(3, 3);
    Sample sp2(sp1);
    Sample sp3 = sp2;
}