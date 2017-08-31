package com.zhiyou100.zy.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Array;
import com.zhiyou100.zy.mapper.courseMapper;
import com.zhiyou100.zy.mapper.speakerMapper;
import com.zhiyou100.zy.mapper.subjectMapper;
import com.zhiyou100.zy.mapper.videoMapper;
import com.zhiyou100.zy.model.Page;
import com.zhiyou100.zy.model.course;
import com.zhiyou100.zy.model.speaker;
import com.zhiyou100.zy.model.subject;
import com.zhiyou100.zy.model.video;
import com.zhiyou100.zy.model.videoExample;
import com.zhiyou100.zy.service.VideoService;
@Service
public class VideoServiceImpl implements VideoService {

	
	@Autowired
   videoMapper vm;
      @Autowired
  courseMapper cm;
   @Autowired
  speakerMapper sm;
   @Autowired   
   subjectMapper sum;
   
	@Override
	public Page<video> findAllVideo(String videoSearchField, String videoSpeaker, String videoCourse, Integer page) {
			Integer startpage=(page-1)*10;
		   List<video> list=vm.findAllVideo(videoSearchField,videoSpeaker,videoCourse,startpage);
		   Page<video> p=new Page<>();
		   p.setRows(list);
		   p.setSize(10);
		   p.setPage(page);
		   p.setTotal(vm.CountAllVideo(videoSearchField, videoSpeaker, videoCourse));
			return p;
	
	}
	public List<course> findAllCourse(){
		
		List<course> courselist = cm.selectByExample(null);
		return courselist;
	}
	public List<speaker> findAllSpeaker(){
		return  sm.selectByExample(null);
		
	}
	@Override
	public void addvideo(video v) {
		vm.insert(v);
		
	}
	@Override
	public video findVideoById(int id) {
		
		 video video = vm.selectByPrimaryKey(id);
		 return video;
	}
	@Override
	public void updateVideo(video v) {
		vm.updateByPrimaryKey(v);
		
	}
	@Override
	public void deletevideo(int id) {
		vm.deleteByPrimaryKey(id);
		
	}
	@Override
	public void deletevideos(Integer[] ids) {
	/*	vm.deleteVideos(ids);*/
		videoExample ve=new videoExample();
		ve.createCriteria().andIdIn(Arrays.asList(ids));
		vm.deleteByExample(ve);
	}
	@Override
	public List<Integer> findAvgPlayTimes() {
		List<Integer> i =vm.findAvgPlayTimes();
		return i;
	}
	@Override
	public subject findSubjectName(int subjectId) {
		subject subject = sum.selectByPrimaryKey(subjectId);
		return subject;
	}
	@Override
	public List<video> findSpeakerAndCourse(int videoId) {
		
		return vm.findSpeakerAndCourse(videoId);
	}
	@Override
	public List<video> findVideoList(int videoId) {
		int courseid=vm.findVideoList(videoId);
         int subjectid=vm.findSubjectId(courseid);
         List<video> li=vm.findVideoBySubjectId(subjectid);
        
		return li;
	}
}
