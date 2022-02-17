package com.ems.controller;


import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.ems.conn.PredsUtilException;
import com.ems.model.HallInfo;
import com.ems.service.HallService;
import com.ems.util.PasswordEncrypterUtil;

@Controller
@SessionAttributes("hall")
public class HallController implements ErrorController{

	@Autowired				
	private HallService hallService;
	
	@RequestMapping(value = "/activeHall", method = RequestMethod.GET)
	public String getAllActiveHall(ModelMap model) throws Exception {
		try {
			model.put("allActiveHall", hallService.getAllActiveHall());
			
		} catch (PredsUtilException e) {
			e.printStackTrace();
		} 
		return "./admin/hall";
	}
	
	@RequestMapping(value = "/addActiveHall", method = RequestMethod.GET)
	public String ShowAddHallPage(ModelMap model) throws Exception {
		
		model.put("dropDownCategory", hallService.getDropDownCategory());
		model.put("dropDownCity", hallService.getDropDownCity());
		
		return "./admin/addHall";
	}
	
	
	@RequestMapping(value = "/addActiveHall", method = RequestMethod.POST, consumes = {"multipart/form-data"}) 
	public String addActiveHall(HttpSession session, @ModelAttribute("HallInfo") HallInfo hallInfo, ModelMap model, @RequestParam String hallname, @RequestParam String category, @RequestParam String hallplace, @RequestParam String city, @RequestParam String hallseat, @RequestParam String hallprice, @RequestParam String avl, @RequestParam("file") MultipartFile file) throws Exception, FileNotFoundException {
		try {
		
			    String fileName = file.getOriginalFilename();
	            String imageExtension = fileName.substring(fileName.lastIndexOf(".")+1);
	           
	            if (file.isEmpty()) {

	            	model.put("errorImageFormat", "Please Image Save In jpeg, jpg, png Format");
	            	//session.setAttribute("errorImageFormat", "Please Image Save In jpeg, jpg, png Format");
	                return "redirect:/addActiveHall";
	          
	            }
//	            else if (city.isEmpty()) {
//
//	            	//model.put("errorImageFormat", "Please Image Save In jpeg, jpg, png Format");
//	            	//session.setAttribute("errorImageFormat", "Please Image Save In jpeg, jpg, png Format");
//	                return "redirect:/addActiveHall";
//	          
//	            }
//	            else if (category.isEmpty()) {
//
//	            	//model.put("errorImageFormat", "Please Image Save In jpeg, jpg, png Format");
//	            	//session.setAttribute("errorImageFormat", "Please Image Save In jpeg, jpg, png Format");
//	                return "redirect:/addActiveHall";
//	          
//	            }
	            else if(imageExtension.equalsIgnoreCase("jpeg") || imageExtension.equalsIgnoreCase("jpg") || imageExtension.equalsIgnoreCase("png"))
	            {

				String 	imageName = hallService.uploadFile(file);
				
				hallInfo.setHallId(UUID.randomUUID().toString());
				hallInfo.setHallName(PasswordEncrypterUtil.getInstance().encrypt(hallname));
				hallInfo.setHallCategoryId(category);
				hallInfo.setHallPlace(PasswordEncrypterUtil.getInstance().encrypt(hallplace));
				hallInfo.setHallCityId(city);
				hallInfo.setHallSeat(PasswordEncrypterUtil.getInstance().encrypt(hallseat));
				hallInfo.setHallPrice(PasswordEncrypterUtil.getInstance().encrypt(hallprice));
				hallInfo.setHallAvailability(PasswordEncrypterUtil.getInstance().encrypt(avl));
				hallInfo.setHallImage(PasswordEncrypterUtil.getInstance().encrypt(imageName.trim()));
				
				hallService.addActiveHall(hallInfo);
	            }
	            else {
	            	model.put("errorImageFormat", "Please Image Save In jpeg, jpg, png Format");
	            //	session.setAttribute("errorImageFormat", "Please Image Save In jpeg, jpg, png Format");
	            	return "redirect:/addActiveHall";
	            }
			
			
			//System.out.println("Uploaded: " + file.getOriginalFilename());
			
			
		} catch (PredsUtilException e) {
			e.printStackTrace();
		} 
		return "redirect:/activeHall";
	}

	
	
	@RequestMapping(value = "/editActiveHall", method = RequestMethod.GET)
	public String ShowEditActiveHallPage(HttpSession session, @ModelAttribute("HallInfo") HallInfo hallInfo, ModelMap model , @RequestParam String id,  @RequestParam String catId,  @RequestParam String citId) throws Exception {

		
		hallInfo.setHallId(id);
		hallInfo.setHallCategoryId(catId);
		hallInfo.setHallCityId(citId);
		
		model.put("getHallNameWithParticularId", hallService.getHallNameWithParticularId(hallInfo));
		model.put("dropDownCategory", hallService.getDropDownCategory());
		model.put("dropDownCity", hallService.getDropDownCity());
		return "./admin/editHall";
	}
	
	
	@RequestMapping(value = "/editActiveHall", method = RequestMethod.POST) 
	public String editActiveHall(HttpSession session,@ModelAttribute("HallInfo") HallInfo hallInfo, ModelMap model, @RequestParam String editHallId, @RequestParam String hallname, @RequestParam String category, @RequestParam String hallplace, @RequestParam String city, @RequestParam String hallseat, @RequestParam String hallprice, @RequestParam String avl, @RequestParam("file") MultipartFile file) throws Exception {
		try {
			
			    String fileName = file.getOriginalFilename();
	            String imageExtension = fileName.substring(fileName.lastIndexOf(".")+1);
	            
	            if (file.isEmpty()) {

	            	model.put("errorImageFormat", "Please Image Save In jpeg, jpg, png Format");
	            	//session.setAttribute("errorImageFormat", "Please Image Save In jpeg, jpg, png Format");
	                return "redirect:/editActiveHall";
	          
	            }
	            else if(imageExtension.equalsIgnoreCase("jpeg") || imageExtension.equalsIgnoreCase("jpg") || imageExtension.equalsIgnoreCase("png"))
	            {

				String 	imageName = hallService.uploadFile(file);
			
			hallInfo.setHallId(editHallId);
			hallInfo.setHallName(PasswordEncrypterUtil.getInstance().encrypt(hallname));
			hallInfo.setHallCategoryId(category);
			hallInfo.setHallPlace(PasswordEncrypterUtil.getInstance().encrypt(hallplace));
			hallInfo.setHallCityId(city);
			hallInfo.setHallSeat(PasswordEncrypterUtil.getInstance().encrypt(hallseat));
			hallInfo.setHallPrice(PasswordEncrypterUtil.getInstance().encrypt(hallprice));
			hallInfo.setHallAvailability(PasswordEncrypterUtil.getInstance().encrypt(avl));
			hallInfo.setHallImage(PasswordEncrypterUtil.getInstance().encrypt(imageName.trim()));
			
	            }
	            else {
	            	model.put("errorImageFormat", "Please Image Save In jpeg, jpg, png Format");
	            //	session.setAttribute("errorImageFormat", "Please Image Save In jpeg, jpg, png Format");
	            	return "redirect:/editActiveHall";
	            }
			
			
	            hallService.editActiveHall(hallInfo);
	            
		} catch (PredsUtilException e) {
			e.printStackTrace();
		} 
		return "redirect:/activeHall";
	}
	
	
	
	
	
	@RequestMapping(value = "/showBookedHall", method = RequestMethod.GET)
	public String showBookedHall(ModelMap model) throws Exception {
		try {
			model.put("allBookedHall", hallService.showBookedHall());
			
		} catch (PredsUtilException e) {
			e.printStackTrace();
		} 
		return "./admin/showBookedHall";
	}
	
	
	
	
	@RequestMapping(value = "/activatedHall", method = RequestMethod.GET)
	public String showBookedHallActivated(ModelMap model,@ModelAttribute("HallInfo") HallInfo hallInfo,@RequestParam String id) throws Exception {
		try {
			
			hallInfo.setHallId(id);
			hallService.activatedHall(hallInfo);
			
		} catch (PredsUtilException e) {
			e.printStackTrace();
		} 
		return "redirect:/showBookedHall";
	}
	
	@RequestMapping(value = "/deleteActiveHall", method = RequestMethod.GET)
	public String deleteActiveHall(HttpSession session, ModelMap model , @ModelAttribute("HallInfo") HallInfo hallInfo, @RequestParam String id) throws Exception {
		
		hallInfo.setHallId(id);
		hallService.deleteActiveHall(hallInfo); 
		
		
		return "redirect:/activeHall";
	}
	
	@RequestMapping(value="/events", method = RequestMethod.GET)
	public String showEventsPage(ModelMap model) throws Exception{
		
		model.put("allEventsHall", hallService.getAllEventsHall());
		
		return "events";
	}
	
	
	@RequestMapping(value="/eventsHallDate", method = RequestMethod.GET)
	public String showEventsHallDatePage(HttpSession session, @ModelAttribute("HallInfo") HallInfo hallInfo, ModelMap model, @RequestParam String hallId, @RequestParam String catId , @RequestParam String citId ) throws Exception{
		

         session.setAttribute("ParticularHallID", hallId);
         session.setAttribute("ParticularCategoryID", catId);
         session.setAttribute("ParticularCityID", citId);
		model.put("eventsHallId", hallId);
		
		return "hallDate";
	}
	
	@RequestMapping(value="/eventsHallDateError", method = RequestMethod.GET)
	public String showEventsHallDatePage1(ModelMap model) throws Exception{
		
		//hallInfo.setHallId(id);
		model.put("errorDate", "Please check Arrival and Departure Date ");
		
		return "hallDate";
	}
	
	
	@RequestMapping(value="/hallDetails", method = RequestMethod.GET)
	public String errorEventsHallDetailsPage(ModelMap model) throws Exception{

		return "redirect:/";
	
	}
	
	
	@RequestMapping(value="/hallDetails", method = RequestMethod.POST)
	public String showEventsHallDetailsPage(HttpSession session, @ModelAttribute("HallInfo") HallInfo hallInfo, ModelMap model, @RequestParam String hallId, @RequestParam String catId, @RequestParam String citId, @RequestParam String arr_date, @RequestParam String dep_date  ) throws Exception{
		
	
		 String pattern = "yyyy-MM-dd";
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		 String toDay = simpleDateFormat.format(new Date());
		 
		 // This is for next day of today
		 String firstAndMiddleDatePart =  toDay.substring(0,toDay.lastIndexOf("-")+1);
		 String  lastDatePart = toDay.substring(toDay.lastIndexOf("-")+1);
		 int dayPlus1 = Integer.parseInt(lastDatePart)+1;
		 String dayPlus1String = Integer.toString(dayPlus1);
		 String nextDay = firstAndMiddleDatePart+dayPlus1String;
		// finish for next day of today
		 
		 Date date = simpleDateFormat.parse(nextDay);

		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	      Date arrDatee = sdf.parse(arr_date);
	      Date depDatee = sdf.parse(dep_date);
	        
	        if (arrDatee.compareTo(depDatee) > 0) {
	           return "redirect:/eventsHallDateError";
	        } 
	        else if (date.compareTo(arrDatee) > 0) {
	        	  return "redirect:/eventsHallDateError";
	        } 
	        else if (date.compareTo(depDatee) > 0) {
	        	  return "redirect:/eventsHallDateError";
	        } 
	        else if (arrDatee.compareTo(depDatee) == 0) {
	        	  return "redirect:/eventsHallDateError";
	        }
	        else {
	    	hallInfo.setHallId(hallId);
	    	hallInfo.setHallCategoryId(catId);
	    	hallInfo.setHallCityId(citId);
			hallInfo.setHallArrDate(arr_date);
			hallInfo.setHallDepDate(dep_date);
			
		int arrDate = Integer.parseInt(arr_date.substring(arr_date.lastIndexOf("-")+1));
		int depDate = Integer.parseInt(dep_date.substring(dep_date.lastIndexOf("-")+1));
		int totalDay = Math.abs(depDate - arrDate);
		model.put("totalDay", totalDay);
		
		model.put("eventsHallDetails", hallService.getParticularEventsHall(hallInfo));
	        }
	        session.removeAttribute("ParticularHallID");
	        session.removeAttribute("ParticularCategoryID");
	        session.removeAttribute("ParticularCityID");
		return "hallDetails";
	
	}
	
	
	
	@RequestMapping(value = "/searchHall", method = RequestMethod.POST)
	public String showSearchHallPage(HttpSession session, @ModelAttribute("HallInfo") HallInfo hallInfo, ModelMap model,  @RequestParam String arr_date, @RequestParam String dep_date, @RequestParam String catId, @RequestParam String sch) throws Exception {
		try {
			
			String pattern = "yyyy-MM-dd";
			 SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			 String toDay = simpleDateFormat.format(new Date());
			 
			 // This is for next day of today
			 String firstAndMiddleDatePart =  toDay.substring(0,toDay.lastIndexOf("-")+1);
			 String  lastDatePart = toDay.substring(toDay.lastIndexOf("-")+1);
			 int dayPlus1 = Integer.parseInt(lastDatePart)+1;
			 String dayPlus1String = Integer.toString(dayPlus1);
			 String nextDay = firstAndMiddleDatePart+dayPlus1String;
			// finish for next day of today
			 
			 Date date = simpleDateFormat.parse(nextDay);

			  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		      Date arrDatee = sdf.parse(arr_date);
		      Date depDatee = sdf.parse(dep_date);
		        
		        if (arrDatee.compareTo(depDatee) > 0) {
		           return "redirect:/eventsHallDateErrorBySearch";
		        } 
		        else if (date.compareTo(arrDatee) > 0) {
		        	  return "redirect:/eventsHallDateErrorBySearch";
		        } 
		        else if (date.compareTo(depDatee) > 0) {
		        	  return "redirect:/eventsHallDateErrorBySearch";
		        } 
		        else if (arrDatee.compareTo(depDatee) == 0) {
		        	  return "redirect:/eventsHallDateErrorBySearch";
		        }
		        else {

	    	hallInfo.setHallCategoryId(catId);
	    	hallInfo.setHallName(sch);
			hallInfo.setHallArrDate(arr_date);
			hallInfo.setHallDepDate(dep_date);
		
			model.put("searchHall", hallService.searchHall(hallInfo));
		        }
		} catch (PredsUtilException e) {
			e.printStackTrace();
		} 
		return "searchHall";
	}
	
	@RequestMapping(value="/eventsHallDateErrorBySearch", method = RequestMethod.GET)
	public String eventsHallDateErrorBySearch(ModelMap model) throws Exception{
		
		//hallInfo.setHallId(id);
		//model.put("errorDate", "Please check Arrival and Departure Date ");
		
		return "redirect:/";
	}

	@RequestMapping("/error")
	public String handleError(HttpServletResponse response) {

		if(response.getStatus() == HttpStatus.NOT_FOUND.value()) {
			return "./error/error400";
		}
		else if(response.getStatus() == HttpStatus.FORBIDDEN.value()) {
			return "./error/error403";
		}
		else if(response.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
			return "./error/error500";
		}
		else {
			return "./error/error";
		}

	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
	
}
