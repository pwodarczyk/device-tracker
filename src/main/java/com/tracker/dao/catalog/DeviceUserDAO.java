package com.tracker.dao.catalog;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.tracker.dao.TrackerAbstractHibernateDAO;
import com.tracker.model.catalog.DeviceUser;


public class DeviceUserDAO extends TrackerAbstractHibernateDAO<DeviceUser>{
	
//	private Log logger = LogFactory.getLog(getClass());

	public DeviceUserDAO() {
		super( DeviceUser.class );
	}	

	public List<DeviceUser> listAll(String compPart) throws HibernateException  {
		List<DeviceUser> result = null;
	    Query query = getCurrentSession().createQuery("select * FROM DeviceUser du"); 
	    
	    try {
	    	result = (List<DeviceUser>)query.list();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }

	    return result;
	}
	public DeviceUser saveOrUpdate(DeviceUser user) {
		getCurrentSession().saveOrUpdate(user);
		return user;
	}

}
