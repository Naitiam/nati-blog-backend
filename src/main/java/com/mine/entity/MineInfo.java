package com.mine.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MineInfo {
    private Integer admnum;
    private String admname;
    private String admpwd;
    private String admphoto;
    private String admintroduction;
    private String admemail;
    private String blogphoto;
    private String token;
}
