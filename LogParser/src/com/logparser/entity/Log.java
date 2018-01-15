package com.logparser.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity representing each Access Log
 * 
 * @author gustavo.oliveira
 *
 */
@Entity
@Table(name = "full_log")
public class Log implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private Date time;

	private String ip;

	@Column(name = "request_type")
	private String requestType;

	private String status;

	private String agent;
	
	public Log() {
	}

	public Log(String dataInit, String ip, String reqType, String status, String agent) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss", Locale.ENGLISH);
		try {
			time = sdf.parse(dataInit);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.ip = ip;
		this.requestType = reqType;
		this.status = status;
		this.agent = agent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String message) {
		this.agent = message;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
