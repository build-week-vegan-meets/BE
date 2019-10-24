package com.lambdaschool.veganmeets.DAO;

import com.lambdaschool.veganmeets.models.Menu;
import org.springframework.stereotype.Repository;

import com.lambdaschool.veganmeets.models.Resturant;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository

public class MenuDao {

    private static Map<Integer, Menu> menus;
    static{
        menus = new HashMap<Integer, Menu>(){
            {
                put(1, new Menu(1, "Menu Item 1", "describe the food", "805", "1"));
                put(2, new Menu(2, "Menu Item 2", "describe the food", "795", "1"));
                put(3, new Menu(3, "Menu Item 3", "describe the food", "707", "1"));
                put(4, new Menu(4, "Menu Item 4", "describe the food", "892", "2"));
                put(5, new Menu(5, "Menu Item 5", "describe the food", "551", "2"));
            }
        };
    }

    public Collection<Menu> getAllMenus(){
        return this.menus.values();
    }
    public Menu getMenuById(int id){
        return this.menus.get(id);
    }

    public void removeMenuById(int id) {
        this.menus.remove(id);
    }

    public void updateMenu(Menu menu) {
        Menu update = menus.get(menu.getId());
        update.setName(menu.getName());
        update.setDescription(menu.getDescription());
        update.setPrice(menu.getPrice());
        update.setResturantid(menu.getResturantid());
        menus.put(menu.getId(), menu);
    }

    public void insertMenutoDB(Menu menu) {
        this.menus.put(menu.getId(), menu);
    }
}