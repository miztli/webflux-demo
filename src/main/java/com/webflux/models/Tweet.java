package com.webflux.models;

public class Tweet
{
    private String id;

    private String user;

    private String message;

    public Tweet(final String id, final String user, final String message)
    {
        this.id = id;
        this.user = user;
        this.message = message;
    }

    public String getId()
    {
        return id;
    }

    public void setId(final String id)
    {
        this.id = id;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(final String user)
    {
        this.user = user;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(final String message)
    {
        this.message = message;
    }

    @Override
    public String toString()
    {
        return "Tweet{" +
            "id=" + id +
            ", user='" + user + '\'' +
            ", message='" + message + '\'' +
            '}';
    }
}
