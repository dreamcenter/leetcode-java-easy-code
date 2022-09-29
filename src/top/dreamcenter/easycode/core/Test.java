package top.dreamcenter.easycode.core;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import top.dreamcenter.easycode.anno.TMD;
import top.dreamcenter.easycode.inte.NB;

/**
 * quick boot for leetcode
 * ******tips*******
 * eclipse
 * ------------
 * Ctrl + 1		: 补全返回值
 * Alt + /		: 提示
 * @author Dai
 *
 */

public class Test {
	private static final String PACKAGE;
	
	static {
		Properties properties = new Properties();
		String pk_name = null;
		try {
			InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("config.properties");
			if (inputStream == null) {
				throw new Exception("未找到config.properties");
			}
			properties.load(inputStream);
			pk_name = properties.getProperty("package");
		} catch (IOException e) {
			System.err.println("[dai]\t加载config.properties时出现错误！" + e.getMessage());
		} catch (Exception e) {
			System.err.println("[dai]\t" + e.getMessage());
		} finally {
			PACKAGE = pk_name;
		}
	}
	
	public static void main(String[] args) {
		if (PACKAGE!=null) {
			System.out.println("START");
			System.out.println("********************");
			reflectClasses(getClassList());
			System.out.println("********************");
			System.out.println("END");
		} else {
			System.err.println("Package is null!");
		}
	}
	
	/**
	 * get class from the target package
	 * @return
	 */
	public static List<String> getClassList() {
		final String PATH = PACKAGE.replace(".", "/");
		String path = Test.class.getClassLoader().getResource(PATH).getPath();
		File directory = new File(path);
		List<String> list = new ArrayList<>();
		String[] files = directory.list();
		if (files == null) {
			return list;
		}
		for (String tmp : files) {
			int index = tmp.indexOf(".class");
			if (index>0) list.add(tmp.substring(0, index));
		}
		return list;
	}
	
	/**
	 * execute target
	 * @param list
	 */
	public static void reflectClasses(List<String> list) {
		for (String name : list) {
			Class<?> clazz = null;
			try {
				clazz = Class.forName(PACKAGE + "." + name);
				TMD tmd = clazz.getAnnotation(TMD.class);
				if (tmd!=null && (tmd.value()==true)) {
					NB nb = (NB) clazz.getConstructor().newInstance();
					System.out.println("=== " + clazz.getSimpleName() + " ===");
					nb.runNB();
				}
			} catch (ClassCastException e) {
				System.err.println("[dai]\t" + e.getMessage());
			} catch (RuntimeException e) {
				e.printStackTrace();
			}  catch (Exception e) {
				System.err.println("[dai]\t!!!???" + "sth ran wrong internal : " + e.getMessage());
			}
			
		}
	}
}
