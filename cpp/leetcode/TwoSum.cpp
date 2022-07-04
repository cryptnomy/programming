#include <iostream>
#include <vector>
#include <unordered_map>

class Solution {
    public:
        std::vector<int> twoSum(std::vector<int>& nums, int target) {
            std::unordered_map<int, int> hash;
            for (int i = 0; i < nums.size(); ++i) {
                int a = nums[i], b = target - a;
                if (hash.count(b))
                    return {hash[b], i};
                hash[a] = i;
            }
            return {};
        }
};

int main() {
    Solution sol;
    std::vector<int> nums = {2, 7, 11, 15};
    int target = 22;
    std::vector<int> result = sol.twoSum(nums, target);
    std::cout << "[" << result[0] << ", " 
              << result[1]  << "]" << std::endl;
    return 0;
}