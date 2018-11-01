package io.zilehuda.spring.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TopicService {

	
	@Autowired
	private TopicRepository topicreposiroty;
	
	
	public List<Topic> getAllTopics()
	{
		List<Topic> topics = new ArrayList<>();
		topicreposiroty.findAll()
		.forEach(topics::add);
		return topics;
	}
	
	public void addTopic(Topic topic)
	{
		topicreposiroty.save(topic);
	}
	
	
	public Topic getTopic(String id)
	{
		return topicreposiroty.findById(id).get();
	}
	
	
	public void updateTopic(Topic topic)
	{
		topicreposiroty.save(topic);
	}
	public void deleteTopic(String id)
	{
		topicreposiroty.deleteById(id);
	}
}
