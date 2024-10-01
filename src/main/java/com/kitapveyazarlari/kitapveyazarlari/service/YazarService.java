package com.kitapveyazarlari.kitapveyazarlari.service;

import com.kitapveyazarlari.kitapveyazarlari.dto.YazarDto;
import com.kitapveyazarlari.kitapveyazarlari.entity.Kitap;
import com.kitapveyazarlari.kitapveyazarlari.entity.Yazar;

import java.util.List;

public interface YazarService {
    public Yazar getById(Long id);
    public List<Yazar> all();
    public String yazarsil(Long id);
    public String yazarekle(YazarDto yazarDto);
    }
