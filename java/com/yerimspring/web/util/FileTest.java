package com.yerimspring.web.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class FileTest {
	public final static String FILE_PATH = "C:\\Users\\bit\\Documents\\workspace-spring-tool-suite-4-4.6.0.RELEASE\\yerimspring\\src\\main\\resources\\static\\member\\";
	public static void main(String[] args) {
		try {
			File file = new File(FILE_PATH + "list.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			BufferedReader reader = new BufferedReader(new FileReader(file));
			List<String> list = new ArrayList<>();
			while(true) {
				switch(JOptionPane.showInputDialog("0.종료    1.쓰기   2.읽기")) {
				case "0" : return;
				case "1" : 
					String messege = JOptionPane.showInputDialog("메세지 입려어어억");
					writer.write(messege);
					writer.newLine();
					writer.flush(); //보내기
					break;
				case "2" :
					while((messege = reader.readLine()) != null) {
						list.add(messege+"/");
					}
					JOptionPane.showMessageDialog(null, list);
					reader.close(); //닫기
					break;
				}
			}
		} catch(Exception e) {
			
		}
	}
}
