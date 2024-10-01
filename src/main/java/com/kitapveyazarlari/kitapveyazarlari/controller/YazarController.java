package com.kitapveyazarlari.kitapveyazarlari.controller;

import com.kitapveyazarlari.kitapveyazarlari.dto.YazarDto;
import com.kitapveyazarlari.kitapveyazarlari.entity.Kitap;
import com.kitapveyazarlari.kitapveyazarlari.entity.Yazar;
import com.kitapveyazarlari.kitapveyazarlari.service.YazarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("yazar")
public class YazarController {

    @Autowired
    private YazarService yazarService;


    @PostMapping("/yazarekle")
    public ResponseEntity<String>yazarEkle(@RequestBody @Valid YazarDto yazarDto){
       String yazarekle= yazarService.yazarekle(yazarDto);
       return new ResponseEntity<>(yazarekle,HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Yazar> byid(@PathVariable Long id){
        Yazar yazar =yazarService.getById(id);
        return new ResponseEntity<>(yazar, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Yazar>> all(){
       List<Yazar> yazarList= yazarService.all();
       return new ResponseEntity<>(yazarList,HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> yazarSilme(@PathVariable Long id){
        yazarService.yazarsil(id);
        return new ResponseEntity<>("Yazar bilgileri silindi",HttpStatus.OK);
    }
}
