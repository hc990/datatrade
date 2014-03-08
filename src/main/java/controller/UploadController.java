package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.opensymphony.xwork2.ActionSupport;


public class UploadController extends ActionSupport {

	private static final long serialVersionUID = 1058118154055960372L;

	public String execute() {
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
			writer.write("-------");
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

		setCustomGreeting(picFileName);
		return SUCCESS;
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
