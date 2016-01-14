/**
 * Shanghai Centalinehink.com Inc.
 * Copyright (c) 2015-2015 All Rights Reserved.
 */
package com.muzi.json;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author lizh35
 * @version $Id: TestJson.java, v 0.1 2015年11月24日 下午2:51:28 lizh35 Exp $
 */
public class TestJson {
    public static void main(String[] args) {
        Group group = new Group();
        group.setId(0L);
        group.setName("admin");

        User guestUser = new User();
        guestUser.setId(2L);
        guestUser.setName("guest");

        User rootUser = new User();
        rootUser.setId(3L);
        rootUser.setName("root");

        group.getUsers().add(guestUser);
        group.getUsers().add(rootUser);
        String jsonString = JSON.toJSONString(group);
        System.out.println(jsonString);

    }

}
