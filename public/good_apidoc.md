# Example of a good API Documentation
The Yipper API provides information about the various yips/yippers and is able to look up key word in yip posts, to like a yip post, to check on a yipper, and to post a yip.

<br/><br/>

## Lookup a user's yips
**Request Format:** /yipper/user/:user

**Request Type:** GET

**Returned Data Format**: JSON

**Description:** Given a valid user name, it returns a json that contains the name, yip, hashtag, and date of all the yips posted by the given user.

**Example Request:** user/Chewbarka

**Example Response:**
```json
{
  "results": [
    {
      "name": "Chewbarka",
      "yip": "Every snack you make every meal you bake every bite you take... I will be watching you.",
      "hashtag": "foodie",
      "date": "2019-06-28 23:22:21"
    },
    {
      "name": "Chewbarka",
      "yip": "chewy or soft cookies. I chew them all",
      "hashtag": "largebrain",
      "date": "2020-07-09 22:26:38"
    },
    ...
  ]
}
```

**Error Handling:**
- Possible 400 (invalid request) errors (all plain text):
  - If passed in an invalid pony name, returns an error with the message:
  `Yikes. User does not exist.`
- Possible 500 (server error) errors:
  - If passed in an error occured during the query, returns an error with the
  message: `An error occurred on the server. Try again later.`

<br/><br/>

## Create a new yip
**Request Format:** /yipper/new endpoint with POST parameters of `name` and `full`

**Request Type**: POST

**Returned Data Format**: JSON

**Description:** Given a valid `name` and `full`, returns information of a new yip including: the id, name, date, yip, hashtag, and likes.

**Example Request:** /yipper/likes with POST parameters of `name=Chewbarka` and
`full=???!!!!!!!????? #third`

**Example Response:**
```json
{
  "results": [
    {
      "id": 44,
      "name": "Chewbarka",
      "yip": "???!!!!!!!?????",
      "hashtag": "third",
      "likes": 0,
      "date": "2022-02-27 21:26:27"
    }
  ]
}
```

**Error Handling:**
- Possible 400 (invalid request) errors (all plain text):
  - If passed in an invalid user name, returns an error with the message:
  `Yikes. User does not exist.`
  - If passed in an invalid full content, returns an error with the message:
  `Yikes. Yip format is invalid.`
  - If missing one or more parameters, returns an error with the message:
  `Missing one or more of the required params.`
- Possible 500 (server error) errors:
  - If passed in an error occured during the query, returns an error with the
  message: `An error occurred on the server. Try again later.`
