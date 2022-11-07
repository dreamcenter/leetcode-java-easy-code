package top.dreamcenter.test2;

import top.dreamcenter.easycode.anno.TMD;
import top.dreamcenter.easycode.inte.NB;

@TMD(true)
public class Solution0003 implements NB{
	
	public int lengthOfLongestSubstring(String s) {
		int maxLen = 0;
		int front = 0;
		for (int i = 0; i < s.length(); i++) {
			int index = s.lastIndexOf(s.codePointAt(i), i-1);
			if (index==-1) {
				front++;
			} else {
				front = (i - index)>front?(front+1):(i - index);
			}
			maxLen = maxLen>front?maxLen:front;
		}
		
		return maxLen;
    }

	@Override
	public void runNB() {
		String[] input = { "abcabcbb", "bbbbb", "pwwkew", "abba","tmmzuxt" };
		int[] output = {3,1,3,2,5};
		
		for (int i = 0; i < output.length; i++) {
			boolean ac = true;
			StringBuilder sb = new StringBuilder();
			sb.append(input[i]).append(':').append(output[i]).append('[');
			
			int res = lengthOfLongestSubstring(input[i]);
			ac = res == output[i];
			sb.append(res);
			
			sb.append(']');
			if (ac) System.out.println(sb);
			else System.err.println(sb);
		}
		
	}
}
