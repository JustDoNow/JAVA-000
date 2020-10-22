package com.qz;

import java.io.InputStream;

/**
 * FileTest
 *
 * @author qizhi
 * @date 2020/10/22
 */
public class FileTest {

	public static void main(String[] args) {
		final InputStream systemResourceAsStream = ClassLoader.getSystemResourceAsStream("Hello.xlass");

	}

}
