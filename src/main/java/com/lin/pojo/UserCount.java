package com.lin.pojo;

import org.springframework.stereotype.Repository;

@Repository
public class UserCount {
    private Integer Count;

    public UserCount() {
    }

    public UserCount(Integer count) {
        Count = count;
    }

    public Integer getCount() {
        return Count;
    }

    public void setCount(Integer count) {
        Count = count;
    }
}
