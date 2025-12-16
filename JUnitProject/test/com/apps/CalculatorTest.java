package com.apps;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Order(2)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalculatorTest {
	@Order(2)
	@Test
	void testA() {
		Calculator calc = new Calculator();
		System.out.println("Running Test A");
		System.out.println(calc.integerDivision(10, 2));
	}
	@Order(3)
	@Test
	void testB() {
		System.out.println("Running Test B");			
		}
	@Order(1)
	@Test
	void testC() {
		System.out.println("Running Test C");		
	}
}
