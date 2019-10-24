package com.lambdaschool.veganmeets.services;

import com.lambdaschool.veganmeets.DAO.MenuDao;
import com.lambdaschool.veganmeets.DAO.ResturantDao;
import com.lambdaschool.veganmeets.models.Menu;
import com.lambdaschool.veganmeets.models.Resturant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MenuService {

    @Autowired
    private MenuDao menuDao;

    public Collection<Menu> getAllMenus(){
        return this.menuDao.getAllMenus();
    }
    public Menu getMenuById(int id){
        return this.menuDao.getMenuById(id);
    }

    public void removeMenuById(int id) {
        this.menuDao.removeMenuById(id);
    }

    public void updateMenu(Menu menu) {
        this.menuDao.updateMenu(menu);
    }

    public void insertMenu(Menu menu) {
        this.menuDao.insertMenutoDB(menu);
    }
}
