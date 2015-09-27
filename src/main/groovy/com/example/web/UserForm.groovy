package com.example.web


import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * Created by Masaya on 15/07/19.
 */
class UserForm {

    @NotNull
    @Size(min = 1, max = 15)
    String userName

    @NotNull
    @Size(min = 1, max = 15)
    String userAddress
}
