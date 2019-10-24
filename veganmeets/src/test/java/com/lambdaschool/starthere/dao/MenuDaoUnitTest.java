package com.lambdaschool.starthere.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.veganmeets.DAO.MenuDao;
import com.lambdaschool.veganmeets.controllers.UserController;
import com.lambdaschool.veganmeets.models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class MenuDaoUnitTest {

// imitating controller to test menu

    Resturant testresturant1;
    MenuDao menuDao;
    Resturant testresturant2;
    int resturantcount;
    Menu testmenuitems1;
    Menu testmenuitems2;
    int menuitemcount;

    @Before
    public void setUp() throws Exception
    {
        menuDao = new MenuDao();
        testresturant1 = new Resturant(2, "Krusty Krab", "Bikini Bottom Lane", "5", "7 to 9");
        testresturant2 = new Resturant(3, "Chum Bucket","Bikini Bottom Way", "6", "6 to 8");
        resturantcount = 2;
        testmenuitems1 = new Menu(1, "Krabby Pattie", "Secret sauce added", "856.00" , "2");
        menuDao.insertMenutoDB(testmenuitems1);
        testmenuitems2 = new Menu(2, "Krusty Pizza", "pizza from the Krusty Krab", "4.99", "2");
        menuDao.insertMenutoDB(testmenuitems2);
        menuitemcount = 5;
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void getAllMenus() throws Exception
    {
        int menuSize = menuDao.getAllMenus().size();
        System.out.println("Expect: " + menuitemcount);
        System.out.println("Actual: " + menuSize);
        assertEquals(menuSize, menuitemcount);
    }

    @Test
    public void getMenuById() throws Exception
    {
        String menuItem = menuDao.getMenuById(1).getName();
        System.out.println("Expect: " + testmenuitems1.getName());
        System.out.println("Actual: " + menuItem);
        assertEquals( menuItem, testmenuitems1.getName());
    }

    @Test
    public void removeMenuById() throws Exception
    {
        menuDao.removeMenuById(2);
        System.out.println("Expect: " + null);
        System.out.println("Actual: " + menuDao.getMenuById(2));
        assertEquals( menuDao.getMenuById(2), null);
    }
}