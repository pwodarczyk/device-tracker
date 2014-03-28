package com.tracker.model.catalog;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.CompareToBuilder;

@Entity
@Table(name="check_out_log")
public class CheckOutLog implements Serializable, Comparable<CheckOutLog> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="log_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="device_user_id",insertable=false, updatable=false)
	private DeviceUser deviceUser;
	
	@ManyToOne
	@JoinColumn(name="device_id",insertable=false, updatable=false)
	private Device device;
	
	@ManyToOne
	@JoinColumn(name="project_id",insertable=false, updatable=false)
	private Project project;
	
	@Column(name="check_out")
	private Date checkOut;

	@Column(name="check_in")
	private Date checkIn;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DeviceUser getDeviceUser() {
		return deviceUser;
	}

	public void setDeviceUser(DeviceUser deviceUser) {
		this.deviceUser = deviceUser;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CheckOutLog other = (CheckOutLog) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	public int compareTo(CheckOutLog o) {
		return new CompareToBuilder()
		.append(this.id, o.getId())
		.append(this.checkOut, o.getCheckOut())
		.append(this.checkIn, o.getCheckIn())
		.append(this.device.getId(), o.getDevice().getId())
		.append(this.deviceUser.getId(), o.getDeviceUser().getId())
		.append(this.project.getId(), o.getProject().getId()).toComparison();
	}
}
