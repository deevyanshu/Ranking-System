package com.deevyanshu.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deevyanshu.Repository.PostRepository;
import com.deevyanshu.entity.Post;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public List<Post> getAll()
	{
		List<Post> list= repository.findAll();
		Collections.sort(list,new Comparator<Post>() {

			@Override
			public int compare(Post o1, Post o2) {
				LocalDate date=LocalDate.now();
				Date date1=o1.getDate();
				Date date2=o2.getDate();
				
				ZoneId defaultZoneId = ZoneId.systemDefault();
				
				//Converting the date to Instant
				Instant instant1 = date1.toInstant();
				Instant instant2= date2.toInstant();
					
				//Converting the Date to LocalDate
				LocalDate localDate1 = instant1.atZone(defaultZoneId).toLocalDate();
				LocalDate localDate2 = instant2.atZone(defaultZoneId).toLocalDate();
				
				Period diff1=Period.between(localDate1, date);
				Period diff2=Period.between(localDate2, date);
				
				int avgD1=diff1.getDays()+(diff1.getMonths()*30)+(diff1.getYears()*365)+1;
				int avgD2=diff2.getDays()+(diff2.getMonths()*30)+(diff2.getYears()*365)+1;
				
				return -( (o1.getPoints()/avgD1)-(o2.getPoints()/avgD2) );
			}
		});
		for(int i=0;i<list.size();i++)
		{
			list.get(i).setPosition(i+1);
		}
		return list;
	}
	
	public Post add(Post post)
	{
		List<Post> list=repository.findAll();
		post.setPosition(list.size()+1);
		return repository.save(post);
	}
	
	public Post addPoints(Post post,int id)
	{
		post.setId(id);
		post.setPoints(post.getPoints()+100);
		return repository.save(post);
	}

}
