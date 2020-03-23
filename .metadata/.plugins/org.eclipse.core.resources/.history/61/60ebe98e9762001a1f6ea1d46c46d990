// Goal Data Class
package com.goaltend.GoaltendAPI.src;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Goal {
	@Id
	String id;
	String name;
	String desc;
	List<String> rewards = new ArrayList<String>();
	List<String> sacrifices = new ArrayList<String>();
	
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public String getDesc() {
		return this.desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void addReward(String reward)
	{
		rewards.add(reward);
	}
	public List<String> getRewards()
	{
		return this.rewards;
	}
	public void addSacrifice(String sacrifice)
	{
		sacrifices.add(sacrifice);
	}
	public List<String> getSacrifices()
	{
		return this.sacrifices;
	}
	
}


