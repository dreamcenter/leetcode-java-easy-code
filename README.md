# leetcode-java-easy-code

---

## ���

Ϊjava�ṩ���ˢleetcode��Ŀ�Ŀ��,����dai, github:dreamcenter

## ����

������ˢLeetcode��Ŀʱ�����Ǹо���д**���Ĵ���**ʱ��Ҫ����**��������Ŀ����**��

�����**Ƶ������main����**�������Ķ��ˣ������б����Ŀ����һ�󴮣�

������ˢ������**���Ǻ�����**�����Ա�д�����ˢ�����֣�

������ȥ����ι���main��������Ŀ��**ֻ��Ҫ������**�����ɿ�ˢ��

## ���ʹ��

#### �����

1. ��release���������˵�jar��

2. �½�һ��ˢ��ר�õ�project

3. �½����㼶��������һ���㼶��

4. �ڸ���Ŀ��classpath���½�config.properties

5. �ڸ������ļ���д�¼�����ɨ��İ�����a.b.c

```
package=a.b.c
```

#### ��ʼ����

1. �ڱ�ɨ��İ��У����һ���࣬���ְ��Լ�ϲ�ñ�ţ���Solution0001.java

2. ���������ע�� **@TMD** ,��ʾ����ᱻɨ��ִ��

3. �ø���ʵ�� **NB�ӿ�** ,�ýӿ���һ������runNB()����ʵ�������ں���

4. ��leetcode�ϵĺ��Ĵ��뺯�������������У���д���ݣ�ͨ��runNB()�������������

5. ��ɣ������ʼ��һ���ظ���1~4�����̼���

## ��ιر�

���һ���ࣨ��Ŀ���Ѿ��������ϣ���´ν���������ں���������ϣ����ִ�У���

��ô��ֻ��Ҫ��ע�� @TMD ��value��ֵfalse���ɣ��� **@TMD(false)**��

��Ȼ�����ֱ��ע�͵�ע��Ҳ���ԴﵽЧ����


## ʵ��

����Ϊleetcode��9��������Ĺ������ʾ��

```java
package a.b.c;

import top.dreamcenter.anno.TMD;
import top.dreamcenter.inte.NB;

@TMD
public class Solution0009 implements NB{
	
	// Ϊ���Ĵ��뺯�� �� CV ��leetcode�� ���ݼ��㷨���ģ�������д
	public boolean isPalindrome(int x) {
	    if (x == 0) return true;
	    if (x < 0 || x % 10 == 0) return false;
	    int reversed = 0;
	    while (x > reversed) {
	        reversed = reversed * 10 + x % 10;
	        x /= 10;
	    }
	    return x == reversed || x == reversed / 10;
   }

	// ʵ����NB�ӿڣ� Ϊ�������ں���������������в�����������һͬ���ԣ����ؽ��
	@Override
	public void runNB() {
		int[] in = {121,-121,10};
		boolean[] out = {true, false, false};
		
		for (int i = 0; i < in.length; i++) {
			System.out.println("===>\t" + in[i]);
			boolean res = isPalindrome(in[i]);
			if (res != out[i]) {
				System.out.println("<===\t" + "[nac]\t<" + out[i] + ">\t" + res);
			} else {
				System.out.println("<===\t" + "[ac]");
			}
		}
	}
}

```



## ע��

�ں������������࣬����������д�������ˡ�







