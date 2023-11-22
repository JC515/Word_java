package com.demo1.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Word {
    private Integer id;
    private String word;
    private String pronunciation;
    private String definition;
}
