package com.kitapveyazarlari.kitapveyazarlari.service;

import com.kitapveyazarlari.kitapveyazarlari.dto.KitapDto;
import com.kitapveyazarlari.kitapveyazarlari.entity.Kitap;
import com.kitapveyazarlari.kitapveyazarlari.entity.Yazar;

import javax.security.sasl.SaslServer;
import java.util.List;

public interface KitapService {
    public Kitap getById(Long id);
    public List<Kitap> all();
    public String kitapsil(Long id);
    public List<Kitap> findByKitaptür(String kitaptür);
    public Kitap findByKitapisim(String kitapisim);
    public String kitapekle(KitapDto kitapDto);

    public List<Kitap> findByYazarAd(String yazar);

    }
