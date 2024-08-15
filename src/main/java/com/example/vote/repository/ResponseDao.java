package com.example.vote.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vote.entity.Response;
import com.example.vote.entity.Vote;
import com.example.vote.vo.Feedback;

@Repository
public interface ResponseDao extends JpaRepository<Response, String> {
	
	public boolean existsByUserId(String userId);

	public List<Response> findByUserNameContaining(String userName);
}
