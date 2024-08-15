package com.example.vote.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.vote.contants.ResMsg;
import com.example.vote.entity.Vote;
import com.example.vote.repository.VoteDao;
import com.example.vote.service.ifs.VoteService;
import com.example.vote.vo.BasicRes;
import com.example.vote.vo.CreateOrUpdateReq;
import com.example.vote.vo.DeleteReq;
import com.example.vote.vo.SearchReq;
import com.example.vote.vo.SearchRes;

@Service
public class VoteServiceImpl implements VoteService {

	@Autowired
	private VoteDao voteDao;

	@Override
	public BasicRes createOrUpdate(CreateOrUpdateReq req) {
		// �Y req ���� id > 0�A��ܧ�s�w�s�b����ơF�Y id = 0�A�h��ܭn�s�W
		if (req.getId() > 0) {
			if (!voteDao.existsById(req.getId())) { // !boo ��ܸ�Ƥ��s�b�A�i��O�Q�R���� id
				return new BasicRes(ResMsg.UPDATE_ID_NOT_FOUND.getCode(), //
						ResMsg.UPDATE_ID_NOT_FOUND.getMessage());
			}
		}
		if (voteDao.existsByName(req.getName())) {
			return new BasicRes(ResMsg.ITEM_EXISTS.getCode(), //
					ResMsg.ITEM_EXISTS.getMessage());
		}
		voteDao.save(new Vote(req.getId(), req.getName(),req.getIntro()));
		return new BasicRes(ResMsg.SUCCESS.getCode(), //
				ResMsg.SUCCESS.getMessage());
	}

	@Override
	public SearchRes search(SearchReq req) {
		int id = req.getId();
		String name = req.getName();
		if (!StringUtils.hasText(name)) {
			name = "";
		}
		return new SearchRes(ResMsg.SUCCESS.getCode(), //
				ResMsg.SUCCESS.getMessage(), voteDao.findByNameContaining(name));
	}

	@Override
	public BasicRes delete(DeleteReq req) {
		// �ˬd�Ѽ�
		if (!CollectionUtils.isEmpty(req.getIdList())) { // �p�G idList ���O�Ū�
			// �R���ݨ�
			try {
				voteDao.deleteAllById(req.getIdList()); // �N�i�H�i��R���ݨ�
			} catch (Exception e) {
				// �� deleteAllById ��k���Aid ���Ȥ��s�b�ɡAJPA �|����
				// �]���b�R�����e�AJPA �|���j�M�a�J�� id �ȡA�Y�S���G�N�|����
				// �ѩ��ڤW�]�S�R�������ơA�ҥH�N���ݭn��o�� Exception ���B�z
			}
		}
		return new BasicRes(ResMsg.SUCCESS.getCode(), ResMsg.SUCCESS.getMessage()); // �æ^�_���\�T��
	}
}
