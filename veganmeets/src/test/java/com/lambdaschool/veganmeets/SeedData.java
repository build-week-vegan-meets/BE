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
        User u1 = new User("admin", "ILuvM4th!");
        u1.getUseremails()
          .add(new Useremail(u1, "admin@email.local"));
        u1.getUseremails()
          .add(new Useremail(u1, "admin@mymail.local"));
        u1 = userService.save(u1);

        // data, user
        User u2 = new User("cinnamon", "1234567");
        u2.getUseremails()
          .add(new Useremail(u2, "cinnamon@mymail.local"));
        u2.getUseremails()
          .add(new Useremail(u2, "hops@mymail.local"));
        u2.getUseremails()
          .add(new Useremail(u2, "bunny@email.local"));
        u2 = userService.save(u2);

        // user
              User u3 = new User("testbarn", "ILuvM4th!");
        u3.getUseremails()
          .add(new Useremail(u3, "barnbarn@email.local"));
        u3 = userService.save(u3);

        User u4 = new User("testcat", "password");
        u4 = userService.save(u4);

        User u5 = new User("testdog", "password");
        u5 = userService.save(u5);

        System.out.println("\n*** Seed Data ***");
        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);
        System.out.println(u4);
        System.out.println(u5);
        System.out.println("*** Seed Data ***\n");
    }
}