package com.zhiyou100.zy.service;

import java.util.List;

import com.zhiyou100.zy.model.Page;
import com.zhiyou100.zy.model.speaker;

public interface SpeakerService {

	List<speaker> findAllSpeaker();

	Page<speaker> findSpeakerByPage(Integer page, String speakerJob, String speakerName);

	void insertspeaker(speaker sp);

	speaker speakerById(int id);

	void updatespeaker(speaker sp);

	void deletespeaker(int id);

}
