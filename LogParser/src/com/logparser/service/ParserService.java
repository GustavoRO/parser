package com.logparser.service;

import java.io.Serializable;
import java.util.Date;

import com.logparser.persistence.ParserDAO;

public class ParserService implements Serializable {

	private static final long serialVersionUID = 1L;

	private ParserDAO dao;

	public ParserService() {
		dao = new ParserDAO();
	}

	public void loadLogIntoFile() throws Exception {
		
	}

	public void printLogTimePeriod(Date init, int duration, int qtd) throws Exception {

	}

	public Long getNumberRequestsFromIp(String ip) throws Exception {
		return dao.countNumberAccess(ip);
	}

}
