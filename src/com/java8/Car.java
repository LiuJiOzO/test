package com.java8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Car {
	int id;
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }
 
    public static void collide(final Car car) {
        System.out.println("1 " + car.id);
    }
 
    public void follow(final Car another) {
        System.out.println("2" + another.id);
    }
 
    public void repair() {
        System.out.println("3:" + this.id + this.toString());
    }
    
    public static void main(String[] args) {
		List<Car> ls = new ArrayList<Car>();
		Car c1 = Car.create(Car::new);
		c1.id=1;
		ls.add(c1);
		Car c2 = Car.create(Car::new);
		c2.id=2;
		ls.add(c2);
		
		ls.forEach(Car::repair);
		ls.forEach(o -> {
			o.repair();
		});
		ls.forEach(o -> {
			System.out.println(o.id);
		});
		ls.forEach(o -> {
			System.out.println(666);
		});
		
		for( Filter filter: Filterable.class.getAnnotationsByType( Filter.class ) ) {
            System.out.println( filter.value() );
        }
		
	}
    
        @Target( ElementType.TYPE )
        @Retention( RetentionPolicy.RUNTIME )
        public @interface Filters {
            Filter[] value();
        }
        
        @Target( ElementType.TYPE )
        @Retention( RetentionPolicy.RUNTIME )
        @Repeatable( Filters.class )
        public @interface Filter {
            String value();
        };
        
        @Filter( "filter1" )
        @Filter( "filter2" )
        public interface Filterable {        
        }
        
}
