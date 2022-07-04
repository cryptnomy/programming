#include <iostream>
#include <vector>

class Solution {
public:
    bool isPalindrome(int x) {
        if (x == 0)
            return true;
        if (x < 0 || x % 10 == 0)
            return false;
        int y = 0;
        while (x > y) {
            y = y * 10 + x % 10;
            x /= 10;
            std::cout << x << ", " << y << std::endl;
        }
        return x == y || x == y / 10;
    }
};

int main() {
    Solution sol;
    int x = 127721;
    bool is_Palindrome = sol.isPalindrome(x);
    std::cout << is_Palindrome << std::endl;
    return 0;
}