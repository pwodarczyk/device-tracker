package com.tracker.dao.catalog;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.tracker.dao.TrackerAbstractHibernateDAO;
import com.tracker.model.catalog.CheckOutLog;

public class CheckOutLogDAO extends TrackerAbstractHibernateDAO<CheckOutLog> {

	private Log logger = LogFactory.getLog(getClass());
	public CheckOutLogDAO() {
		super(CheckOutLog.class);
	}

	public CheckOutLog saveOrUpdate(CheckOutLog checkOutLog){
		
		getCurrentSession().save(checkOutLog);
		return checkOutLog;
	}
	
	public List<CheckOutLog> listAllDevicesCheckedOut() throws HibernateException  {
		List<CheckOutLog> result = null;
		StringBuilder sql = new StringBuilder("FROM CheckOutLog ");
		sql.append( " WHERE check_in = null" );
	    Query query = getCurrentSession().createQuery(sql.toString());  
	    
	    try {
	    	result = (List<CheckOutLog>)query.uniqueResult();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }

	    return result;
	}
}
