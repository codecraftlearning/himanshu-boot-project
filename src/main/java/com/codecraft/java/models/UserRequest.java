package com.codecraft.java.models;

import lombok.*;


@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private Integer id;
    private String name;
    private String email;
}
