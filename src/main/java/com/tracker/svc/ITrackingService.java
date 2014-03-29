package com.tracker.svc;

import java.util.List;

import com.tracker.model.catalog.CheckOutLog;
import com.tracker.model.catalog.Device;
import com.tracker.model.catalog.DeviceUser;
import com.tracker.model.catalog.Project;

public interface ITrackingService {
	
	public CheckOutLog checkOutDevice(Integer userId , Integer deviceId, Integer projectId);
	public Boolean checkInDevice(Integer logId);
	public Boolean updateUser(DeviceUser user);
	public Boolean updateDevice(Device user);
	public Boolean updateProject(Project user);
	public Device getDeviceById(Integer id);
	public Project getProjectById(Integer id);
	public DeviceUser getDeviceUserById(Integer id);
	public CheckOutLog getCheckOutLogById(Integer id);

	public List<CheckOutLog> getDevicesCheckedOut();
	public List<Device> getDevicesCheckedIn();
	
}