package com.ll.exam.qsl.book;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.swing.text.html.HTML;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookInfoDto {
    List<BookInfoDto.Item> item = new ArrayList<>();

    static class Item{
        public String title;
        public String cover;
        public String author;
        public String isbn13;
        public String description;
       public BookInfoDto.subInfo subInfo;
    }
    @Getter
    public static class subInfo{
        @JsonProperty
        String subTitle;
        @JsonProperty
        Integer itemPage;
        @JsonProperty
        String  toc;
    }
}
