package com.forerun.dec.core.util;

import com.forerun.dec.core.util.impl.Apple;
import com.forerun.dec.core.util.impl.Samsung;

public class Demo {
	
	public static void main(String[] args) {
		Mobile mobile1 = new Samsung();
		System.out.println(mobile1.makeCall());
	}

}
