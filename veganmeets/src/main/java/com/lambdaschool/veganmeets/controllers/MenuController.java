package com.lambdaschool.veganmeets.controllers;

import com.lambdaschool.veganmeets.models.Menu;
import com.lambdaschool.veganmeets.models.Resturant;
import com.lambdaschool.veganmeets.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Menu> getAllMenus(){
        return menuService.getAllMenus();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Menu getMenuById(@PathVariable("id") int id){
        return menuService.getMenuById(id);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deleteMenuById(@PathVariable("id") int id){
        menuService.removeMenuById(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateMenu(@RequestBody Menu menu){
        menuService.updateMenu(menu);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void insertMenu (@RequestBody Menu menu){
        menuService.insertMenu(menu);
    }
}
