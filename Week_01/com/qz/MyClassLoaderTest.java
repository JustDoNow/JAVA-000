package com.qz;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author qizhi
 * @date 2020/10/21
 */
public class MyClassLoaderTest {

	public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

		MyClassLoader myClassLoader = new MyClassLoader("com/qz/", "myClassLoader");
		final Class helloClass = myClassLoader.findClass("Hello");
		final Object helloObject = helloClass.newInstance();
		final Method helloMethod = helloClass.getMethod("hello", null);

		// Hello, classLoader!
		helloMethod.invoke(helloObject, null);
	}
}
