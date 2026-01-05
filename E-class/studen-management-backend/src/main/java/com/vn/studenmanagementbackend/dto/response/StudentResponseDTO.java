package com.vn.studenmanagementbackend.dto.response;

import lombok.Data;
import java.time.LocalDate;

@Data
public class StudentResponseDTO {
    private Long id;
    private String code;
    private String fullName;
    private String gender;
    private LocalDate dateOfBirth;
    private String className;
    private String statusName;
    private String parentPhone;
}