package com.le.ac.core.dao;

import org.springframework.stereotype.Repository;

import com.le.ac.core.hibernate.SimpleHibernateDaoImpl;

@Repository("baseDao")
public class BaseDao<T> extends SimpleHibernateDaoImpl<T>{

}
