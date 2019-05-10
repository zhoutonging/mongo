package com.zhoutong.mongo;

import com.mongodb.client.result.UpdateResult;
import com.zhoutong.mongo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
public class MongoApplication {

    @Autowired
    private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(MongoApplication.class, args);
    }

    /**
     * 查询全部数据
     *
     * @return
     */
    @RequestMapping("findUserList")
    public Map<String, Object> getUserList() {
        Map<String, Object> modelMap = new HashMap<>();

        //collectionName 要查询的集合名称
        List<User> userList = mongoTemplate.findAll(User.class, "shiro");
        modelMap.put("userList", userList);

        return modelMap;
    }

    /**
     * 根据Id查询
     *
     * @param id
     * @return
     */
    @RequestMapping("findUserById")
    public Map<String, Object> getUserByName(String id) {
        Map<String, Object> modelMap = new HashMap<>();

        Query query = new Query(Criteria.where("id").is(id));
        User user = mongoTemplate.findOne(query, User.class,"user");
        modelMap.put("user", user);

        return modelMap;
    }

    /**
     * 更新数据
     *
     * @param user
     * @return
     */
    @RequestMapping("updateFirst")
    public Map<String, Object> updateFirst(User user) {
        Map<String, Object> modelMap = new HashMap<>();

        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update().set("name", user.getName()).set("age", user.getAge());
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, User.class, "shiro");
        modelMap.put("updateResult", updateResult);
        return modelMap;
    }

    /**
     * 添加数据
     *
     * @param user
     * @return
     */
    @RequestMapping("saveUser")
    public Map<String, Object> saveUser(User user) {
        Map<String, Object> modelMap = new HashMap<>();

        mongoTemplate.save(user, "user");

        return modelMap;
    }

}
