package com.vn.studenmanagementbackend.service.impl;

import com.vn.studenmanagementbackend.dto.response.StudentResponseDTO;
import com.vn.studenmanagementbackend.entity.Student;
import com.vn.studenmanagementbackend.repository.StudentRepository;
import com.vn.studenmanagementbackend.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private StudentResponseDTO mapToDTO(Student student) {
        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setId(student.getId());
        dto.setCode(student.getCode());
        dto.setParentPhone(student.getParentPhoneNumber());

        if (student.getProfile() != null) {
            dto.setFullName(student.getProfile().getFullName());
            if (student.getProfile().getGender() != null) {
                dto.setGender(student.getProfile().getGender().name());
            }
            dto.setDateOfBirth(student.getProfile().getDateOfBirth());
        }

        if (student.getSchoolClass() != null) {
            dto.setClassName(student.getSchoolClass().getName());
        }

        if (student.getStatus() != null) {
            dto.setStatusName(student.getStatus().getName());
        }

        return dto;
    }
}