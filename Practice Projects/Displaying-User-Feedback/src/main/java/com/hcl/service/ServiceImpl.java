package com.hcl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.dao.FeedbackDaoInterface;
import com.hcl.entity.Feedback;



@Service
@Transactional
public class ServiceImpl implements ServiceInterface{
	
	@Autowired
	private FeedbackDaoInterface dao;

	@Override
	public Feedback addFeedback(Feedback fb) {
		return dao.save(fb);
	}
	
	
	

}
