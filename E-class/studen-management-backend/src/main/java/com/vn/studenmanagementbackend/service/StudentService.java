package com.vn.studenmanagementbackend.service;

import com.vn.studenmanagementbackend.dto.response.StudentResponseDTO;
import java.util.List;

public interface StudentService {
    List<StudentResponseDTO> getAllStudents();
}