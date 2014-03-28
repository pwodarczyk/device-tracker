package com.tracker.ws;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CatalogValidator {
	
	static Log logger = LogFactory.getLog(CatalogValidator.class);

	/**
	 * Required to pass
	 * -filter (year/make/model/id)
	 * @param filter
	 * @param groupIds
	 * @return
	 */
//	public static boolean isValidListProductGroups(ApplicationsFilter filter) {
//		boolean isValid = true;
//
//		if(filter.getCategoryId() == 0) {
//			logger.error("isValidSearchProductByPartGroup - invalid id");
//			isValid = false;
//		}
//		if(StringUtils.trimToNull(filter.getYear()) == null) {
//			logger.error("isValidSearchProductByPartGroup - invalid year");
//			isValid = false;
//		}
//		if(StringUtils.trimToNull(filter.getMake()) == null) {
//			logger.error("isValidSearchProductByPartGroup - invalid make");
//			isValid = false;
//		}
//		if(StringUtils.trimToNull(filter.getModel()) == null) {
//			logger.error("isValidSearchProductByPartGroup - invalid model");
//			isValid = false;
//		}
//		
//		
//		return isValid;
//	}
//	
	/**
	 * Required to pass
	 * -filter (year/make/model/id)
	 * -groupIds (not null, at least one)
	 * @param filter
	 * @param groupIds
	 * @return
	 */
//	public static boolean isValidSearchProductByPartGroup(ApplicationsFilter filter, List<String> groupIds) {
//		boolean isValid = true;
//
//		if(filter.getCategoryId() == 0) {
//			logger.error("isValidSearchProductByPartGroup - invalid id");
//			isValid = false;
//		}
//		if(StringUtils.trimToNull(filter.getYear()) == null) {
//			logger.error("isValidSearchProductByPartGroup - invalid year");
//			isValid = false;
//		}
//		if(StringUtils.trimToNull(filter.getMake()) == null) {
//			logger.error("isValidSearchProductByPartGroup - invalid make");
//			isValid = false;
//		}
//		if(StringUtils.trimToNull(filter.getModel()) == null) {
//			logger.error("isValidSearchProductByPartGroup - invalid model");
//			isValid = false;
//		}
//		if(groupIds == null || groupIds.size() == 0) {
//			logger.error("isValidSearchProductByPartGroup - invalid groupIds");
//			isValid = false;
//		}
//		
//		
//		return isValid;
//	}
}
