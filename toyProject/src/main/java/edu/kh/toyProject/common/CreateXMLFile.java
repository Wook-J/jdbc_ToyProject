package edu.kh.toyProject.common;

import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Scanner;

public class CreateXMLFile {

	public static void main(String[] args) {
		
		try {
			Scanner sc = new Scanner(System.in);
			
			// Properties 객체 생성
			// * Properties 는 K:V가 모두 String 으로 제한된 Map * 
			Properties prop = new Properties();
			
			System.out.print("생성할 파일 이름 : ");
			String fileName = sc.next();
			
			// FileOutputStream 생성
			FileOutputStream fos = new FileOutputStream(fileName + ".xml");
			
			// Properties 객체를 이용해서 XML 파일 생성
			prop.storeToXML(fos, fileName +".xml file!!!");
			
			System.out.println(fileName + ".xml 파일 생성 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
