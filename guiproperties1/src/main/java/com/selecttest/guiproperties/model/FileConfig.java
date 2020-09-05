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

	@Value( "${Application.seguroGirosDBSID}" )
	String dB_SID = "";
	@Value( "${Application.seguroGirosDBIP}" )
	String dB_IP = "";
	@Value( "${Application.seguroGirosDBPort}" )
	String dB_Port = "";
	@Value( "${Application.seguroGirosDBUserName}" )
	String dB_UserName = "" ; 
	@Value( "${Application.seguroGirosPassword}" )
	String dB_Password = "" ;
	@Value( "${Application.seguroGirosPartitionCount}" )
	String partition_count = "" ;
	@Value( "${Application.seguroGirosMinConnectionsPerPartition}" )
	String min_connectionsPer_partition = "" ;
	@Value( "${Application.seguroGirosMaxConnectionsPerPartition}" )
	String max_connectionsPer_partition = "" ;
	@Value( "${Application.seguroGirosPDFPath}" )
	String pdf_path = "" ;
	@Value( "${Application.adminEmailAddress}" )
	String admin_mails;

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

	//@Value( "${DB_SID}" )
	public void setDB_SID(String db_sid){
		this.dB_SID = db_sid;
	}

	//@Value("${DB_IP}")
	public void setDB_IP(String db_ip){
		this.dB_IP = db_ip;
	}

	//@Value("${DB_PORT}")
	public void setDB_PORT(String db_port){
		this.dB_Port = db_port;
	}
	
	//@Value("${DB_UserName}")
	public void setDB_UserName(String db_username){
		this.dB_UserName = db_username;
	}
	public List<String> getParams(){
		List<String> l = new ArrayList<String>(4);
		l.add(this.dB_SID);
		l.add(this.dB_IP);
		l.add(this.dB_Port);
		l.add(this.dB_UserName);
		l.add(this.dB_Password);
		l.add(this.partition_count);
		l.add(this.min_connectionsPer_partition);
		l.add(this.max_connectionsPer_partition);
		l.add(this.pdf_path);
		l.add(this.admin_mails);
		return l;
	}


}
