package com.le.ac.project.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="role_func")
public class Role_func {
	@Id
 private int rid;
 private int role;
 @ManyToOne
 @JoinColumn(name="fid")
 //Fecth策略定义
 @Fetch(FetchMode.SELECT)
 private Function function;
 //private Set<Function> function = new HashSet<>();
 //private int fid;
public int getRid() {
	return rid;
}
public void setRid(int rid) {
	this.rid = rid;
}
public int getRole() {
	return role;
}
public void setRole(int role) {
	this.role = role;
}
//public int getFid() {
//	return fid;
//}
//public void setFid(int fid) {
//	this.fid = fid;
//}
//@ManyToMany
//@JoinTable
//public Set<Function> getFunction() {
//	return function;
//}
//public void setFunction(Set<Function> function) {
//	this.function = function;
//}

public Function getFunction() {
	return function;
}
public void setFunction(Function function) {
	this.function = function;
}

 
}
