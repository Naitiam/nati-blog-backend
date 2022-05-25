package com.mine.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Tags {
    private Integer tagnum;
    private String tagname;
    private Integer firsttag;
    private Integer secondtag;
    private Integer thirdtag;
}
