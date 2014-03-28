package com.tracker.svc.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tracker.dao.catalog.CheckOutLogDAO;
import com.tracker.dao.catalog.DeviceDAO;
import com.tracker.dao.catalog.DeviceUserDAO;
import com.tracker.dao.catalog.ProjectDAO;
import com.tracker.model.catalog.CheckOutLog;
import com.tracker.model.catalog.Device;
import com.tracker.model.catalog.DeviceUser;
import com.tracker.model.catalog.Project;
import com.tracker.svc.ITrackingService;

@Service("trackingService")
@Transactional(propagation = Propagation.REQUIRED)
public class TrackingServiceImpl implements ITrackingService {

	private Log logger = LogFactory.getLog(getClass());

	@Autowired
	public DeviceDAO deviceDAO;
	@Autowired
	public DeviceUserDAO deviceUserDAO;
	@Autowired
	public CheckOutLogDAO checkOutLogDAO;
	@Autowired
	public ProjectDAO projectDAO;

	public Boolean checkOutDevice(Integer userId, Integer deviceId, Integer projectId) {

		try {
			Project project = projectDAO.getById(projectId);
			DeviceUser deviceUser = deviceUserDAO.getById(userId);
			Device device = deviceDAO.getById(deviceId);
			if (device != null && device.getCheckOutLog() != null && deviceUser != null) {
				CheckOutLog col = new CheckOutLog();
				col.setCheckOut(new Date());
				col.setDevice(device);
				col.setProject(project);
				col.setDeviceUser(deviceUser);
				col = checkOutLogDAO.save(col);
				device.setCheckOutLog(col);
				deviceDAO.save(device);
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean checkInDevice(Integer logId) {

		try {
			CheckOutLog col = checkOutLogDAO.getById(logId);

			if (col != null) {
				col.setCheckIn(new Date());
				col = checkOutLogDAO.save(col);
				Device device = col.getDevice();
				device.setCheckOutLog(null);
				deviceDAO.save(device);
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public Boolean updateUser(DeviceUser user) {

		try {
			deviceUserDAO.save(user);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean updateDevice(Device device) {
		
		try {
			deviceDAO.save(device);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean updateProject(Project project) {
		
		try {
			projectDAO.save(project);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<CheckOutLog> getDevicesCheckedOut() {
		
		try {
			List<CheckOutLog> checkOutLogs = checkOutLogDAO.listAllDevicesCheckedOut();
			return checkOutLogs;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Device> getDevicesCheckedIn() {
		
		try {
			List<Device> devices = deviceDAO.listCheckedIn();
			return devices;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
