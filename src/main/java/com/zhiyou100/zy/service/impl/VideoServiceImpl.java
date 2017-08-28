package com.zhiyou100.zy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.zy.mapper.courseMapper;
import com.zhiyou100.zy.mapper.speakerMapper;
import com.zhiyou100.zy.mapper.videoMapper;
import com.zhiyou100.zy.model.Page;
import com.zhiyou100.zy.model.course;
import com.zhiyou100.zy.model.speaker;
import com.zhiyou100.zy.model.video;
import com.zhiyou100.zy.service.VideoService;
@Service
public class VideoServiceImpl implements VideoService {

	
	@Autowired
   videoMapper vm;
      @Autowired
  courseMapper cm;
   @Autowired
  speakerMapper sm;
      
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
	public void deletevideos(int[] ids) {
		vm.deleteVideos(ids);
		
	}
	@Override
	public List<Integer> findAvgPlayTimes() {
		List<Integer> i =vm.findAvgPlayTimes();
		return i;
	}
}
