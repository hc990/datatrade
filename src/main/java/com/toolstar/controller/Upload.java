package com.toolstar.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.opensymphony.xwork2.ActionSupport;

public class Upload extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String GREETING = "Hello";

	public String execute() {
		 

		/*
		 * Build the custom greeting from the base greeting text and the name
		 * parameter sent in from the form. Set it so that it can be read in the
		 * Result.
		 */

		File pic = getPic();
		try {
            File file = new File("/home/huangchong/"+picFileName);
			br = new BufferedReader(new FileReader(pic));
			writer = new BufferedWriter(new FileWriter(file));
			String s;
			while((s=br.readLine())!=null){  
				writer.write("\n");  
				writer.write(s);  
		    }  
			writer.write("2313213");
			writer.write("231232123213213");
			
			
			
			// FileOutputStream fos = new FileOutputStream(pic);
			// fos.write(new byte[]{1,22,32});
			// fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				br.close();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		setCustomGreeting(GREETING + picFileName);

		/*
		 * Our simplistic busines logic doesn't have any sense of failure, so we
		 * will just return the string we have mapped to our successful result.
		 */

		return "SUCCESS";
	}

	private File pic;

	public File getPic() {
		return pic;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}

	private String customGreeting;

	private BufferedWriter writer;
	private BufferedReader br;

	public String getCustomGreeting() {
		return customGreeting;
	}

	public void setCustomGreeting(String customGreeting) {
		this.customGreeting = customGreeting;
	}

	private String picFileName;

	public String getPicFileName() {
		return picFileName;
	}

	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}

	private String picContentType;

	public String getPicContentType() {
		return picContentType;
	}

	public void setPicContentType(String picContentType) {
		this.picContentType = picContentType;
	}
}
