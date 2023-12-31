package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Sam1", "L", "sam1@mail.com");
        User user2 = new User("Sam2", "LM", "sam2@mail.com");
        User user3 = new User("Sam3", "LMN", "sam3@mail.com");
        User user4 = new User("Sam4", "LMNO", "sam4@mail.com");

        Car car1 = new Car("M", 1);
        Car car2 = new Car("MO", 12);
        Car car3 = new Car("MOD", 123);
        Car car4 = new Car("MODE", 1234);

        userService.add(user1.setCar(car1).setUser(user1));
        userService.add(user2.setCar(car2).setUser(user2));
        userService.add(user3.setCar(car3).setUser(user3));
        userService.add(user4.setCar(car4).setUser(user4));

        for (User user : userService.listUsers()) {
            System.out.println("Name is - " + user.getFirstName() + " " + user.getLastName() + " " + user.getCar());
        }

        System.out.println("----------------------------------------");
        System.out.println("User last name is " + userService.getUserByCar("MOD", 123).getLastName());
        System.out.println("----------------------------------------");

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }
        context.close();
    }
}
