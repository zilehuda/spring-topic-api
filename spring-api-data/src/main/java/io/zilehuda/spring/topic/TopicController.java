package io.zilehuda.spring.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicservice;
	
	
	@RequestMapping("/hello")
	public String SayHi()
	{
		return "Hi";
	}
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopic() {
		
		return Arrays.asList(
				new Topic("1","CS","FOR CS"),
				new Topic("1","IPT","FOR CS"),
				new Topic("1","DS","FOR CS")
				);
		
//		return topicservice.getAllTopics();
		
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(String id) {
		
		return topicservice.getTopic(id);
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public void addTopic(@RequestBody Topic topic)
	{
		topicservice.addTopic(topic);
	}

	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic)
	{
		topicservice.updateTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics")
	public void deleteTopic(@PathVariable String id)
	{
		topicservice.deleteTopic(id);
	}

}
