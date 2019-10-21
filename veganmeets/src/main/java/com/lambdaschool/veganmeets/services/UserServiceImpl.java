package com.lambdaschool.veganmeets.services;

import com.lambdaschool.veganmeets.exceptions.ResourceFoundException;
import com.lambdaschool.veganmeets.exceptions.ResourceNotFoundException;
import com.lambdaschool.veganmeets.models.User;
import com.lambdaschool.veganmeets.models.Useremail;
import com.lambdaschool.veganmeets.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository userrepos;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userrepos.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), null);
    }

    public User findUserById(long id) throws ResourceNotFoundException {
        return userrepos.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User id " + id + " not found!"));
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userrepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Transactional
    @Override
    public void delete(long id) {
        userrepos.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User id " + id + " not found!"));
        userrepos.deleteById(id);
    }

    @Override
    public User findByName(String name) {
        User uu = userrepos.findByUsername(name);
        if (uu == null) {
            throw new ResourceNotFoundException("User name " + name + " not found!");
        }
        return uu;
    }

    @Transactional
    @Override
    public User save(User user) {
        if (userrepos.findByUsername(user.getUsername()) != null) {
            throw new ResourceFoundException(user.getUsername() + " is already taken!");
        }

        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPasswordNoEncrypt(user.getPassword());


        for (Useremail ue : user.getUseremails()) {
            newUser.getUseremails()
                    .add(new Useremail(newUser, ue.getUseremail()));
        }

        return userrepos.save(newUser);
    }


    @Transactional
    @Override
    public User update(User user, long id, boolean isAdmin) {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        User currentUser = userrepos.findByUsername(authentication.getName());

        if (id == currentUser.getUserid() || isAdmin) {
            if (user.getUsername() != null) {
                currentUser.setUsername(user.getUsername());
            }

            if (user.getPassword() != null) {
                currentUser.setPasswordNoEncrypt(user.getPassword());
            }

            if (user.getUseremails()
                    .size() > 0) {
                for (Useremail ue : user.getUseremails()) {
                    currentUser.getUseremails()
                            .add(new Useremail(currentUser, ue.getUseremail()));
                }
            }

            return userrepos.save(currentUser);
        } else {
            throw new ResourceNotFoundException(id + " Not current user");
        }
    }

    @Transactional
    @Override
    public void deleteUserRole(long userid, long roleid) {
        userrepos.findById(userid)
                .orElseThrow(() -> new ResourceNotFoundException("User id " + userid + " not found!"));
    }

    @Transactional
    @Override
    public void addUserRole(long userid, long roleid) {
        userrepos.findById(userid)
                .orElseThrow(() -> new ResourceNotFoundException("User id " + userid + " not found!"));
    }
}