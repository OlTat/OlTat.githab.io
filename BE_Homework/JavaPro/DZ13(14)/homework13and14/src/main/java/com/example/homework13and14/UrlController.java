package com.example.homework13and14;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;
import java.util.List;

@Controller
public class UrlController {
    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/")
    public String index(){

        return "index";
    }

    @PostMapping("/add_url")
    public String shorten(@RequestParam("add_url") String url,
                          Model model) {
        long id = urlService.saveUrl(url);

        var result = new UrlResultDTO();
        result.setUrl(url);
        result.setShortUrl(Long.toString(id));

        model.addAttribute("result", "http://localhost:8080/my/" + id);

        return "result";
    }

    @GetMapping("my/{id}")
    public ResponseEntity<Void> redirect(@PathVariable("id") Long id) {
        var url = urlService.getUrl(id);

        var headers = new HttpHeaders();
        headers.setLocation(URI.create(url));
        headers.setCacheControl("no-cache, no-store, must-revalidate");

        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }

    @PostMapping("/delete_url")
    public String deleteUrl(@RequestParam("delete_url") Long id,
                            Model model){
        var url = urlService.getUrl(id);
        if (url == null){
            model.addAttribute("result", "Такой ссылки нету!");
            return "result";
        }
        urlService.deleteUrl(id);

        model.addAttribute("result", "Короткая ссылка для: '" + url + "' была удалена!");

        return "result";
    }

    @GetMapping("stat")
    public List<UrlStatDTO> stat() {
        return urlService.getStatistics();
    }
}
