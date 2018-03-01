package com.zavada.service.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.MultipartFile;

import com.zavada.entity.User;

public interface FilesUtils {

	public static File createFolder(String folderName) {
		String rootPath = System.getProperty("user.dir");
		
		File uploadDir = new File(rootPath + File.separator + 
				"src" + File.separator + "main" + File.separator + 
				"webapp" + File.separator + "upload");
		if(!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		
		File userFolder = new File(uploadDir.getAbsolutePath() + File.separator + folderName);
		if(!userFolder.exists()) {
			userFolder.mkdir();
		}
		
		return userFolder;
	}
	
	public static void createUserProfileImage(User user, MultipartFile file) throws IOException {
		if(!file.isEmpty() && file != null) {
			BufferedImage image = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
			File destination = new File(createFolder("user_" + user.getId()).getAbsolutePath() + File.separator + file.getOriginalFilename());
			ImageIO.write(image, "png", destination);
		}
		
	}
	
}
