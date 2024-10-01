package com.kitapveyazarlari.kitapveyazarlari.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kitap {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String kitapisim;
    private String kitaptür;
    private Long sayfasayisi;

    private double fiyat;

    @ManyToOne
    private Yazar yazar;






}
