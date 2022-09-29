package top.dreamcenter.easycode.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import top.dreamcenter.easycode.inte.NB;

/**
 * An annotation that signed on the solution class,<br/>
 * only the classes which are annotated by 'TMD' will be scanned.<br/><br/>
 * 
 * <b>if use this annotation, you must implement this interface: {@link NB top.dreamcenter.inte.NB}<br/>
 * otherwise something might went wrong.</b>
 * 
 * @author Dai
 * 
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TMD {
	/**
	 * if true, that means this will be run,<br/>
	 * if false,the class will be ignored
	 * @return 
	 */
	boolean value() default true;
}
