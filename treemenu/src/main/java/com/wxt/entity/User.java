package com.wxt.entity;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors
@Getter
public class User {
    private Integer uId;
    private String uName;
    private Integer qingzhouId;
    private Integer officeId;
    private Integer communityId;
    private Integer buildingId;
    private Integer unitId;
    private Integer locationId;
    private String uNum;
    private String uTele;


}
