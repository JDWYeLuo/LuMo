package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.model.Course;
import com.zhiyou100.model.Speaker;
import com.zhiyou100.model.Video;
import com.zhiyou100.model.VideoRemote;
import com.zhiyou100.util.Page;

public interface VideoService {

	Page<?> loadPage(VideoRemote vr);

	List<Speaker> findSpeaker();

	List<Course> findCourse();

	List<Video> findVideo();

	void deleteVideo(Integer id);

	void addVideo(Video vd);

	Video updateVideo(Integer id);

	void updateVideoView(Video vd);

	List<Video> findVideoAndCourse();

	void batchDelete(Integer[] checkid);

	void deleteVideoById(Integer id);

	Video getVideo(Integer videoId);

	List<Video> fingVideosBySpeakerId(Integer speakerId);

	void addVideoId(Integer videoId);

}
