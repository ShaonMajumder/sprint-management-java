package backend.controllers;

import backend.exception.ResourceNotFoundException;
import backend.models.Project;
import backend.models.User;
import backend.repository.ProjectRepository;
import backend.repository.UserRepository;
import org.hibernate.SessionFactory;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/projects")
public class ProjectApiController {

	@Autowired
	private ProjectRepository projectRepository;
	private SessionFactory sessionFactory;
	private UserController userController;
	private ProjectController projectController;

	private static final Logger logger = Logger.getLogger(ProjectApiController.class.getName());

	public ProjectApiController(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		this.projectController = new ProjectController(sessionFactory);

		InputStream inputStream = ProjectApiController.class.getClassLoader().getResourceAsStream("logging.properties");
		try {
			LogManager.getLogManager().readConfiguration(inputStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	// get all projects
	@GetMapping
	public List<Project> getAllProjects() {
		return this.projectRepository.findAll();
	}

	// get user by id
	@GetMapping("/{id}")
	public User getUserById(@PathVariable(value = "id") int userId) throws ClassNotFoundException {
		return this.userController.getById(userId);
		// return this.userRepository.findById(userId)
		// .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" +
		// userId));
	}

	// create Project
	@PostMapping
	public int createProject(@RequestBody Project project) {
		project.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		return this.projectController.create(project);
		// return this.userRepository.save(user);
	}


	// update user
	@PutMapping("/{id}")
	public boolean updateUser(@RequestBody User user, @PathVariable("id") int userId) {
		User existingUser = null;
		try {
			existingUser = this.userController.getById(userId);

		} catch (ClassNotFoundException e) {
			throw new ResourceNotFoundException("User not found with id :" + userId);
		}

		logger.info("user passed " + user);
		Field[] fields = User.class.getDeclaredFields();
		for(Field field:fields){
			try {
				field.setAccessible(true); // set the field accessible
				if (field.get(user) != null) {
					if(field.getDeclaredAnnotation(jakarta.persistence.Column.class).updatable()){
						field.set(existingUser, field.get(user));
//						logger.info("update field found" + field.get(user));
					} else {
						logger.info("field " + field.getName() + " is not updatable");
						// then give user input invalid or not allowed message to api response
					}
				}
			} catch (IllegalAccessException e) {
				logger.info("error occurred while getting field value: " + field.getName() );
			}
		}

		return this.userController.updateByNewModel(existingUser);
//		return this.userRepository.save(existingUser);
	}


	// delete user by id
	@DeleteMapping("/{id}")
	public boolean deleteUser(@PathVariable("id") int projectId) throws ClassNotFoundException { // ResponseEntity<User>
		// User existingUser = this.userRepository.findById(userId)
		// .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" +
		// userId));
		// this.userRepository.delete(existingUser);
		// return ResponseEntity.ok().build();
		return this.projectController.delete(projectId);
	}


}
