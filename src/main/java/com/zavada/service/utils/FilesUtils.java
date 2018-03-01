package com.zavada.service.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

import com.zavada.entity.User;

public interface FilesUtils {

	static String PROJECT_PATH = System.getProperty("user.dir");
	static String SEPARATOR = System.getProperty("file.separator");
	static String USER_FOLDER = "user_";
	static String ROOT_PATH = PROJECT_PATH + SEPARATOR + "src" + SEPARATOR + "main" + SEPARATOR + "webapp" + SEPARATOR
			+ "upload";

	public static File createFolder(String folderName) {

		File uploadDir = new File(ROOT_PATH);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		File userFolder = new File(uploadDir.getAbsolutePath() + File.separator + folderName);
		if (!userFolder.exists()) {
			userFolder.mkdir();
		}

		return userFolder;
	}

	public static void createUserProfileImage(User user, MultipartFile file) throws IOException {
		if (!file.isEmpty() && file != null) {
			BufferedImage image = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
			File destination = new File(createFolder(USER_FOLDER + user.getId()).getAbsolutePath() + SEPARATOR
					+ file.getOriginalFilename());
			ImageIO.write(image, "png", destination);
		}

	}

	public static String getUserImage(User user) throws IOException {
		File file = null;
		System.out.println("User image: " + user.getUserImage());
		
		if (user.getUserImage() != null && user.getUserImage() != "") {
			file = new File(ROOT_PATH + SEPARATOR + (USER_FOLDER + user.getId()) + SEPARATOR + user.getUserImage());
		} else {
			file = new File(ROOT_PATH + SEPARATOR + "default.png");
		}
		System.out.println(file.getAbsolutePath());
		
		byte[] encodeFileToByte = null;
		String encodedFile = null;
		
		encodeFileToByte = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
		encodedFile = new String(encodeFileToByte);
		
		return encodedFile;
	}

}
