package com.platformance.wdt.web.mvc.test.controller;

import com.platformance.wdt.web.mvc.test.domain.Posts;
import com.platformance.wdt.web.mvc.test.domain.PostsRepository;
import com.platformance.wdt.web.mvc.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class MainController {
    @Autowired
    UserService service;

    @Autowired
    PostsRepository postsRepository;

    @GetMapping("add")
    public Posts add(Posts posts) {
        Posts postsData = postsRepository.save(posts);
        return postsData;
    }

    @GetMapping("list")
    public List list() {
        List posts = postsRepository.findAll();
        return posts;
    }

    @GetMapping("test")
    public List<Map<String, Object>> test() {
        List<Map<String, Object>> test =  service.selectTest();
        return test;

        //SpringApplication.run(WdtApplication.class, args);
        // Create a variable for the connection string.
//        String connectionUrl = "jdbc:sqlserver://dbpadinstance.cdpfajomg88b.ap-northeast-2.rds.amazonaws.com:1433;databaseName=DBPAD_DEV_MEMBER;user=myuser;password=1q2w3e4r";
//        String result = "";
//        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
//            String SQL = "SELECT TOP 10 * FROM [DBPAD_DEV_MEMBER].[dbo].[TB_Member_Info]";
//            ResultSet rs = stmt.executeQuery(SQL);
//
//            // Iterate through the data in the result set and display it.
//            while (rs.next()) {
//                result += rs.getString("Member_Number") + " " + rs.getString("ID");
//            }
//        }
//        // Handle any errors that may have occurred.
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return result;
    }
}
