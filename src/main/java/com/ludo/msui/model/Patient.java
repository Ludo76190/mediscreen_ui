package com.ludo.msui.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Patient {

    private int id;

    @NotBlank(message = "FirstName should not be blank")
    private String firstName;

    @NotBlank(message = "LastName should not be blank")
    private String lastName;

    @NotNull(message = "date of birth is mandatory")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthdate;

    @NotBlank(message = "Sex should not be blank")
    private String sex;

    private String address;
    private String phone;
}
