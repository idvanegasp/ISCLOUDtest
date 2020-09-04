package com.selecttest.guiproperties.model;

import org.springframework.beans.factory.annotation.Value; 
import org.springframework.stereotype.Component;
import java.util.List; 
import java.util.ArrayList; 
//import org.springframework.web.multipart;
//import javax.persistence

@Component 
public class FileConfig {

	String path ="";
	//@Transient
	//MultipartFile file; 

	@Value( "${DB_SID}" )
	String dB_SID = "";
	@Value("${DB_IP}")
	String dB_IP = "";
	@Value("${DB_PORT}")
	String dB_Port = "";
	@Value("${DB_UserName}")
	String dB_UserName = "" ; 
	String dB_Password = "" ;
	String partition_count = "" ;
	String min_connectionsPer_partition = "" ;
	String max_connectionPer_partition = "" ;

	String pdf_path = "" ;

	String[] admin_mails;

	public FileConfig(){}

	public String getDB_SID(){
		return this.dB_SID;
	}

	public String getDB_IP(){
		return this.dB_IP;
	}

	public String getDB_Port(){
		return this.dB_Port;
	}

	public String getDB_UserName(){
		return this.dB_UserName;
	}

	
	public void setDB_SID(String db_sid){
		this.dB_SID = db_sid;
	}

	public List<String> getParams(){
		List<String> l = new ArrayList<String>(4);
		l.add(this.dB_SID);
		l.add(this.dB_IP);
		l.add(this.dB_Port);
		l.add(this.dB_UserName);
		return l;
	}


}
