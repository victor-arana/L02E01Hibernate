package com.victorarana.springmvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.victorarana.springmvc.dto.DTOVideo;

@Component("DAOVideo")
public class DAOVideo implements DAOVideoInterface{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createVideo(DTOVideo video) {
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(video);
		session.getTransaction().commit();
		session.close();		
	}

	@Override
	public DTOVideo retrieveById(Integer videoId) {
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		DTOVideo video = (DTOVideo) session.get(DTOVideo.class, videoId);
		session.getTransaction().commit();
		session.close();		
		
		return video;
	}

	@Override
	public boolean updateVideo(DTOVideo video) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteVideo(DTOVideo video) {
		// TODO Auto-generated method stub
		return false;
	}
}