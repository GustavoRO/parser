package com.logparser.service;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import com.logparser.dto.TypeSeachENUM;

public class ParserServiceTest {

	private ParserService service;

	@Before
	public void setUp() throws Exception {
		service = new ParserService();
	}

	// @Test
	public void testLoadLogIntoFile() {

		boolean loaded = false;

		try {
			loaded = service.loadLogIntoFile();
		} catch (Exception e) {
			e.printStackTrace();
		}

		assert loaded;

	}

	@Test
	public void testBlockIPTimePeriod() {

		Calendar calendar = Calendar.getInstance();

		calendar.set(2017, 00, 01, 00, 00, 00);

		try {
			service.saveBlockLogTimePeriod(calendar.getTime(), TypeSeachENUM.HOURLY.val, 200);
		} catch (Exception e) {
			assert false;
			e.printStackTrace();
		}

		assert true;
	}

	@Test
	public void testGetNumberRequestsFromIp() {

		String testIp = "192.168.234.82";
		Integer result = 0;

		try {
			result = service.getNumberRequestsFromIp(testIp);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assert (result > 200);

	}

}
