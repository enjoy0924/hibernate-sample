package com.allere.hibernate;

import com.allere.hibernate.entity.Group;
import com.allere.hibernate.utils.JacksonJsonUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by G_dragon on 2015/8/17.
 */
public class JsonUtil {

    class Contact {
        @JsonCreator
        public Contact() {
        }
        public String phone;
        public String email;
    }
    class User {
        @JsonCreator
        public User() {
        }
        public Long id;
        public String name;
        public Contact contact;
    }
    class Group {
        @JsonCreator
        public Group() {
        }

        public Long id;
        public String name;
        public List<User> users = new ArrayList<User>();
    }


    @Test
    public void contactTest() throws Exception {
        Contact contact = new Contact();
        contact.phone = "1234567989";
        contact.email = "12456@qq.com";

        User user = new User();
        user.contact = contact;
        user.id = 1l;
        user.name = "tom";

        Group group = new Group();
        group.id = 2l;
        group.name = "group";
        group.users.add(user);

        /** 多级嵌套转换成json串没有问题 */
        String json = JacksonJsonUtil.beanToJson(group);
        //String json = JSON.toJSONString(group);
        System.out.println("Json = " + json);

        Group g = JacksonJsonUtil.jsonToBean(json, Group.class, true);
//        group = JSON.parseObject(json, Group.class);
        System.out.println("group.name = " + group.users.get(0).id);
    }


}
