package com.zhiyou100.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.SpeakerMapper;
import com.zhiyou100.model.Speaker;
import com.zhiyou100.model.SpeakerExample;
import com.zhiyou100.model.SpeakerRemote;
import com.zhiyou100.service.SpeakerService;
import com.zhiyou100.util.Page;

@Service
public class SpeakerServiceImpl implements SpeakerService {

	@Autowired
	SpeakerMapper sm;

	@Override
	public Page listPage(SpeakerRemote sr) {
		
		
		Page<Speaker> page = new Page<Speaker>();
		/*System.out.println(sm.listcount(sr));*/
		page.setTotal(sm.listcount(sr));
		page.setSize(10);
		page.setPage(sr.getCurrentPage());
		sr.setCurrentPage((sr.getCurrentPage()-1)*10);
		/*System.out.println(sm.listpage(sr));*/
		page.setRows(sm.listpage(sr));
		
		return page;
	}

	@Override
	public void addSpeaker(Speaker sk) {
		
		sm.insertSelective(sk);
	}

	@Override
	public void deleteSpeaker(Integer id) {
		SpeakerExample se = new SpeakerExample();
		
		se.createCriteria().andIdEqualTo(id);
		sm.deleteByExample(se);
	}

	@Override
	public Speaker updateSpeaker(Integer id) {
		
		return sm.selectByPrimaryKey(id);
	}

	@Override
	public void updateSpeakerView(Speaker sk) {
		
		sm.updateByPrimaryKeySelective(sk);
	}

	@Override
	public Speaker getSpeaker(Integer speakerId) {
		
		return sm.selectByPrimaryKey(speakerId);
	}
	
	
	
	
}
