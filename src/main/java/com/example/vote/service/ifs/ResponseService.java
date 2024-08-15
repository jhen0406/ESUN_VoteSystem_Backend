package com.example.vote.service.ifs;

import com.example.vote.vo.BasicRes;
import com.example.vote.vo.FeedbackReq;
import com.example.vote.vo.FeedbackRes;
import com.example.vote.vo.SelectReq;
import com.example.vote.vo.StatisticsReq;
import com.example.vote.vo.StatisticsRes;

public interface ResponseService {

	public BasicRes select(SelectReq req);
	
	public FeedbackRes feedback(FeedbackReq req);
	
	public StatisticsRes statistics(StatisticsReq req);
}
