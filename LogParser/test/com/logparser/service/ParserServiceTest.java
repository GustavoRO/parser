package com.logparser.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParserServiceTest {
	
	private ParserService service;

	@Before
	public void setUp() throws Exception {
		service = new ParserService();
	}

	@Test
	public void testLoadLogIntoFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrintLogTimePeriod() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumberRequestsFromIp() {
		
		String testIp = "192.168.11.231";
		Long result = 0l;
		
		try {
			result = service.getNumberRequestsFromIp(testIp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		assert(result > 200);
		
	}

}
