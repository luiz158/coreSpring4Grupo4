package org.certificatic.spring.core.practica14.test.numericalConverter;

import java.text.DecimalFormat;

import org.certificatic.spring.core.practica14.numericalConverter.bean.NumericalConverter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NumericalConverterTest {

	private static ClassPathXmlApplicationContext applicationContext;

	private DecimalFormat currencyFormat = new DecimalFormat("$ ###,###,###.##");

	private DecimalFormat simpleNumberFormat = new DecimalFormat("#.##");

	@Before
	public void beforeTest() {
		applicationContext = new ClassPathXmlApplicationContext(
				"spring/practica14/numerical-converter-application-context.xml");
	}

	@Test
	public void numericalConverterTest() {

		log.info("numericalConverterTest -------------------");

		// Obtener bean NumericalConverter
		// realizar test con Asserts

		NumericalConverter converter = applicationContext.getBean(NumericalConverter.class);
		
		Assert.assertNotNull(converter);
		
		double number = Math.random() * 999_999_999;
		
		String numeroStr = simpleNumberFormat.format(number);
		
		log.info("numero: {}", numeroStr);
		log.info("amount: {}", currencyFormat.format(number));
		
		log.info("number in letters: {}", converter.convert(numeroStr, true));

	}

	@After
	public void shutDown() {
		((AbstractApplicationContext) applicationContext).close();
	}

}
