# JpaRelationships
A simple CRUD example with Spring Data JPA using multiple associations


### Relationship Schema:
![Schema](https://github.com/andersonhsporto/JpaRelationships/blob/master/IMG/DB.png)


## Métodos
Requests to the API must follow the standards:
| Method | Description |
|---|---|
| `GET` | Retrieve information about the resource. |
| `POST` | Create a new resource. |
| `PUT` |	Update a resource. |
| `DELETE` | Delete a resource or related component. |



## Domain [/domain]


### List all domains (List) [GET /domain]

+ Request (application/json)

+ Response 200 (application/json)

```javascript
[
    {
        "id": 1,
        "name": "Eukarya",
        "kingdom": "Plantae"
    }
]
```

### New domain (Create) [POST /domain]

+ Attributes (object)

    + name: name of domain
    + kingdom: child kingdom

+ Request (application/json)

    + Body


```javascript
{
  "name": "Eukarya",
  "kingdom": "Plantae"
}
```

+ Response 200

```javascript
Domain created successfully
```

### Removal (Delete) [DELETE  /domain]

+ Attributes (object)

    + domain_id: id of domain

+ Request (application/json)

    + Body

```javascript
{
  "domain_id": "3"
}
```
   
+ Response 200
```javascript
Domain deleted successfully
```



