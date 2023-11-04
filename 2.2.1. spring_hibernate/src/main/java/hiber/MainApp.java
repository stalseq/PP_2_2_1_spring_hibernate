package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) throws SQLException {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User alexandr = new User("Alexandr", "Romanov", "alex@mail.ru");
        User andrei = new User("Andrei", "Volkov", "volkov@mail.ru");
        User oleg = new User("Oleg", "Kabanov", "oleg@mail.ru");
        User vitaliy = new User("Vitaliy", "Belov", "vital@mail.ru");

        Car audi = new Car("audi", 332);
        Car bmw = new Car("bmw", 164);
        Car volvo = new Car("volvo", 582);
        Car volkswagen = new Car("volkswagen", 654);

        userService.add(alexandr.setCar(audi).setUser(alexandr));
        userService.add(andrei.setCar(bmw).setUser(andrei));
        userService.add(oleg.setCar(volvo).setUser(oleg));
        userService.add(vitaliy.setCar(volkswagen).setUser(vitaliy));

        for (User user : userService.listUsers()) {
            System.out.println(user);
        }
        System.out.println(userService.getToCar("bmw", 164));

        context.close();
    }
}
