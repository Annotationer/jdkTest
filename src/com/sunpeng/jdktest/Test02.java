package com.sunpeng.jdktest;

import java.lang.annotation.Target;
import java.sql.SQLException;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

import javax.sql.RowSet;
import javax.sql.rowset.Predicate;

public class Test02 {

	public static void main(String[] args) {
		Hint hint = Person.class.getAnnotation(Hint.class);
		
		
		//Hint hints1 = Person.class.getAnnotation(Hints.class);
		
		Hint[] hints2 = Person.class.getAnnotationsByType(Hint.class);
		
		
		Optional<String> name = Optional.of("sdsad");
		
		//Optional<String> someNull = Optional.of(null);
	
		Optional<String> empty = Optional.ofNullable(null);
		
		System.out.println(name.toString());
		System.out.println(name.get());
		
		name.ifPresent( new Consumer() {

			@Override
			public void accept(Object arg0) {
				// TODO Auto-generated method stub
				System.out.println(String.valueOf(arg0).length());
			}});
		
		
		name.ifPresent((s) -> System.out.println(s.length()));
		
		System.out.println(empty.orElse("sdas"));
		
		System.out.println(name.orElse("1232"));
		
		name.orElseGet(new Supplier() {

			@Override
			public Object get() {
				// TODO Auto-generated method stub
				return null;
			}
			
		});
		
		System.out.println(name.orElseGet(()->"Default value"));
		System.out.println(empty.orElseGet(()->"Default value"));
		
		
		try {
			name.orElseThrow(ValueAbsentException::new);
		} catch (ValueAbsentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		try {
//			empty.orElseThrow( new Supplier() {
//
//				@Override
//				public Object get() {
//					// TODO Auto-generated method stub
//					return null;
//				}
//				
//			});
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		name.flatMap((value) -> Optional.of(value.toUpperCase()));
		
		
		Optional<String> longName = name.filter((value)->value.length()>5);
		System.out.println(longName.orElse("The name is less than 6 characters"));
		//Êä³öSanaulla
		 
		Optional<String> anotherName = Optional.of("Sanasdsds");
		Optional<String> shortName = anotherName.filter((value) ->value.length()>6);
		
		System.out.println(shortName.orElse("The name is less than 6 characters"));
	
		 
	}
}

class ValueAbsentException extends Throwable {
	 
	  public ValueAbsentException() {
	    super();
	  }
	 
	  public ValueAbsentException(String msg) {
	    super(msg);
	  }
	 
	  @Override
	  public String getMessage() {
	    return "No value present in the Optional instance";
	  }
}


//
//@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
//@interface MyAnnotation {}
