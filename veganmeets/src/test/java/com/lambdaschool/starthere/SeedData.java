package com.lambdaschool.starthere;

import com.lambdaschool.veganmeets.models.Role;
import com.lambdaschool.veganmeets.models.User;
import com.lambdaschool.veganmeets.models.UserRoles;
import com.lambdaschool.veganmeets.models.Useremail;
import com.lambdaschool.veganmeets.services.RoleService;
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
    RoleService roleService;

    @Autowired
    UserService userService;


    @Override
    public void run(String[] args) throws Exception
    {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");

        roleService.save(r1);
        roleService.save(r2);
        roleService.save(r3);

        // admin, data, user
        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));
        admins.add(new UserRoles(new User(), r3));
        User u1 = new User("admin", "ILuvM4th!", "admin@email.local", admins);
        u1.getUseremails()
                .add(new Useremail(u1, "admin@email.local"));
        u1.getUseremails()
                .add(new Useremail(u1, "admin@mymail.local"));
        u1 = userService.save(u1);

        // data, user
        ArrayList<UserRoles> datas = new ArrayList<>();
        datas.add(new UserRoles(new User(), r3));
        datas.add(new UserRoles(new User(), r2));
        User u2 = new User("cinnamon", "1234567", "cinnamon@mymail.local", datas);
        u2.getUseremails()
                .add(new Useremail(u2, "cinnamon@mymail.local"));
        u2.getUseremails()
                .add(new Useremail(u2, "hops@mymail.local"));
        u2.getUseremails()
                .add(new Useremail(u2, "bunny@email.local"));
        u2 = userService.save(u2);

        // user
        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r1));
        User u3 = new User("testbarn", "ILuvM4th!", "barnbarn@email.local", users);
        u3.getUseremails()
                .add(new Useremail(u3, "barnbarn@email.local"));
        u3 = userService.save(u3);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u4 = new User("testcat", "password", "barnbarn@email.local", users);
        u4 = userService.save(u4);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u5 = new User("testdog", "password", "barnbarn@email.local", users);
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