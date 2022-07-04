#include <iostream>
#include <vector>

int main() {
    std::vector<int> vec;
    vec.push_back(10);
    vec.push_back(20);
    vec.push_back(30);
    vec.push_back(40);

    for (std::vector<int>::size_type i = 0; i < vec.size(); i++) {
        if (i == 0)
            std::cout << i + 1 << "st element of vec :: " << vec[i] << std::endl;
        else if (i == 1)
            std::cout << i + 1 << "nd element of vec :: " << vec[i] << std::endl;
        else
            std::cout << i + 1 << "th element of vec :: " << vec[i] << std::endl;
    }
}