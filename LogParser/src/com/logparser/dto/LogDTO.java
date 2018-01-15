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

	private Integer count;

	public LogDTO(String ip, Integer count) {
		this.ip = ip;
		this.count = count;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
