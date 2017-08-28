package com.zhiyou100.zy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.zy.mapper.speakerMapper;
import com.zhiyou100.zy.model.Page;
import com.zhiyou100.zy.model.speaker;
import com.zhiyou100.zy.service.SpeakerService;
@Service
public class SpeakerServiceImpl implements SpeakerService {
@Autowired
	speakerMapper sm;
	
	@Override
	public List<speaker> findAllSpeaker() {
	
		return sm.selectByExample(null);
	}

	@Override
	public Page<speaker> findSpeakerByPage(Integer page,String speakerJob, String speakerName) {
		int page1=(page-1)*10;
		List<speaker> list=sm.findspeakerByPage(page1,speakerJob,speakerName);
		Page<speaker> p=new Page<>();
		p.setRows(list);
		p.setSize(10);
		p.setPage(page);
		p.setTotal(sm.countByExample(null));
		return p;
	}

	@Override
	public void insertspeaker(speaker sp) {
		
		sm.insert(sp);
	}

	@Override
	public speaker speakerById(int id) {
	     speaker speaker = sm.selectByPrimaryKey(id);
		return speaker;
	}

	@Override
	public void updatespeaker(speaker sp) {
		sm.updateByPrimaryKey(sp);
		
	}

	@Override
	public void deletespeaker(int id) {
		
		sm.deleteByPrimaryKey(id);
	}

}
