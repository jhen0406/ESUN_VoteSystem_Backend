package com.example.vote.service.ifs;

import com.example.vote.vo.BasicRes;
import com.example.vote.vo.CreateOrUpdateReq;
import com.example.vote.vo.DeleteReq;
import com.example.vote.vo.SearchReq;
import com.example.vote.vo.SearchRes;

public interface VoteService {

	public BasicRes createOrUpdate(CreateOrUpdateReq req);
	
	public SearchRes search(SearchReq req);

	public BasicRes delete(DeleteReq req);
	
}
