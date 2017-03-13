package com.le.ac.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="function")
public class Function {
@Id
private int fid;
private String name;
private String url;
private int status;
public int getFid() {
	return fid;
}
public void setFid(int fid) {
	this.fid = fid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}

}
