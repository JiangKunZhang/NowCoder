package 跳跃游戏;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/4 16:00
 */

/**
 * 设想一下，对于数组中的任意一个位置 y，我们如何判断它是否可以到达？根据题目的描述，只要存在一个位置 x，它本
 * 身可以到达，并且它跳跃的最大长度为 x + nums[x]，这个值大于等于 y，即 x+nums[x] ≥ y，那么位置y也可以到
 * 达。
 * 换句话说，对于每一个可以到达的位置 x，它使得 x+1, x+2,⋯,x+nums[x] 这些连续的位置都可以到达。
 * 这样以来，我们依次遍历数组中的每一个位置，并实时维护最远可以到达的位置。对于当前遍历到的位置x，如果它在 最
 * 远可以到达的位置的范围内，那么我们就可以从起点通过若干次跳跃到达该位置，因此我们可以用 x+nums[x]更新 最远
 * 可以到达的位置。
 * 在遍历的过程中，如果最远可以到达的位置大于等于数组中的最后一个位置，那就说明最后一个位置可达，我们就可以直
 * 接返回True作为答案。反之，如果在遍历结束后，最后一个位置仍然不可达，我们就返回 False 作为答案。
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int rightMax = 0;
        for (int i = 0; i < nums.length; i++) {
            //如果可以到达当前位置，则更新最大
            if (i <= rightMax) {
                //每次更新最大的位置
                rightMax = Math.max(rightMax, nums[i] + i);
                //如果可以到达最后一个位置，则直接返回
                if (rightMax >= nums.length - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
