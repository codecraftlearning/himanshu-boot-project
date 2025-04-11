package com.codecraft.java.models;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private String name;
    private String signature;
    private String email;
}


//request -> controller  -> calls service -> calls repository -> calls DB