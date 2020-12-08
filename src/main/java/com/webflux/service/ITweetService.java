package com.webflux.service;

import com.webflux.models.Tweet;
import reactor.core.publisher.Flux;

public interface ITweetService
{
    Flux<Tweet> streamTweets();

    void publishTweet(Tweet tweet);
}
