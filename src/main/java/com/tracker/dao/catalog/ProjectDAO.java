package com.tracker.dao.catalog;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.tracker.dao.TrackerAbstractHibernateDAO;
import com.tracker.model.catalog.DeviceUser;
import com.tracker.model.catalog.Project;

public class ProjectDAO extends TrackerAbstractHibernateDAO<Project> {

	private Log logger = LogFactory.getLog(getClass());
	public ProjectDAO() {
		super(Project.class);
	}
	public Project saveOrUpdate(Project project) {
		getCurrentSession().saveOrUpdate(project);
		return project;
	}
	public List<Project> listAll() throws HibernateException  {
		List<Project> result = null;
	    Query query = getCurrentSession().createQuery("select * FROM Project p"); 
	    
	    try {
	    	result = (List<Project>)query.list();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }

	    return result;
	}
}
