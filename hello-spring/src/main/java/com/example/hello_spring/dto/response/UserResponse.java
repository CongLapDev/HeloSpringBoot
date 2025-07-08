package com.example.hello_spring.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class UserResponse {
     long id;
     String username;
     String password;
     String firstname;
     String lastname;
     LocalDate dob;
}
