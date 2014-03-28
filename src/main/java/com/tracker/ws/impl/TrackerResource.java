package com.tracker.ws.impl;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tracker.model.catalog.Result;
import com.tracker.model.catalog.CheckOutLog;
import com.tracker.model.catalog.Device;
import com.tracker.model.catalog.DeviceUser;
import com.tracker.model.catalog.Project;
import com.tracker.svc.ITrackingService;

@Controller
@Path(TrackerResource.URL)
public class TrackerResource {
	
	Log logger = LogFactory.getLog(getClass());

	public static final String URL = "/tracking";

	@Autowired
	private ITrackingService trackingService;

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("filter")
	public Result<Device> findYearMakeModelByType(
			@QueryParam("id") @DefaultValue("20") Integer categoryId,
			@QueryParam("year") String year,
			@QueryParam("make") String make) {
	
//		Result<YearMakeModel> result = new Result<YearMakeModel>();
//		Map<String, String> terms = new HashMap<String, String>();
//		List<YearMakeModel> results = new ArrayList<YearMakeModel>();
//		
//		terms.put("type", categoryId.toString());
//		if(year != null)
//			terms.put("year", year);
//		if(make != null)
//			terms.put("make", make);
//		
//		year = StringUtils.trimToNull(year);
//		make = StringUtils.trimToNull(make);
//		
//		ApplicationsFilter filter = new ApplicationsFilter();
//		filter.setCategoryId(categoryId);
//		filter.setYear(year);
//		filter.setMake(make);
//		
//		if(year == null) {
//			results = catalogService.listYears(filter);
//		} else if(year != null && make == null) {
//			results = catalogService.listMakes(filter);
//		} else if(year != null && make != null) {
//			results = catalogService.listModels(filter);
//		} else {
//			throw new WebApplicationException(Status.BAD_REQUEST);
//		}
//		
//		result.setCount(results.size());
//		result.setTerms(terms);
//		result.setResults(results);
//		
//		if(logger.isDebugEnabled())
//			logger.debug(result.toString());
//		return result;
		return null;
	}	
	

	@GET	
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("part/group")
	public Result<DeviceUser> findPartGroup(
			@QueryParam("id") @DefaultValue("20") Integer categoryId,
			@QueryParam("year") String year,
			@QueryParam("make") String make,
			@QueryParam("model") String model) {

//		Result<ProductGroup> result = new Result<ProductGroup>();
//		Map<String, String> terms = new HashMap<String, String>();
//		List<ProductGroup> results = new ArrayList<ProductGroup>();
//		
//		year = StringUtils.trimToNull(year);
//		make = StringUtils.trimToNull(make);
//		model = StringUtils.trimToNull(model);
//		
//		ApplicationsFilter filter = new ApplicationsFilter();
//		filter.setYear(year);
//		filter.setMake(make);
//		filter.setModel(model);
//		filter.setCategoryId(categoryId);
//
//		terms.put("type", categoryId.toString());
//		terms.put("id", categoryId.toString());
//		terms.put("year", year);
//		terms.put("make", make);
//		terms.put("model", model);
//
//		if(CatalogValidator.isValidListProductGroups(filter)) {
//			results = catalogService.listProductGroups(filter);
//			
//			//We only want to return ProductGroup Objects that have parts associated with them.
//			// So, for each part group for the filter passed we'll check to see if there is a corresponding
//			// possible part.  If so, add it to the result.
//			/*
//			List<ProductGroup> loTmp = catalogService.listProductGroups( filter );
//			for(ProductGroup pg : loTmp) {
//				List<String> groupIds = new ArrayList<String>();
//				groupIds.add( pg.getId() );
//				List<ProductGroup> loTmp2 = productSearchService.searchProductByPartGroup(filter, groupIds);
//				if(loTmp2 != null && loTmp2.size() > 0)
//					results.add( pg );
//			}
//			*/
//		}
//		
//		result.setCount(results.size());
//		result.setTerms(terms);
//		result.setResults(results);
//
//		if(logger.isDebugEnabled())
//			logger.debug(result.toString());
//		
////		long end = System.currentTimeMillis();
////		System.out.println("Request too "+ (end-start)+" ms");
//		return result;

		return null;
	}	

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("part")
	public Result<CheckOutLog> searchPartsByPartGroup(
			@QueryParam("gid") final List<String> groupIds,
			@QueryParam("id") @DefaultValue("20") Integer categoryId,
			@QueryParam("year") String year,
			@QueryParam("make") String make,
			@QueryParam("model") String model) {

//		Result<ProductGroup> result = new Result<ProductGroup>();
//		Map<String, String> terms = new HashMap<String, String>();
//		terms.put("gid", groupIds.toString());
//		
//		year = StringUtils.trimToNull(year);
//		make = StringUtils.trimToNull(make);
//		model = StringUtils.trimToNull(model);
//		
//		ApplicationsFilter filter = new ApplicationsFilter();
//		filter.setYear(year);
//		filter.setMake(make);
//		filter.setModel(model);
//		filter.setCategoryId(categoryId);
//
//		terms.put("type", categoryId.toString());
//		if(year != null)
//			terms.put("year", year);
//		if(make != null)
//			terms.put("make", make);
//		if(model != null)
//			terms.put("model", model);
//
//		List<ProductGroup> results = new ArrayList<ProductGroup>();
//		try {
//			if(CatalogValidator.isValidSearchProductByPartGroup(filter, groupIds))
//				results = trackingService.searchProductByPartGroup(filter, groupIds);
//		}catch(Exception e) {
//			e.printStackTrace();
//			results = new ArrayList<ProductGroup>();
//		}
//		int itemCount = 0;
//		for(ProductGroup pg : results) {
//			itemCount += pg.getDetails().size();
//		}
//		
//		
//		result.setCount(itemCount);
//		result.setTerms(terms);
//		result.setResults(results);
//
//		if(logger.isDebugEnabled())
//			logger.debug(result.toString());
		
		return null;
	}


	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("part/{id}")
	public Result<Project> viewDetail(@PathParam("id") final String xId) {
//		Result<PartDetail> result = new Result<PartDetail>();
//		List<com.brakepartsinc.model.PartImage> images = new ArrayList<com.brakepartsinc.model.PartImage>();
//	
//		Map<String, String> terms = new HashMap<String, String>();
//		terms.put("id", xId);
//		
//		String brandLimit = "Raybestos";
//		
//		DeviceUser pkg = null;
//		Map<String,com.tracker.model.catalog.Project> partDetail = null;
//		try {
//			pkg = trackingService.getProductDetails(xId, brandLimit);
//			if(pkg == null){
//				result.setException("Part Not Found");
//				result.setCount(0);
//				result.setTerms(terms);
//				result.setResults(new ArrayList<PartDetail>());
//				return result;
//			} else { 
//				
//				//Find the part details
//				partDetail = trackingService.getPartDetails( pkg.getPartNumber() );
//				if(partDetail != null) {
//					logger.debug( partDetail.toString() );
//				}
//				//find Images for the part
//				List<PartImage> pkgImages = trackingService.getProductImages(pkg.getPartNumber());
//				String baseImageUrl = ServerUtil.getImageHostName()!=null?ServerUtil.getImageHostName():"";
//				if(pkgImages!=null){
//					for(PartImage img : pkgImages){
//						com.brakepartsinc.model.PartImage image = new com.brakepartsinc.model.PartImage();
//						image.setId( img.getId() );
//						image.setPartNumber( img.getPartNumber() );
//						image.setImageNumber( img.getImageNumber() );
//						image.setView( img.getView() );
//						image.setMain( StringUtils.trimToNull( img.getMainView() )!=null );
//						image.setImageName( img.getImageName() );
//						image.setImageSize( img.getImageSizeType() );
//						image.setUrl( baseImageUrl+img.getImageUrl() );
//						
//						images.add( image );
//					}
//				}
//			}
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		PartDetail detail = new PartDetail();
//		
//		int order = -1;
//		
//		order = processDetail(order, "Part Number", pkg.getPartNumber(), detail );
//		order = processDetail(order, "Brand Name", pkg.getBrand(), detail );
//		order = processDetail(order, "Part Description", pkg.getPartDescription(), detail );
//		
//		if(partDetail != null) {
//			String partType = trackingService.getPartType( pkg.getPartNumber() );
//			List<String> partDetailColumns = trackingService.getPartAttributeColumns( partType );
//			
//			for(String column : partDetailColumns) {
//				order = processDetail(order, column, partDetail, detail );
//			}
//		}
//		
//
//		order = processDetail(order, "Packaged Weight", pkg.getPkgWeight(), detail );
//		order = processDetail(order, "Packaged Length", pkg.getPkgLength(), detail );
//		order = processDetail(order, "Packaged Height", pkg.getPkgHeight(), detail );
//		order = processDetail(order, "Packaged Width", pkg.getPkgWidth(), detail );
//		order = processDetail(order, "Packaged Quantity", "", detail );
//		order = processDetail(order, "Grade Description", StringUtils.trimToEmpty( pkg.getGrade() ), detail );
//		
//		List<PartDetail> results = new ArrayList<PartDetail>();
//		detail.setImages( images );
//
//		results.add(detail);
//		result.setCount(results.size());
//		result.setTerms(terms);
//		result.setResults(results);
//
//		if(logger.isDebugEnabled())
//			logger.debug(result.toString());
//		
//		return result;
		return null;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("buyers")
	public Result<Boolean> listBuyersGuide(@QueryParam("id") final String partNumber) {
//		Result<Makes> result = new Result<Makes>();
//		Map<String, String> terms = new HashMap<String, String>();
//		terms.put("id", partNumber);
//		
//		BuyersGuide results = null;
//		try {
//			results = catalogService.listBuyersGuide(partNumber);
//		}catch(Exception e) {
//			e.printStackTrace();
//			results = new BuyersGuide();
//		}
//
//		result.setTerms(terms);
//		if(results !=null){
//			result.setCount(results.getMakes().size());
//			result.setResults(results.getMakes());
//		}
//		if(logger.isDebugEnabled())
//			logger.debug(result.toString());
//		
//		return result;
		return null;
	}
	

}
