package com.pb.boot.model.query;

import com.pb.boot.model.domain.User;

public class UserQuery extends User {

    private Integer time;

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}
