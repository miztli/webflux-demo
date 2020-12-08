package com.webflux.controllers;

import java.util.UUID;
import javax.annotation.Resource;

import com.webflux.models.Tweet;
import com.webflux.service.ITweetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/tweets")
public class TweetController
{
    @Resource
    private ITweetService iTweetService;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tweet> streamTweets()
    {
        return iTweetService.streamTweets().log();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void publishTweet(@RequestBody Tweet tweet)
    {
        iTweetService.publishTweet(tweet);
    }
}
