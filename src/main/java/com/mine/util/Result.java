package com.mine.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Result<T> implements Serializable {

    private Integer state;
    private String message;
    private T data;
    public  Result(Integer state, String msg) {
        this.state = state;
        this.message = message;
    }

}
