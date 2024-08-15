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
		// �Ѽ��ˬd
//		BasicRes checkResult = checkParams(req);
//		if (checkResult != null) {
//			return checkResult;
//		}
		// �ˬd�P�@�ӤH���L���Ƨ벼
		if (responseDao.existsByUserId(req.getUserId())) {
			return new BasicRes(ResMsg.DUPLICATED_FILL_IN.getCode(), //
					ResMsg.DUPLICATED_FILL_IN.getMessage());
		}
		// �p�G�諸id���O�Ū�
		if (StringUtils.hasText(req.getVoteIds())) {
//			// 1. �� voteStr(��ܪ�) �ΡF���ΡA�æs���}�C
			String voteStr = req.getVoteIds();
			String[] voteArray = voteStr.split(";");
//			// 2. ��X�Ҧ����벼����
			List<Vote> allVotes = voteDao.findAll();
			List<Integer> allVotesId = new ArrayList<>();
			for (Vote vote : allVotes) {
				allVotesId.add(vote.getId());
			}
//			// 3. �N��ܶ��ػP�Ҧ����벼���ؤ@�@���
			for (String str : voteArray) {
				Integer voteId = Integer.parseInt(str); // �T�O string �ഫ�� Integer �i����
				if (!allVotesId.contains(voteId)) {
					return new BasicRes(ResMsg.OPTION_IS_NOT_MATCH.getCode(), ResMsg.OPTION_IS_NOT_MATCH.getMessage());
				}
			}
//			// 4. �N�벼���G�s�ܸ�Ʈw
			responseDao.save(new Response(req.getUserName(), req.getUserId(), req.getVoteIds()));
			return new BasicRes(ResMsg.SUCCESS.getCode(), //
					ResMsg.SUCCESS.getMessage());
		}
		// �p�G voteIds �O�Ū�
		return new BasicRes(ResMsg.ANSWER_IS_REQUIRED.getCode(), //
				ResMsg.ANSWER_IS_REQUIRED.getMessage());
	}

//	private BasicRes checkParams(SelectReq req) {
//		// �ˬd���u�s���M�W�r����ť�
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
		// ������벼����
		List<Response> responseList = responseDao.findAll();
		// �M���C�� responseList �H�έp����
		for (Response item : responseList) {
			// �N��ܶ��إΡF���Ψ��ର�}�C
			String selectStr = item.getSelect();
			String[] selectArray = selectStr.split(";");
			// �N�벼���ؤ]�[�W�����A�e��[�W�����O���F���T���ΥX��@�ﶵ
			String voteItem = ";" + req.getVoteId() + ";";
			String selectItem = ";" + selectStr + ";";
			// �p��ﶵ�X�{����
			// �z�L�N�ﶵ�Q�ťը��N�A�o�˥i�H�p��X��֪�����
			String newSelectItem = selectItem.replace(voteItem, "");
			// ������֪����� / ��@�ﶵ���� => �۷���@�ﶵ�X�{������
			int count = (selectItem.length() - newSelectItem.length()) / voteItem.length();
			voteCount += count;
		}
		return new StatisticsRes(ResMsg.SUCCESS.getCode(), //
				ResMsg.SUCCESS.getMessage(), req.getVoteId(), voteCount);
	}

//private List<Vote> strToList(String str){
//	List<Vote> voteList = new ArrayList<>();
//	try {
//		// �N�r��ΡF���j���ର�}�C
//		String[] itemArray = str.split(",");
//		List<Integer> voteIds = new ArrayList<>();
//		// �ର�}�C��[�JList
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
