package com.example.RaiseTechTask7;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import java.util.List;

import org.springframework.web.util.UriComponentsBuilder;


@RestController
public class Controller {
    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }

    @GetMapping("/names")
    public List<String> getNames() {
        return List.of("アバン", "ダイ");
    }

    @PostMapping("/names")
    public ResponseEntity<String> create(@RequestBody CreateForm form) {
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/names/id") // id部分は実際に登録された際に発⾏したidを設定する
                .build()
                .toUri();
        return ResponseEntity.created(url).body("name successfully created");
    }

}
