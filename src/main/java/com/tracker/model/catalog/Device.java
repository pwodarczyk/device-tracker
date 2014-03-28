package com.tracker.model.catalog;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="device")
public class Device implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="device_id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name="log_id")
	private CheckOutLog checkOutLog;
	
	@Column(name="name")
	private String name;

	@Column(name="description")
	private String description;

	@Column(name="model")
	private String model;

	@Column(name="version")
	private String version;
	
	@Column(name="qr_code")
	private String qrcode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CheckOutLog getCheckOutLog() {
		return checkOutLog;
	}

	public void setCheckOutLog(CheckOutLog checkOutLog) {
		this.checkOutLog = checkOutLog;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	
}