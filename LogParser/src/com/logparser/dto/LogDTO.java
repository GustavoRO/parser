package com.logparser.dto;

import java.io.Serializable;

/**
 * DTO with the Total of IPs blocked
 * 
 * @author gustavo.oliveira
 *
 */
public class LogDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ip;

	private Long count;

	public LogDTO(String ip, Long count) {
		this.ip = ip;
		this.count = count;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

}
