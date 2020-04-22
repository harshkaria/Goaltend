package com.goaltend.GoaltendAPI.src;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalServiceClass implements GoalService {
	@Autowired
	GoalRepository goalRepo;
	
	@Override
	public List<Goal> findAll()
	{
		return goalRepo.findAll();
	}
	
	@Override
	public void saveOrUpdateGoal(Goal goal)
	{
		goalRepo.save(goal);
	}
	
	@Override 
	public void deleteGoal(String id)
	{
		goalRepo.deleteById(id);
	}
	@Override
	public Goal findGoal(String id)
	{
		List<Goal> goals = goalRepo.findAll();
		Goal result = null;
		for(Goal goal : goals)
		{
			if(goal.id.equals(id))
			{
				result = goal;
			}
		}
		return result;
	}
	@Override
	public void addSacrifice(String id, String sacrifice)
	{
		Goal goal = this.findGoal(id);
		goal.sacrifices.add(sacrifice);	
		this.saveOrUpdateGoal(goal);
	}
	@Override
	public void addReward(String id, String reward)
	{
		Goal goal = this.findGoal(id);
		goal.rewards.add(reward);	
		this.saveOrUpdateGoal(goal);
	}
	@Override
	public void editReward(String id, String oldReward, String newReward)
	{
		Goal goal = this.findGoal(id);
		for(String re : goal.rewards)
		{
			// Make the edit
			if(re.equals(oldReward))
			{
				re = newReward;
			}
		}
		this.saveOrUpdateGoal(goal);
	}
	public void editSacrifice(String id, String oldSacrifice, String newSacrifice)
	{
		Goal goal = this.findGoal(id);
		for(String re : goal.sacrifices)
		{
			// Make the edit
			if(re.equals(oldSacrifice))
			{
				re = newSacrifice;
			}
		}
		this.saveOrUpdateGoal(goal);
	}
	public void deleteReward(String id, String reward) 
	{
		Goal goal = this.findGoal(id);
		goal.rewards.remove(reward);
		this.saveOrUpdateGoal(goal);
	}
	public void deleteSacrifice(String id, String sacrifice) 
	{
		Goal goal = this.findGoal(id);
		goal.sacrifices.remove(sacrifice);
		this.saveOrUpdateGoal(goal);
	}
	

	
}
