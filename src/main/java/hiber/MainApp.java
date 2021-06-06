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

      userService.add(new User("Фёдор","Иванович" ,"us1@mail.ru",new Car("Tesla",25)));
      userService.add(new User("Никита","Никитич" ,"us2@mail.ru",new Car("Lava-kalina",26)));
      userService.add(new User("Антон", "Сергеевич","us3@mail.ru",new Car("Mitsubisi",27)));
      userService.add(new User("Андрей", "Андреев","us4@mail.ru",new Car("Nissan",28)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCarId());
         System.out.println();
      }

      User user = userService.getUserByCar("Lava-kalina", 26);
      System.out.println(user);
      context.close();
   }
}
