package kr.or.ddit.util;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtilTest {

	private static final Logger logger = LoggerFactory.getLogger(FileUtilTest.class);
	
	@Test
	public void getFileNameTest() {
		/***Given***/
		String contentDisposition = "form-data; name=\"file\"; filename=\"brown.png\"";

		/***When***/
		String filename = FileUtil.getFileName(contentDisposition);
		logger.debug("filename : {} ",filename);
		
		/***Then***/
		assertEquals("brown.png", filename);
	}

	@Test
	public void getFileNameFailTest() {
		/***Given***/
		String contentDisposition = "form-data; name=\"file\";";

		/***When***/
		String filename = FileUtil.getFileName(contentDisposition);
		logger.debug("filename : {} ", filename);
		
		/***Then***/
		assertEquals("", filename);
	}
	
	@Test
	public void getFileExtensionTest() {
		/***Given***/
		String filename = "brown.png";

		/***When***/
		String extension = FileUtil.getFileExtension(filename);
		
		/***Then***/
		assertEquals(".png", extension);
	}
	
	// 파일이름에 .이 포함되있을 경우
	@Test
	public void getFileExtensionTest2() {
		/***Given***/
		String filename = "line.brown.png";

		/***When***/
		String extension = FileUtil.getFileExtension(filename);
		
		/***Then***/
		assertEquals(".png", extension);
	}
	
	// 확장자가 없는 경우
	@Test
	public void getFileExtensionTest3() {
		/***Given***/
		String filename = "brown";

		/***When***/
		String extension = FileUtil.getFileExtension(filename);
		
		/***Then***/
		assertEquals("", extension);
	}

}
