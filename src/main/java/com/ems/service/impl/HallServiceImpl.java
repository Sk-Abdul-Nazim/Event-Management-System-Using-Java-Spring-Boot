package com.ems.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ems.Exception.StorageException;
import com.ems.dao.HallDao;
import com.ems.model.CovidModel;
import com.ems.model.DropDownBox;
import com.ems.model.HallInfo;
import com.ems.service.HallService;

@Service
public class HallServiceImpl implements HallService{

	@Autowired
	private HallDao hallDao;
	
	@Override
	public List<HallInfo> getAllActiveHall() throws Exception {
		
		List<HallInfo> hallInfo = hallDao.getAllActiveHall();
		
		return hallInfo;
	}
	
	@Override
	public List<DropDownBox> getDropDownCategory() throws Exception {
		
		List<DropDownBox> dropDownBox = hallDao.getDropDownCategory();
		
		return dropDownBox;
	}
	
	@Override
	public List<DropDownBox> getDropDownCity() throws Exception {
		
		List<DropDownBox> dropDownBox = hallDao.getDropDownCity();
		
		return dropDownBox;
	}
	
	@Override
	public void addActiveHall(HallInfo hallInfo) throws Exception,FileNotFoundException{
		
		boolean c = hallDao.addActiveHall(hallInfo);
	}
	
	@Override
	public void editActiveHall(HallInfo hallInfo) throws Exception{
		
		boolean c = hallDao.editActiveHall(hallInfo);
	}
	
	@Override
	public List<HallInfo> getHallNameWithParticularId(HallInfo hallInfo) throws Exception{
	
		List<HallInfo> particularHallInfo = hallDao.getHallNameWithParticularId(hallInfo);
		
		return particularHallInfo;
	}
	
	@Override
	public void deleteActiveHall(HallInfo hallInfo) throws Exception{
		
		boolean c = hallDao.deleteActiveHall(hallInfo);
	}
	

	@Override
	public List<HallInfo> showBookedHall() throws Exception {
		
		List<HallInfo> hallInfoNot = hallDao.showBookedHall();
		
		return hallInfoNot;
	}
	
	@Override
	public void activatedHall(HallInfo hallInfo) throws Exception{
		
		boolean c = hallDao.activatedHall(hallInfo);
	}
	
	 private String upload_Folder = "E:\\SPRING-BOOT-PROJECTS\\EMS\\src\\main\\resources\\static\\images\\hallImageDB\\";
	//private String upload_Folder = "E:\\UploadHallImage\\";
	
	public String uploadFile(MultipartFile file) {

        

        try {
//                String fileName = file.getOriginalFilename(); 
//                InputStream is = file.getInputStream();
//               
//                Files.copy(is, Paths.get(path1 + fileName),
//                        StandardCopyOption.REPLACE_EXISTING);
//                System.out.println("File Uploaded Successfully");
//                String imageName = fileName;
//                
//                return imageName;
        	
        	
        	byte[] bytes = file.getBytes();
        	Path path = Paths.get(upload_Folder+file.getOriginalFilename());
        	Files.write(path, bytes);
        	
        	return file.getOriginalFilename();

        } catch (IOException e) {

            String msg = String.format("Failed to store file ", file.getName());

            throw new StorageException(msg, e);
        }
        
	}
        
        @Override
    	public List<HallInfo> getAllEventsHall() throws Exception {
    		
    		List<HallInfo> hallInfo = hallDao.getAllEventsHall();
    		
    		return hallInfo;
    	}
    	
    	@Override
    	public List<HallInfo> getParticularEventsHall(HallInfo hallInfo) throws Exception {
    		
    		List<HallInfo> hallInfo1 = hallDao.getParticularEventsHall(hallInfo);
    		
    		return hallInfo1;
    	}
      
    	
    	@Override
    	public List<HallInfo> searchHall(HallInfo hallInfo) throws Exception {
    		
    		List<HallInfo> hallInfo2 = hallDao.searchHall(hallInfo);
    		
    		return hallInfo2;
    	}
    	
    	@Override
    	public int getDoes(String appdate, String vaccine) throws Exception{
    		
    		int c = hallDao.getDoes(appdate,vaccine);
    		return c;
    	}
    	
//    	@Override
//    	public void doesDeduct(int noOfDoes, CovidModel covidModel ) throws Exception{
//    		
//    		boolean c = hallDao.doesDeduct(noOfDoes,covidModel);
//    	}
      
}
