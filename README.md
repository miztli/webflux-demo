
# Reactive programming, notes.

- The full benefits of reactive programming come into effect only if the entire stack is reactive and if all participating components (application code, runtime container, integrations) respect deferred execution, non-blocking APIs and the streaming nature of dataflow – basically following the underlying assumptions.

# API Test

### Bitcoin price updates
`GET http://localhost:8080/bitcoin/prices`

### Tweet feeds
`GET http://localhost:8080/tweets`
```
POST http://localhost:8080/tweets
{
    "user":"miztli",
    "message":"hello world!"
}
```

# References

https://spring.io/blog/2018/12/07/reactive-programming-and-relational-databases
