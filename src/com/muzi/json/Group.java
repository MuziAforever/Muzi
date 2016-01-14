/**
 * Shanghai Centalinehink.com Inc.
 * Copyright (c) 2015-2015 All Rights Reserved.
 */
package com.muzi.json;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author lizh35
 * @version $Id: Group.java, v 0.1 2015年11月24日 下午2:52:34 lizh35 Exp $
 */
public class Group {

    public Long       id;

    public String     name;

    public List<User> users = new ArrayList<User>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
