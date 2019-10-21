package com.lambdaschool.veganmeets;

import com.lambdaschool.veganmeets.models.User;
import com.lambdaschool.veganmeets.models.Useremail;
import com.lambdaschool.veganmeets.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    @Autowired
    UserService userService;


    @Override
    public void run(String[] args) throws Exception
    {
        User u1 = new User("admin", "password");
        u1.getUseremails()
          .add(new Useremail(u1, "admin@email.local"));
        u1.getUseremails()
          .add(new Useremail(u1, "admin@mymail.local"));

        userService.save(u1);

        // data, user
        User u2 = new User("cinnamon", "1234567");
        u2.getUseremails()
          .add(new Useremail(u2, "cinnamon@mymail.local"));
        u2.getUseremails()
          .add(new Useremail(u2, "hops@mymail.local"));
        u2.getUseremails()
          .add(new Useremail(u2, "bunny@email.local"));
        userService.save(u2);

        // user
        User u3 = new User("barnbarn", "ILuvM4th!");
        u3.getUseremails()
          .add(new Useremail(u3, "barnbarn@email.local"));
        userService.save(u3);

        User u4 = new User("Bob", "password");
        userService.save(u4);

        User u5 = new User("Jane", "password");
        userService.save(u5);
    }
}