package com.java8;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) throws Exception {
		List<Integer> ls = new ArrayList<Integer>();
		ls.add(2);
		ls.add(3);
		Test t = new Test();
		ls.forEach(t::t2);
	}
	
	public void t3() {
		System.out.println("no:");
	}
	
	public void t2(int i) {
		System.out.println(i);
	}
	
	public static void t1(int i) {
		System.out.println(i);
	}
}



