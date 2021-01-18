package com.wxt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors
public class Tree {
    private Integer t1Id;
    private String t1Name;
    private Integer t1Pid;
    private Integer t2Id;
    private String t2Name;
    private Integer t2Pid;
    private Integer t3Id;
    private String t3Name;
    private Integer t3Pid;
    private Integer t4Id;
    private String t4Name;
    private Integer t4Pid;
    private Integer t5Id;
    private String t5Name;
    private Integer t5Pid;
    private Integer t6Id;
    private String t6Name;
    private Integer t6Pid;
}
