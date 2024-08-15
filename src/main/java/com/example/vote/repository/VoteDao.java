package com.example.vote.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vote.entity.Vote;

@Repository
public interface VoteDao extends JpaRepository<Vote, Integer> {

	public boolean existsByName(String name);
	
	public List<Vote> findByNameContaining(String name);
	
	public List<Vote> findByIdContaining(int id);
}
