package com.lambdaschool.veganmeets;

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
        User u1 = new User("admin", "password","admin@email.local", admins);
        u1.getUseremails()
                .add(new Useremail(u1, "admin@email.local"));
        u1.getUseremails()
                .add(new Useremail(u1, "admin@mymail.local"));

        userService.save(u1);

        // data, user
        ArrayList<UserRoles> datas = new ArrayList<>();
        datas.add(new UserRoles(new User(), r3));
        datas.add(new UserRoles(new User(), r2));
        User u2 = new User("cinnamon", "1234567","cinnamon@mymail.local", datas);
        u2.getUseremails()
                .add(new Useremail(u2, "cinnamon@mymail.local"));
        u2.getUseremails()
                .add(new Useremail(u2, "hops@mymail.local"));
        u2.getUseremails()
                .add(new Useremail(u2, "bunny@email.local"));
        userService.save(u2);

        // user
        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u3 = new User("barnbarn", "ILuvM4th!","barnbarn@email.local", users);
        u3.getUseremails()
                .add(new Useremail(u3, "barnbarn@email.local"));
        userService.save(u3);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u4 = new User("Bob", "password","barnbarn@email.local", users);
        userService.save(u4);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u5 = new User("Jane", "password","barnbarn@email.local", users);
        userService.save(u5);
    }
}