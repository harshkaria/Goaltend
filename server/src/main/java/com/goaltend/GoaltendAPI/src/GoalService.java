package com.goaltend.GoaltendAPI.src;
import java.util.List;
import java.util.Optional;

public interface GoalService {
	List<Goal> findAll();
	void saveOrUpdateGoal(Goal goal);
	void deleteGoal(String id);
	Goal findGoal(String id);
	void addSacrifice(String id, String sacrifice);
	void addReward(String id, String reward);
	void editSacrifice(String id, String sacrifice, String newSacrifice);
	void editReward(String id, String reward, String newReward);
	void deleteReward(String id, String reward);
	void deleteSacrifice(String id, String sacrifice);

}
