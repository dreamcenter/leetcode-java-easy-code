package top.dreamcenter.test;

import java.util.HashMap;
import java.util.Map;

import top.dreamcenter.easycode.anno.TMD;
import top.dreamcenter.easycode.inte.NB;
import top.dreamcenter.easycode.util.ListNode;
import top.dreamcenter.easycode.util.ListNodeHelper;
import top.dreamcenter.easycode.util.PrintHelper;


@TMD(true)
public class Solution0001 implements NB{
	
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] res= new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				res[0] = map.get(nums[i]);
				res[1] = i;
				break;
			} else {
				map.put(target - nums[i], i);
			}
		}
		return res;
	}

	@Override
	public void runNB() {
		int[] res = twoSum(new int[] {3,3}, 6);
		PrintHelper.out.println(res);
		
		ListNode ln = ListNodeHelper.toListNode(res, false);
		PrintHelper.out.println(ln);
		
	}
	
}
