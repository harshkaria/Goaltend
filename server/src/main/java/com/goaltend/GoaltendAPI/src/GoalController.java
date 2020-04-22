// Goal Controller to Link To Service, Add CORS, Map Requests
package com.goaltend.GoaltendAPI.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/goal")
public class GoalController {
	@Autowired
	GoalService goalService;

	@GetMapping
	public ResponseEntity<?> getAll() {
		List<Goal> result = goalService.findAll();
		return new ResponseEntity(result, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> addOrUpdateGoal(@RequestBody Goal goal) {
		goalService.saveOrUpdateGoal(goal);
		return new ResponseEntity("Goal updated!", HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<?> deleteGoal(@RequestParam("id") String id) {
		goalService.deleteGoal(id);
		return new ResponseEntity("Goal Deleted!", HttpStatus.OK);
	}

	// Gets the GoalID from the path
	@RequestMapping(value = "/getGoal/{goalId}", method = RequestMethod.GET)
	public ResponseEntity<?> findGoal(@PathVariable("goalId") String id) {
		Goal result = goalService.findGoal(id);
		return new ResponseEntity(result, HttpStatus.OK);
	}

	// Gets the sacrifice to
	@RequestMapping(value = "/add/{goalId}/sacrifice", method = RequestMethod.POST)
	public ResponseEntity<?> addSacrifice(@PathVariable("goalId") String id, @RequestBody String sacrifice) {
		// System.out.println(sacrifice);
		goalService.addSacrifice(id, sacrifice);
		return new ResponseEntity("Sacrifice added!", HttpStatus.OK);
	}

	@RequestMapping(value = "/add/{goalId}/reward", method = RequestMethod.POST)
	public ResponseEntity<?> addReward(@PathVariable("goalId") String id, @RequestBody String reward) {
		// System.out.println(reward);
		goalService.addReward(id, reward);
		return new ResponseEntity("Reward added!", HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{goalId}/sacrifice", method = RequestMethod.PUT)
	public ResponseEntity<?> deleteSacrifice(@PathVariable("goalId") String id, @RequestBody String sacrifice) {
		System.out.println(sacrifice);
		goalService.deleteSacrifice(id, sacrifice);
		return new ResponseEntity("Sacrifice Removed", HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{goalId}/reward", method = RequestMethod.PUT)
	public ResponseEntity<?> deleteReward(@PathVariable("goalId") String id, @RequestBody String reward) {
		goalService.deleteReward(id, reward);
		return new ResponseEntity("Reward Removed", HttpStatus.OK);
	}

}
