package com.kitapveyazarlari.kitapveyazarlari.repository;

import com.kitapveyazarlari.kitapveyazarlari.dto.KitapDto;
import com.kitapveyazarlari.kitapveyazarlari.entity.Kitap;
import com.kitapveyazarlari.kitapveyazarlari.entity.Yazar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KitapRepository extends JpaRepository<Kitap,Long> {
    public Kitap findByKitapisim(String kitapisim);
    public List <Kitap> findByKitaptür(String kitaptür);
    public List<Kitap> findByYazarAd(String yazar);

}
