package com.example.hello_spring.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class UserCreationRequest {
    @Size(min = 3, message = "USERNAME_INVALID")
     String username;
    @Size(min = 8, message = "INVALID_PASSWORD")
     String password;
     String firstname;
     String lastname;
     LocalDate dob;

}
