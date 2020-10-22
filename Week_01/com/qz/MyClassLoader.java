package com.qz;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * MyClassLoader
 *
 * @author qizhi
 * @date 2020/10/21
 */
public class MyClassLoader extends ClassLoader {

	private static final String CLASS_FILE_SUFFIX = ".xlass";
	private final String relativePath;
	private final String classLoaderName;

	public MyClassLoader(String packagePath, String classLoaderName) {
		this.relativePath = packagePath;
		this.classLoaderName = classLoaderName;
	}

	//用于寻找类文件
	@Override
	public Class findClass(String name) {
		byte[] b = loadClassData(name);
		return defineClass(name, b, 0, b.length);
	}

	//用于加载类文件
	private byte[] loadClassData(String className) {
		String classPathName = relativePath + className + CLASS_FILE_SUFFIX;
		InputStream in = null;
		ByteArrayOutputStream out = null;

		try {
			in = ClassLoader.getSystemResourceAsStream(classPathName);
			out = new ByteArrayOutputStream();
			int i = 0;
			while ((i = in.read()) != -1) {
				i = 255 -i;
				out.write(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return out.toByteArray();


	}


}
