Yipper API Documentation
The Yipper API provides information about the various yips/yippers and is able
to look up key word in yip posts, to like a yip post, to check on a yipper, and
to post a yip.

Get a list of all yips
Request Format: /yipper/yips
Request Type: GET
Returned Data Format: JSON
Description: Return a list of all the attributes of all tuples otherwise.
Example Request: /yipper/yips
Example Response:

{
  "results": [
    {
      "id": 34,
      "name": "Chewbarka",
      "yip": "will 2020 ever end",
      "hashtag": "covid",
      "likes": 0,
      "date": "2020-10-21 12:48:54"
    },
    {
      "id": 33,
      "name": "Orville Redenbarker",
      "yip": "dude I am not ready for school to start",
      "hashtag": "outtahere",
      "likes": 0,
      "date": "2020-09-20 22:37:54"
    },
    ...
  ]
}


Error Handling:

Possible 500 (server error) errors:

If passed in an error occured during the query, returns an error with the
message: An error occurred on the server. Try again later.
