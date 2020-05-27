package com.sunpeng.jdktest;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class test01 {
	public static void main(String[] args) {
//		Converter<String ,Integer> converter = Integer::valueOf;
//		Integer converted = converter.convert("123");
//		System.out.println(converted);
		
		
//		Converter<String,String> converter = String::toString;
//		
//		String converted2 = converter.convert("java");
//		System.out.println(converted2);
//		
//		PersonFactory<Person> personFactory  = Person:: new ;
//		
//		//PersonFactory<Person> person2 = new Person();
//		
//		Person person = personFactory.create("aaa", "1111");
//		
		
		int num = 1;
		Converter<Integer,String> StringConverter = (from) -> String.valueOf(from + num);
		StringConverter.convert(2);
		System.out.println(StringConverter.convert(2));
		//System.out.println(num);
//		Formula formula = new Formula() {
//		    @Override
//		    public double calculate(int a) {
//		        return sqrt(a * 100);
//		    }
//		};
		
		//Formula formula1 =(a) -> sqrt(a*100);
		
		Predicate <String> predicate = (s) -> s.length()>0;
		
		predicate.test("foo");
		
		predicate.negate().test("foo");
		
		Predicate<Boolean> nonNull = Objects::nonNull;
		
		Predicate<Boolean> isNull = Objects::isNull;
		
		Predicate <String> isEmpty = String::isEmpty;
		
		Predicate <String> isNotEmpty = new Predicate<String>() {

			@Override
			public boolean test(String t) {
				// TODO Auto-generated method stub
				//isEmpty();
				return false;
			}
			
		};
		
		Function <String,Integer> toInteger = Integer::valueOf;
		
		Function <String,String> backToString = toInteger.andThen(String::valueOf);
		
		backToString.apply("2222");
		
		Supplier<Person> personSupplier = Person::new;
		personSupplier.get();
		
		Consumer<Person> greeter = (x) -> System.out.println("Hello," + x.firstName);
		greeter.accept(new Person("sdad","22323"));
		
		Comparator<Person> comparator = (p1,p2)->p1.firstName.compareTo(p2.firstName);
		
		Person p1 = new Person("","");
		Person p2 = new Person("","");
		
		comparator.compare(p1, p2);
		
		
		Optional<String> optional = Optional.of("bam");
		
		optional.isPresent();
		
		optional.get();
		
		optional.orElse("fallback");
		
		optional.ifPresent((s)->System.out.println(s.charAt(0)));
		
		List<String> StringCollection = new ArrayList<>();
		
		StringCollection.add("ddd2");
		StringCollection.add("a232");
		StringCollection.add("222");
		StringCollection.add("a111");
		StringCollection.stream().filter((s) -> s.startsWith("a")).forEach(System.out::println);
		
		StringCollection.stream().map(String::toUpperCase).sorted((a,b) ->b.compareTo(a)).forEach(System.out::println);
		
		Boolean anyStartsWithA = StringCollection.stream().anyMatch((s) -> s.startsWith("a"));
		
		Optional<String> reduced = StringCollection.stream().sorted().reduce((s1,s2) ->s1 + "#" +s2);
		
		reduced.ifPresent(System.out::println);
		
		
		int max =100000;
		
		List<String> values = new ArrayList<>(max);
		
		for(int i=0;i<max;i++) {
			UUID uuid = UUID.randomUUID();
			values.add(uuid.toString());
		}
		
		//System.out.println(values);
		
		
		long t0 = System.nanoTime();
		
		long count = values.stream().sorted().count();
		
		long t1 = System.nanoTime();
		
		
		long millis  = TimeUnit.NANOSECONDS.toMillis(t1-t0);
		
		System.out.println(String.format("sequential sort took: %d ms", millis));
		
		
		Map <Integer,String> map = new HashMap<>();
		
		for(int i = 0;i<10;i++) {
			map.putIfAbsent(i, "val" + i);
		}
		System.out.println(map.toString());
		map.computeIfPresent(3, (num2 , val)->val + num2);
		map.computeIfAbsent(23, num2 -> "val" + num2);
		System.out.println(map.toString());
		
		
		Clock clock = Clock.systemDefaultZone();
		long millis2 = clock.millis();
		Instant instant = clock.instant();
		Date l = Date.from(instant);
		System.out.println(l);
		
		ZoneId zone1 = ZoneId.of("Asia/Tokyo");
		System.out.println(zone1.getRules());
		
		LocalTime now1 = LocalTime.now(zone1);
		System.out.println(now1);
		
		LocalTime late = LocalTime.of(23, 59, 59);
		
		DateTimeFormatter germanFormatter = DateTimeFormatter
				.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.GERMAN);
		
		LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
		System.out.println(leetTime);   // 13:37
		
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plus(1,ChronoUnit.DAYS);
		LocalDate yesterday = tomorrow.minusDays(2);
		
	
		LocalDate independenceDay = LocalDate.of(2014, Month.APRIL,4);
		
		DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
		
		System.out.println(today);
		
		DateTimeFormatter germanFormatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
				.withLocale(Locale.GERMAN);
		LocalDate xmas = LocalDate.parse("24.12.2014",germanFormatter2);
		
		System.out.println(xmas);
		

		
		
	}
}




@interface Hints{
	Hint[] value();
}


//@Repeatable(value = Hints.class)
@interface Hint{
	String value();

}

@Hints({@Hint("hint1"),@Hint("hint2")})
class Person3{}

//@Hint("hint1")
//@Hint("hint2")
//class Person2{}


