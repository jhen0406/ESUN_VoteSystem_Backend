package com.example.vote.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vote.service.ifs.ResponseService;
import com.example.vote.service.ifs.VoteService;
import com.example.vote.vo.BasicRes;
import com.example.vote.vo.CreateOrUpdateReq;
import com.example.vote.vo.DeleteReq;
import com.example.vote.vo.FeedbackReq;
import com.example.vote.vo.FeedbackRes;
import com.example.vote.vo.SearchReq;
import com.example.vote.vo.SearchRes;
import com.example.vote.vo.SelectReq;
import com.example.vote.vo.StatisticsReq;
import com.example.vote.vo.StatisticsRes;

@CrossOrigin
@RestController
public class VoteController {

	@Autowired
	private VoteService voteService;
	@Autowired
	private ResponseService responseService;

	@PostMapping(value = "vote/create_update")
	public BasicRes createOrUpdate(@Valid @RequestBody CreateOrUpdateReq req) {
		return voteService.createOrUpdate(req);
	}

	@PostMapping(value = "vote/search")
	public SearchRes search(@Valid @RequestBody SearchReq req) {
		return voteService.search(req);
	}

	@PostMapping(value = "vote/delete")
	public BasicRes delete(@Valid @RequestBody DeleteReq req) {
		return voteService.delete(req);
	}

	@PostMapping(value = "vote/select")
	public BasicRes select(@Valid @RequestBody SelectReq req) {
		return responseService.select(req);
	}
	
	@PostMapping(value = "vote/feedback")
	public FeedbackRes feedback(@Valid @RequestBody FeedbackReq req) {
		return responseService.feedback(req);
	}
	
	@PostMapping(value = "vote/statistics")
	public StatisticsRes statistics(@Valid @RequestBody StatisticsReq req) {
		return responseService.statistics(req);
	}
}
