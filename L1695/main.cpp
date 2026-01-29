#include<iostream>
#include <vector>
#include "math.h"
#include <algorithm>
#include <cstring>
using namespace std;
class Solution {
public:
    int maximumUniqueSubarray(vector<int>& nums) {
        int sum = nums[0], ans = nums[0], start = 0;
        int vis[10002];
        memset(vis,-1,sizeof(vis));
        vis[nums[0]] = 0;

        for (int i = 1; i < nums.size(); ++i) {
            if (vis[nums[i]] >= 0) {
                ans = max(ans, sum);
                while (start <= vis[nums[i]]) {
                    sum -= nums[start];
                    vis[nums[start]] = -1;
                    ++start;
                }

            }
            vis[nums[i]] = i;
            sum += nums[i];

        }
        ans = max(ans, sum);
        return ans;
    }
};

int main(){
    vector<int> test={4,2,4,5,6};
    Solution* s=new Solution();
    int ans=s->maximumUniqueSubarray(test);
    printf("%d ",ans);
    return 0;
}