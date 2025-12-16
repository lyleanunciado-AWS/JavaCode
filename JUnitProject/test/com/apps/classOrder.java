package com.apps;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@Order(1)
class classOrder {

	@Test
	void testD() {
		System.out.println("Running Test D");
	}

}
