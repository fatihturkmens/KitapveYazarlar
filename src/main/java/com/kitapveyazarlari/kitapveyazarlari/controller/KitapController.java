package com.kitapveyazarlari.kitapveyazarlari.controller;

import com.kitapveyazarlari.kitapveyazarlari.dto.KitapDto;
import com.kitapveyazarlari.kitapveyazarlari.entity.Kitap;
import com.kitapveyazarlari.kitapveyazarlari.entity.Yazar;
import com.kitapveyazarlari.kitapveyazarlari.service.KitapService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("kitap")
public class KitapController {

    @Autowired
    private KitapService kitapService;

    @GetMapping("/yazar")
    public ResponseEntity<List<Kitap>> ad(@RequestParam String yazar){
        return new ResponseEntity<>(kitapService.findByYazarAd(yazar),HttpStatus.OK);
    }
    @GetMapping("/kitaptur")
    public ResponseEntity<List<Kitap>> findByKitaptür(@RequestParam String kitaptür){
        List<Kitap> kitapList =kitapService.findByKitaptür(kitaptür);
        return new ResponseEntity<>(kitapList,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Kitap>> all(){
       List<Kitap> all = kitapService.all();
       return new ResponseEntity<>(all, HttpStatus.OK);
    }
    @PostMapping("/kitapekle")
    public ResponseEntity<String>kitapEkle(@RequestBody @Valid KitapDto kitapDto){
       String kitapekle = kitapService.kitapekle(kitapDto);
       return new ResponseEntity<>(kitapekle,HttpStatus.CREATED);
    }

    @GetMapping("/isim")
    public ResponseEntity<Kitap> findByKitapisim(@RequestParam String kitapisim){
       Kitap kitap = kitapService.findByKitapisim(kitapisim);
       return new ResponseEntity<>(kitap,HttpStatus.OK);
    }


    @DeleteMapping("/sil/{id}")
    public ResponseEntity<String> kitapsil(@PathVariable Long id){
        kitapService.kitapsil(id);
        return new ResponseEntity<>("Kitap bilgileri silindi",HttpStatus.OK);
    }
}
