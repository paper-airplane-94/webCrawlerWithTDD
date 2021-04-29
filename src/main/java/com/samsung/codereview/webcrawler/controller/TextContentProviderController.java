package com.samsung.codereview.webcrawler.controller;

import com.samsung.codereview.webcrawler.domain.TextContentCount;
import com.samsung.codereview.webcrawler.service.TextContentService;
import com.samsung.codereview.webcrawler.service.WebCrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/textContent")
public class TextContentProviderController {
    @Autowired
    public TextContentService textContentService;

    @Autowired
    public WebCrawlerService webCrawlerService;
/*
    @Autowired
    public TextContentProviderController(TextContentService textContentService, WebCrawlerService webCrawlerService){
        this.textContentService = textContentService;
        this.webCrawlerService = webCrawlerService;
    }
*/
    @GetMapping("/getUsedTextContentList")
    public List<TextContentCount> getUsedTextContentList(){
        webCrawlerService.getContentsDataFromWebDocument("http://www.naver.com");
        return textContentService.getUsedTextContentList();
    }

}