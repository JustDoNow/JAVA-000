package com.qz;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * MyClassLoader
 *
 * @author qizhi
 * @date 2020/10/21
 */
public class MyClassLoader extends ClassLoader {

	/**
	 * class文件后缀
	 */
	private static final String CLASS_FILE_SUFFIX = ".xlass";
	private final String relativePath;
	private final String classLoaderName;

	public MyClassLoader(String relativePath, String classLoaderName) {
		this.relativePath = relativePath;
		this.classLoaderName = classLoaderName;
	}

	/**
	 * 用于寻找类文件
	 *
	 * @param className class名
	 * @return
	 */
	@Override
	public Class<?> findClass(String className) {
		byte[] b = loadClassData(className);
		return defineClass(className, b, 0, b.length);
	}

	/**
	 * 用于加载类文件
	 *
	 * @param className
	 * @return
	 */
	private byte[] loadClassData(String className) {
		String classPathName = relativePath + className + CLASS_FILE_SUFFIX;
		InputStream in = null;
		ByteArrayOutputStream out = null;

		try {
			in = ClassLoader.getSystemResourceAsStream(classPathName);
			out = new ByteArrayOutputStream();
			int i = 0;
			while ((i = in.read()) != -1) {
				// 特殊处理
				i = 255 -i;
				out.write(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (out != null) {
			return out.toByteArray();
		}

		return new byte[0];
	}


}
