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
		// 若 req 中的 id > 0，表示更新已存在的資料；若 id = 0，則表示要新增
		if (req.getId() > 0) {
			if (!voteDao.existsById(req.getId())) { // !boo 表示資料不存在，可能是被刪掉的 id
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
		// 檢查參數
		if (!CollectionUtils.isEmpty(req.getIdList())) { // 如果 idList 不是空的
			// 刪除問卷
			try {
				voteDao.deleteAllById(req.getIdList()); // 就可以進行刪除問卷
			} catch (Exception e) {
				// 當 deleteAllById 方法中，id 的值不存在時，JPA 會報錯
				// 因為在刪除之前，JPA 會先搜尋帶入的 id 值，若沒結果就會報錯
				// 由於實際上也沒刪除任何資料，所以就不需要對這個 Exception 做處理
			}
		}
		return new BasicRes(ResMsg.SUCCESS.getCode(), ResMsg.SUCCESS.getMessage()); // 並回復成功訊息
	}
}
