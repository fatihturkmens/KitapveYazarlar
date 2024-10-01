package com.kitapveyazarlari.kitapveyazarlari.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YazarDto {
    private Long id;

    @NotEmpty(message = "Yazar ismi boş bırakılamaz")
    @Size(min = 3,max = 40)
    private String ad;

    @NotEmpty(message = "Yazar soy ismi boş bırakılamaz")
    @Size(min = 3,max = 40)
    private String soyisim;

    @NotEmpty(message = "Yazar ülke ismi boş bırakılamaz")
    @Size(min = 3,max = 40)
    private String ülke;
}
