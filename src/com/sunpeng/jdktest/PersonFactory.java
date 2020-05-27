package com.sunpeng.jdktest;
public interface PersonFactory <P extends Person>{
	P create(String firstName,String lastName);
	
}
