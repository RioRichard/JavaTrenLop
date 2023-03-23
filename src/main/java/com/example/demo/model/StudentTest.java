package com.example.demo.model;


import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentTest {
    @NotBlank(message = "Không để trống họ và tên!")
    private String name;

    @NotNull(message = "Không để trống điểm!")
    @DecimalMax(value = "10", message = "Điểm tối đa không lớn hơn 10!")
    @DecimalMin(value = "0", message = "Điểm tối thiểu không thấp hơn 0!")
    private Double mark;

    @NotNull(message="Vui lòng chọn chuyên ngành !")
    private String major;
}
