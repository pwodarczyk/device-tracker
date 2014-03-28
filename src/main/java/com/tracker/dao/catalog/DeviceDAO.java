package com.tracker.dao.catalog;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.tracker.dao.TrackerAbstractHibernateDAO;
import com.tracker.model.catalog.Device;

@Repository
public class DeviceDAO extends TrackerAbstractHibernateDAO<Device> {

	private Log logger = LogFactory.getLog(getClass());
	public DeviceDAO() {
		super(Device.class);
	}
	public Device save(Device device){
		
		getCurrentSession().saveOrUpdate(device);
		return device;
	}
	public List<Device> listByPoject(Long projectId) {
		List<Device> result = new ArrayList<Device>(0);
	    Query query = getCurrentSession().createQuery("SELECT d FROM device d, check_out_log c WHERE d.device_id = c.device_id AND c.project_id = :id");  
	    query.setParameter("id", projectId); 
	    
	    try {
	    	result = (List<Device>)query.list();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    return result;
	}
	public List<Device> listAll() {
		List<Device> result = new ArrayList<Device>(0);
	    Query query = getCurrentSession().createQuery("SELECT d FROM device d");  
	    
	    try {
	    	result = (List<Device>)query.list();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    return result;
	}public List<Device> listCheckedOut() {
		List<Device> result = new ArrayList<Device>(0);
	    Query query = getCurrentSession().createQuery("SELECT d FROM device d WHERE d.log_id != null");  
	    
	    try {
	    	result = (List<Device>)query.list();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    return result;
	}public List<Device> listCheckedIn() {
		List<Device> result = new ArrayList<Device>(0);
	    Query query = getCurrentSession().createQuery("SELECT d FROM device d WHERE d.log_id == null");  
	    
	    try {
	    	result = (List<Device>)query.list();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    return result;
	}
	
}
