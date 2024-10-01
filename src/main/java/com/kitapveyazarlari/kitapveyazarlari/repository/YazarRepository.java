package com.kitapveyazarlari.kitapveyazarlari.repository;

import com.kitapveyazarlari.kitapveyazarlari.entity.Kitap;
import com.kitapveyazarlari.kitapveyazarlari.entity.Yazar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface YazarRepository extends JpaRepository<Yazar,Long> {

}
