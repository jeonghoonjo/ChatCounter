package edu.handong.csee.java.hw3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class DataReaderForCsv {

	//	private File csvFile = new File("C:\\Users\\jo jeong hoon\\Desktop\\messages\\JavaProgramming-L2.csv");     //get directory path from the Command Line
	
	public static ArrayList<Data> dataList = new ArrayList<Data>(); //static modifier because I want to use ONE dataList
	
	
	
	public DataReaderForCsv() {
		
	}

	public static ArrayList<Data> gettingMessageFromCsvFiles(File file) {	
		
		BufferedReader br;
		
		try {
			
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));

			br.readLine(); //it is just for "Date User Message"

			CSVParser csvParser = new CSVParser(br, CSVFormat.DEFAULT);

			for(CSVRecord csvRecord : csvParser) {
				
				Data data = new Data();
				
				String time = csvRecord.get(0);
				String name = csvRecord.get(1);
				String message = csvRecord.get(2);

				data.setTime(time);
				data.setName(name);
				data.setMessage(message);
				
				dataList.add(data);
				

			}} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
		
		for(Data d : dataList) {
				System.out.println(d.getTime() + " " + d.getName() + " " + d.getMessage());
		}
		
		return dataList;

		
	}


//	public static void main(String[] args) {
//		DataReaderForCsv reader = new DataReaderForCsv();
//
//		
//		reader.gettingMessageFromCsvFiles(file);
//
//
//	}

}