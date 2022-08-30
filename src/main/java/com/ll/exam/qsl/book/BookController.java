package com.ll.exam.qsl.book;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.StandardCharsets;

@RestController
public class BookController {
    private final String TTB_KEY = "ttbjhdl01572144001";
    private final String SEARCH_URL = "https://www.aladin.co.kr/ttb/api/ItemSearch.aspx?&QueryType=Keyword&MaxResults=10&start=1&SearchTarget=Book&output=js&Version=20131101";
    private final String INFO_URL = "https://www.aladin.co.kr/ttb/api/ItemLookUp.aspx?itemIdType=ISBN13&output=js&Version=20131101&OptResult=Toc";

    @GetMapping("book/{keyword}")
    public SearchDto t1(@PathVariable("keyword") String keyword) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<>(new HttpHeaders());
        URI targetUrl = UriComponentsBuilder
                .fromHttpUrl(SEARCH_URL)
                .queryParam("Query", keyword)
                .queryParam("ttbkey", TTB_KEY)
                .build()
                .encode(StandardCharsets.UTF_8)
                .toUri();
        try {
            SearchDto dtoResponseEntity = restTemplate.getForEntity(targetUrl, SearchDto.class).getBody();
            return dtoResponseEntity;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("book/info/{isbn}")
    public BookInfoDto t2(@PathVariable("isbn") String isbn) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<>(new HttpHeaders());
        URI targetUrl = UriComponentsBuilder
                .fromHttpUrl(INFO_URL)
                .queryParam("ItemId", isbn)
                .queryParam("ttbkey", TTB_KEY)
                .build()
                .encode(StandardCharsets.UTF_8)
                .toUri();
        try {
            BookInfoDto bookInfoDto = restTemplate.getForEntity(targetUrl, BookInfoDto.class).getBody();
            parsingString(bookInfoDto.getItem().get(0).subInfo.getToc());
            return bookInfoDto;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void parsingString(String html){
        //System.out.println(html);
        String str=html.replace("<BR>","").replace("<B>","").replace("</B>","");
        System.out.println(str);



    }
}