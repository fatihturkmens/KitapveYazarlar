package com.kitapveyazarlari.kitapveyazarlari.Serviceİmpl;

import com.kitapveyazarlari.kitapveyazarlari.dto.YazarDto;
import com.kitapveyazarlari.kitapveyazarlari.entity.Kitap;
import com.kitapveyazarlari.kitapveyazarlari.entity.Yazar;
import com.kitapveyazarlari.kitapveyazarlari.repository.YazarRepository;
import com.kitapveyazarlari.kitapveyazarlari.service.YazarService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class YazarServiceİmpl implements YazarService {

    @Autowired
    private YazarRepository yazarRepository;


    private String dtomapper(Yazar yazar, YazarDto yazarDto){
        yazar.setId(yazarDto.getId());
        yazar.setAd(yazarDto.getAd());
        yazar.setSoyisim(yazarDto.getSoyisim());
        yazar.setÜlke(yazarDto.getÜlke());
        yazarRepository.save(yazar);

        return "Yazar bilgileri kaydedildi";
    }


    public String yazarekle(YazarDto yazarDto){
        return dtomapper(new Yazar(),yazarDto);
    }



    @Override
    public Yazar getById(Long id) {
       Optional<Yazar> yazar = yazarRepository.findById(id);
       if (yazar.isPresent()){
        return yazar.get();
    }
       else {
           throw new EntityNotFoundException("Yazar bilgileri bulunamadı");
       }

    }

    public List<Yazar> all(){
      return   yazarRepository.findAll();
    }

    @Override
    public String yazarsil(Long id) {
        Optional<Yazar> yazar = yazarRepository.findById(id);
        if (yazar.isPresent()){
            yazarRepository.deleteById(id);
            return "Yazar bilgileri silindi";
        }
        else {
            throw new EntityNotFoundException("Yazar bilgileri bulunamadı");
        }
    }
}
