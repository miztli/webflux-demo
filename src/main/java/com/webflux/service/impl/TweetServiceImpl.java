package com.webflux.service.impl;

import java.util.UUID;
import java.util.function.Consumer;

import com.webflux.models.Tweet;
import com.webflux.service.ITweetService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class TweetServiceImpl implements ITweetService
{
    private Consumer<Tweet> emitter;

    private Flux<Tweet> tweetsSource = Flux.<Tweet>create(sink -> this.emitter = tweet -> sink.next(tweet))
        .share()
        .cache(5);

    @Override
    public Flux<Tweet> streamTweets()
    {
        return Flux.from(tweetsSource);
    }

    @Override
    public void publishTweet(final Tweet tweet)
    {
        tweet.setId(UUID.randomUUID().toString());
        emitter.accept(tweet);
    }
}
