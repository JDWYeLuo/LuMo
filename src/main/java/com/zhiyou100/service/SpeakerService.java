package com.zhiyou100.service;

import com.zhiyou100.model.Speaker;
import com.zhiyou100.model.SpeakerRemote;
import com.zhiyou100.util.Page;

public interface SpeakerService {

	Page listPage(SpeakerRemote sr);

	void addSpeaker(Speaker sk);

	void deleteSpeaker(Integer id);

	Speaker updateSpeaker(Integer id);

	void updateSpeakerView(Speaker sk);

	Speaker getSpeaker(Integer speakerId);

}
