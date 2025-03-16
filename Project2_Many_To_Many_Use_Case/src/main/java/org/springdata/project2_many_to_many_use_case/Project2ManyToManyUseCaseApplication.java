package org.springdata.project2_many_to_many_use_case;

import org.springdata.project2_many_to_many_use_case.entities.Role;
import org.springdata.project2_many_to_many_use_case.entities.User;
import org.springdata.project2_many_to_many_use_case.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.beans.BeanProperty;
import java.util.stream.Stream;

@SpringBootApplication
public class Project2ManyToManyUseCaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project2ManyToManyUseCaseApplication.class, args);
	}

	@Bean
	CommandLineRunner start(UserService userService){
		return args -> {
			User user = new User();
			user.setUserName("user1");
			user.setPassword("1234");
			userService.addNewUser(new user);

			User u2 = new User();
			user.setUserName("admin");
			user.setPassword("1294");
			userService.addNewUser(new u2);

            Stream.of("STUDENT","USER","ADMIN").forEach(r-> {
				Role role = new Role();
				role.setRoleName(r);
				userService.addNewRole(role);
			});
			userService.addRoleToUser("user1","STUDENT");
			userService.addRoleToUser("user1","USER");
			userService.addRoleToUser("admin","USER");
			userService.addRoleToUser("admin","ADMIN");

			try{
				User user = userService.authenticate(user1,123456);
				System.out.println(user.getUserId());
				System.out.println(user.getUsername());
				System.out.println("Roles=>"+r);
				user.getRoles().forEach(r->{
					System.out.println("Role=>"+r);
				});
			}
			catch (Exception e){
				e.printStackTrace();
			}

		};
	}

}
