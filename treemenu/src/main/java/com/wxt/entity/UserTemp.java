package com.wxt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTemp {
    private Integer uId;
    private Integer uPid;
    private String uName;
    private String uNum;
    private String uTele;
    private String uMenuName;
}
