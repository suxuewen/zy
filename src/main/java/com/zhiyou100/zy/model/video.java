package com.zhiyou100.zy.model;

import java.util.Date;

public class video {
    private Integer id;

    private String videoTitle;

    private Integer speakerId;

    private Integer courseId;

    private Integer videoLength;

    private String videoImageUrl;

    private String videoUrl;

    private String videoDescr;

    private Date insertTime;

    private Date updateTime;
      private String videoLengthStr;
    private Integer videoPlayTimes;
    private speaker spk;
    private course cs;
    private int count;
    
    public String getVideoLengthStr() {
		return videoLengthStr;
	}

	public void setVideoLengthStr(String videoLengthStr) {
		this.videoLengthStr = videoLengthStr;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public speaker getSpk() {
		return spk;
	}

	public void setSpk(speaker spk) {
		this.spk = spk;
	}

	public course getCs() {
		return cs;
	}

	public void setCs(course cs) {
		this.cs = cs;
	}

	

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle == null ? null : videoTitle.trim();
    }

    public Integer getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(Integer speakerId) {
        this.speakerId = speakerId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getVideoLength() {
        return videoLength;
    }

    public void setVideoLength(Integer videoLength) {
        this.videoLength = videoLength;
    }

    public String getVideoImageUrl() {
        return videoImageUrl;
    }

    public void setVideoImageUrl(String videoImageUrl) {
        this.videoImageUrl = videoImageUrl == null ? null : videoImageUrl.trim();
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public String getVideoDescr() {
        return videoDescr;
    }

    public void setVideoDescr(String videoDescr) {
        this.videoDescr = videoDescr == null ? null : videoDescr.trim();
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getVideoPlayTimes() {
        return videoPlayTimes;
    }

    public void setVideoPlayTimes(Integer videoPlayTimes) {
        this.videoPlayTimes = videoPlayTimes;
    }

	@Override
	public String toString() {
		return "video [id=" + id + ", videoTitle=" + videoTitle + ", speakerId=" + speakerId + ", courseId=" + courseId
				+ ", videoLength=" + videoLength + ", videoImageUrl=" + videoImageUrl + ", videoUrl=" + videoUrl
				+ ", videoDescr=" + videoDescr + ", insertTime=" + insertTime + ", updateTime=" + updateTime
				+ ", videoLengthStr=" + videoLengthStr + ", videoPlayTimes=" + videoPlayTimes + ", spk=" + spk + ", cs="
				+ cs + ", count=" + count + "]";
	}

	
    
}