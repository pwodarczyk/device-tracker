package com.tracker.ws.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tracker.model.catalog.CheckOutLog;
import com.tracker.model.catalog.Device;
import com.tracker.model.catalog.DeviceUser;
import com.tracker.model.catalog.Project;
import com.tracker.model.catalog.Result;
import com.tracker.svc.ITrackingService;

@Controller
@Path(TrackerResource.URL)
public class TrackerResource {

	Log logger = LogFactory.getLog(getClass());

	public static final String URL = "/tracking";

	@Autowired
	private ITrackingService trackingService;

	@POST
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("save-device")
	public Result<Boolean> saveDevice(@QueryParam("id") Integer id, @QueryParam("name") String name, @QueryParam("description") String description,
			@QueryParam("model") String model, @QueryParam("version") String version, @QueryParam("qrcode") String qrcode) {

		Result<Boolean> result = new Result<Boolean>();
		List<Boolean> results = new ArrayList<Boolean>();
		try {
			Device device = null;
			if (id != null) {
				device = trackingService.getDeviceById(id);
			}
			if (device == null) {
				device = new Device();
			}
			device.setName(name);
			device.setDescription(description);
			device.setModel(model);
			device.setQrcode(qrcode);
			device.setVersion(version);
			trackingService.updateDevice(device);
			results.add(true);

		} catch (Exception e) {
			e.printStackTrace();
			results.add(false);
		}
		result.setCount(results.size());
		result.setResults(results);

		if (logger.isDebugEnabled())
			logger.debug(result.toString());
		return result;
		// return null;
	}

	@POST
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("save-user")
	public Result<Boolean> saveDeviceUser(@QueryParam("id") Integer id, @QueryParam("first-name") String firstName,
			@QueryParam("last-name") String lastName, @QueryParam("email") String email, @QueryParam("phone") String phone) {

		Result<Boolean> result = new Result<Boolean>();
		List<Boolean> results = new ArrayList<Boolean>();
		try {
			DeviceUser deviceUser = null;
			if (id != null) {
				deviceUser = trackingService.getDeviceUserById(id);
			}
			if (deviceUser == null) {
				deviceUser = new DeviceUser();
			}
			deviceUser.setFirstName(firstName);
			deviceUser.setLastName(lastName);
			deviceUser.setEmail(email);
			deviceUser.setPhone(phone);
			trackingService.updateUser(deviceUser);
			results.add(true);

		} catch (Exception e) {
			e.printStackTrace();
			results.add(false);
		}
		result.setCount(results.size());
		result.setResults(results);

		if (logger.isDebugEnabled())
			logger.debug(result.toString());
		return result;
		// return null;
	}

	@POST
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("save-project")
	public Result<Boolean> saveProject(@QueryParam("id") Integer id, @QueryParam("name") String name, @QueryParam("description") String description) {

		Result<Boolean> result = new Result<Boolean>();
		List<Boolean> results = new ArrayList<Boolean>();
		try {
			Project project = null;
			if (id != null) {
				project = trackingService.getProjectById(id);
			}
			if (project == null) {
				project = new Project();
			}
			project.setName(name);
			project.setDescription(description);
			trackingService.updateProject(project);
			results.add(true);

		} catch (Exception e) {
			e.printStackTrace();
			results.add(false);
		}
		result.setCount(results.size());
		result.setResults(results);

		if (logger.isDebugEnabled())
			logger.debug(result.toString());
		return result;
	}

	@POST
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("check-out")
	public Result<Boolean> checkOut(@QueryParam("device-id") Integer deviceId, @QueryParam("user-id") Integer userId,
			@QueryParam("project-id") Integer projectId) {
		Result<Boolean> result = new Result<Boolean>();
		List<Boolean> results = new ArrayList<Boolean>();
		try {
			Project project = null;
			if (projectId != null && userId != null && projectId != null) {
				CheckOutLog checkOutLog = trackingService.checkOutDevice(userId, deviceId, projectId);
				if(checkOutLog!=null){
					Device device = trackingService.getDeviceById(deviceId);
					device.setCheckOutLog(checkOutLog);
					results.add(true);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			results.add(false);
		}
		result.setCount(results.size());
		result.setResults(results);

		if (logger.isDebugEnabled())
			logger.debug(result.toString());
		return result;
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("status")
	public Result<Boolean> listBuyersGuide() {
		
		Result<Boolean> result = new Result<Boolean>();
		List<Boolean> results = new ArrayList<Boolean>();
		results.add(true);
		result.setCount(results.size());
		result.setResults(results);
		return result;
			
	}

}
