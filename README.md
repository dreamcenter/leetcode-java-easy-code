# leetcode-java-easy-code

---

## 简介

为java提供便捷刷leetcode题目的框架,作者dai, github:dreamcenter

## 场景

当我们刷Leetcode题目时，总是感觉编写**核心代码**时候要进行**繁琐的项目创建**，

亦或是**频繁创建main函数**，当做的多了，启动列表和项目会有一大串！

这样让刷题的体感**不是很舒适**，所以编写了这个刷题助手，

无需再去想如何管理main函数和项目，**只需要简单配置**，即可开刷！

## 如何使用

#### 环境搭建

1. 从release导入打包好了的jar包

2. 新建一个刷题专用的project

3. 新建包层级（至少有一个层级）

4. 在该项目的classpath下新建config.properties

5. 在该配置文件中写下即将被扫描的包，如a.b.c

```
package=a.b.c
```

#### 开始做题

1. 在被扫描的包中，添加一个类，名字按自己喜好编号，如Solution0001.java

2. 给该类添加注解 **@TMD** ,表示该类会被扫描执行

3. 让该类实现 **NB接口** ,该接口有一个函数runNB()，是实现类的入口函数

4. 将leetcode上的核心代码函数拷贝到该类中，编写内容，通过runNB()函数调用与测试

5. 完成！如果开始下一题重复该1~4的流程即可

## 如何关闭

如果一个类（题目）已经解决，不希望下次进入该类的入口函数（即不希望被执行），

那么，只需要给注解 @TMD 的value赋值false即可（即 **@TMD(false)**）

当然，如果直接注释掉注解也可以达到效果。


## 实例

以下为leetcode第9题回文数的构建解决示例

```java
package a.b.c;

import top.dreamcenter.anno.TMD;
import top.dreamcenter.inte.NB;

@TMD
public class Solution0009 implements NB{
	
	// 为核心代码函数 ， CV 自leetcode， 内容即算法核心，自行填写
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

	// 实现自NB接口， 为该类的入口函数，我这里对所有测试用例进行一同测试，返回结果
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



## 注意

内含启动主函数类，所以无需再写启动类了。







