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
                put(1, new Menu(1, "Menu Item", "123 address Here", "805-795-7709", "1"));
                put(2, new Menu(2, "Josh's Resturant", "456 address Here", "805-795-7708", "1"));
                put(3, new Menu(3, "Mom's Resturant", "789 address Here", "805-795-7707", "1"));
                put(4, new Menu(4, "Remy's Resturant", "654 address Here", "805-795-7752", "1"));
                put(5, new Menu(5, "Bentley's Resturant", "321 address Here", "805-795-8521", "1"));
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