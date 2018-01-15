package com.logparser.service;

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import com.logparser.dto.LogDTO;
import com.logparser.dto.TypeSeachENUM;
import com.logparser.entity.Blocked;
import com.logparser.entity.Log;
import com.logparser.persistence.ParserDAO;

public class ParserService implements Serializable {

	private static final long serialVersionUID = 1L;

	private ParserDAO dao;

	public ParserService() {
		dao = new ParserDAO();
	}

	@SuppressWarnings("rawtypes")
	public Boolean loadLogIntoFile() {
		boolean loaded = false;

		String fileName = "C://Java//access.log";

		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			Iterator it = stream.iterator();
			while (it.hasNext()) {
				String line = (String) it.next();
				String[] values = line.split("\\|");
				Log log = new Log(values[0], values[1], values[2], values[3], values[4]);
				dao.saveLog(log);

			}
			loaded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return loaded;

	}

	public void saveBlockLogTimePeriod(Date init, int duration, int qtd) throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.setTime(init);
		if(duration == TypeSeachENUM.HOURLY.val){
			cal.add(Calendar.HOUR_OF_DAY, 1);
		}else{
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.MINUTE, 59);
		}
		List<LogDTO> logs = dao.listar(init, cal.getTime(), qtd);
		for (LogDTO logDTO : logs) {
			Blocked blocked = new Blocked();
			blocked.setIp(logDTO.getIp());
			blocked.setQuantity(logDTO.getCount());
			blocked.setMessage(" Blocked because had too many access: "+qtd);
			
			dao.saveBlocked(blocked);
			
			System.out.println("IP: "+blocked.getIp()+ ", number of requests: "+blocked.getQuantity());
		}
	}

	public Long getNumberRequestsFromIp(String ip) throws Exception {
		return dao.countNumberAccess(ip);
	}

}
