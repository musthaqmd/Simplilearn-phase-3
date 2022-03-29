package com.hcl.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.entity.Feedback;



@Repository
public interface FeedbackDaoInterface extends CrudRepository<Feedback, Integer>{

}
