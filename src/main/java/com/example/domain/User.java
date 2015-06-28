package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Masaya on 15/06/28.
 */
@Data
//@AllArgsConstructor
public class User {
    private Integer userId;
    private String userName;
    private String userAddress;

    public User(Integer userId, String userName, String userAddress) {
        this.userId = userId;
        this.userName = userName;
        this.userAddress = userAddress;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserAddress() {
        return this.userAddress;
    }

}
