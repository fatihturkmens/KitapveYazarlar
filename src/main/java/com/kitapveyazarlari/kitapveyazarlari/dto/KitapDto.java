package com.kitapveyazarlari.kitapveyazarlari.dto;

import com.kitapveyazarlari.kitapveyazarlari.entity.Yazar;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KitapDto {


    private Long id;

    @NotEmpty(message = "kitap ismi boş bırakılamaz")
    @Size(min = 3,max = 40)
    private String kitapisim;


    @NotEmpty(message = "kitap türü boş bırakılamaz")
    @Size(min = 3,max = 40)
    private String kitaptür;

    private Long sayfasayisi;

    private double fiyat;

    private Yazar yazar;
}
