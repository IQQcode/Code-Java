package xishanju;

/**
 * @Author: iqqcode
 * @Date: 2020-10-01 09:23
 * @Description:
 */

import java.util.*;

public class Main {
    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> path = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];
        dfs_cut(path, nums, visit);
        List<List<Integer>> res = new ArrayList<>(set);
        return res;
    }

    private void dfs_cut(List<Integer> path, int[] nums, boolean[] visit) {
        if(path.size() == nums.length) {
            set.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!visit[i]) {
                //递归前，做出选择
                visit[i] = true;
                path.add(nums[i]);
                //递归
                dfs_cut(path, nums, visit);
                //回退，移除选择
                path.remove(path.size() - 1);
                visit[i] = false;
            }
        }
    }
}