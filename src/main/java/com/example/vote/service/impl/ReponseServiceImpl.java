package com.example.vote.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.vote.contants.ResMsg;
import com.example.vote.entity.Response;
import com.example.vote.entity.Vote;
import com.example.vote.repository.ResponseDao;
import com.example.vote.repository.VoteDao;
import com.example.vote.service.ifs.ResponseService;
import com.example.vote.vo.BasicRes;
import com.example.vote.vo.Feedback;
import com.example.vote.vo.FeedbackReq;
import com.example.vote.vo.FeedbackRes;
import com.example.vote.vo.SearchRes;
import com.example.vote.vo.SelectReq;
import com.example.vote.vo.StatisticsReq;
import com.example.vote.vo.StatisticsRes;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ReponseServiceImpl implements ResponseService {

	private ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private VoteDao voteDao;
	@Autowired
	private ResponseDao responseDao;

	@Override
	public BasicRes select(SelectReq req) {
		// 參數檢查
//		BasicRes checkResult = checkParams(req);
//		if (checkResult != null) {
//			return checkResult;
//		}
		// 檢查同一個人有無重複投票
		if (responseDao.existsByUserId(req.getUserId())) {
			return new BasicRes(ResMsg.DUPLICATED_FILL_IN.getCode(), //
					ResMsg.DUPLICATED_FILL_IN.getMessage());
		}
		// 如果選的id不是空的
		if (StringUtils.hasText(req.getVoteIds())) {
//			// 1. 把 voteStr(選擇的) 用；切割，並存成陣列
			String voteStr = req.getVoteIds();
			String[] voteArray = voteStr.split(";");
//			// 2. 找出所有的投票項目
			List<Vote> allVotes = voteDao.findAll();
			List<Integer> allVotesId = new ArrayList<>();
			for (Vote vote : allVotes) {
				allVotesId.add(vote.getId());
			}
//			// 3. 將選擇項目與所有的投票項目一一比對
			for (String str : voteArray) {
				Integer voteId = Integer.parseInt(str); // 確保 string 轉換為 Integer 進行比較
				if (!allVotesId.contains(voteId)) {
					return new BasicRes(ResMsg.OPTION_IS_NOT_MATCH.getCode(), ResMsg.OPTION_IS_NOT_MATCH.getMessage());
				}
			}
//			// 4. 將投票結果存至資料庫
			responseDao.save(new Response(req.getUserName(), req.getUserId(), req.getVoteIds()));
			return new BasicRes(ResMsg.SUCCESS.getCode(), //
					ResMsg.SUCCESS.getMessage());
		}
		// 如果 voteIds 是空的
		return new BasicRes(ResMsg.ANSWER_IS_REQUIRED.getCode(), //
				ResMsg.ANSWER_IS_REQUIRED.getMessage());
	}

//	private BasicRes checkParams(SelectReq req) {
//		// 檢查員工編號和名字不能空白
//		if (!StringUtils.hasText(req.getUserName())) {
//			return new BasicRes(ResMsg.PARAM_USERNAME_IS_REQUIRED.getCode(), //
//					ResMsg.PARAM_USERNAME_IS_REQUIRED.getMessage());
//		}
//		if (!StringUtils.hasText(req.getUserId())) {
//			return new BasicRes(ResMsg.PARAM_USERID_IS_REQUIRED.getCode(), //
//					ResMsg.PARAM_USERID_IS_REQUIRED.getMessage());
//		}
//		return null;
//	}

	@Override
	public FeedbackRes feedback(FeedbackReq req) {
		String userName = req.getUserName();
		if (!StringUtils.hasText(userName)) {
			userName = "";
		}
		return new FeedbackRes(ResMsg.SUCCESS.getCode(), //
				ResMsg.SUCCESS.getMessage(), responseDao.findByUserNameContaining(userName));
	}

	@Override
	public StatisticsRes statistics(StatisticsReq req) {
		int voteCount = 0;
		// 抓全部投票紀錄
		List<Response> responseList = responseDao.findAll();
		// 遍歷每個 responseList 以統計次數
		for (Response item : responseList) {
			// 將選擇項目用；切割並轉為陣列
			String selectStr = item.getSelect();
			String[] selectArray = selectStr.split(";");
			// 將投票項目也加上分號，前後加上分號是為了正確切割出單一選項
			String voteItem = ";" + req.getVoteId() + ";";
			String selectItem = ";" + selectStr + ";";
			// 計算選項出現次數
			// 透過將選項被空白取代，這樣可以計算出減少的長度
			String newSelectItem = selectItem.replace(voteItem, "");
			// 全長減少的長度 / 單一選項長度 => 相當於單一選項出現的次數
			int count = (selectItem.length() - newSelectItem.length()) / voteItem.length();
			voteCount += count;
		}
		return new StatisticsRes(ResMsg.SUCCESS.getCode(), //
				ResMsg.SUCCESS.getMessage(), req.getVoteId(), voteCount);
	}

//private List<Vote> strToList(String str){
//	List<Vote> voteList = new ArrayList<>();
//	try {
//		// 將字串用；分隔後轉為陣列
//		String[] itemArray = str.split(",");
//		List<Integer> voteIds = new ArrayList<>();
//		// 轉為陣列後加入List
//		for(String item : itemArray) {
//			voteIds.add(Integer.parseInt(item.trim()));
//		}
//		
//	} catch (Exception e) {
//		// TODO: handle exception
//	}
//}
//
//private List<Vote> findByVoteIds(List<Integer> voteIds){
//	List<Vote> voteList= new ArrayList<>();
//	for(Integer id : voteIds) {
//		Optional<Vote> vote = voteDao.findById(id);
//		voteList.add(vote);
//	}
//}

}
