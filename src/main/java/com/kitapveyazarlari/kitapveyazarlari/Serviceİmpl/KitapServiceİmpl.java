package com.kitapveyazarlari.kitapveyazarlari.Serviceİmpl;

import com.kitapveyazarlari.kitapveyazarlari.dto.KitapDto;
import com.kitapveyazarlari.kitapveyazarlari.entity.Kitap;
import com.kitapveyazarlari.kitapveyazarlari.entity.Yazar;
import com.kitapveyazarlari.kitapveyazarlari.repository.KitapRepository;
import com.kitapveyazarlari.kitapveyazarlari.service.KitapService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KitapServiceİmpl implements KitapService{

    @Autowired
    private KitapRepository kitapRepository;


    private String dtomapper(Kitap kitap, KitapDto kitapDto){
        kitap.setId(kitapDto.getId());
        kitap.setKitapisim(kitapDto.getKitapisim());
        kitap.setKitaptür(kitapDto.getKitaptür());
        kitap.setSayfasayisi(kitapDto.getSayfasayisi());
        kitap.setFiyat(kitapDto.getFiyat());
        kitap.setYazar(kitapDto.getYazar());
        kitapRepository.save(kitap);

        return "Kitap bilgileri kaydedildi";

    }
     public String kitapekle(KitapDto kitapDto){
       return dtomapper(new Kitap(),kitapDto);
     }
    public Kitap getById(Long id){
        Optional<Kitap> kitap=kitapRepository.findById(id);

        if (kitap.isPresent()){
            return kitap.get();
        }
        else {
            throw new EntityNotFoundException("Kitap bilgileri bulunamadı");
        }
    }
    public List<Kitap> findByYazarAd(String yazar){
        return kitapRepository.findByYazarAd(yazar);
    }
    public List<Kitap> all(){

        return kitapRepository.findAll();
    }
    public Kitap findByKitapisim(String kitapisim){
       return kitapRepository.findByKitapisim(kitapisim);
    }
    public List<Kitap> findByKitaptür(String kitaptür){
        return kitapRepository.findByKitaptür(kitaptür);
    }
    public String kitapsil(Long id){
       Optional<Kitap> kitap = kitapRepository.findById(id);
       if (kitap.isPresent()){
           kitapRepository.deleteById(id);
           return "Kitap bilgisi silindi";
       }
       else {
           throw new EntityNotFoundException("Kitap bilgisi bulunamadı");
       }
    }
}
