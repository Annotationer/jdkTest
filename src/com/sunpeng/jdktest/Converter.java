package com.sunpeng.jdktest;

public interface Converter<F,T> {
	T convert(F from);
}
