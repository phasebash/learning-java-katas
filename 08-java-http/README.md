08 HTTP
=======
In this kata we will introduce you to low-level (and terrible) HTTP connections with Java's HttpUrlConnection.  In a
real application we would be using a more robust client implementation (like Apache HttpClient), but this lab will
introduce you to URL, URI, UrlConnection, HttpUrlConnection, IOException, and other friends.

* Use the provided abstractions to keep the tests simple.
* Make a HTTP connection to GET http://httpstat.us/200
* Set the User-Agent to be: LOL-Client
* Set the connect timeout to be 1000
* Set the read timeout to 5000
* Handle the successful request and write the response to console
* Make a HTTP connection to GET http://httpstat.us/500
* Set the User-Agent to be: LOL-Client
* Set the connect timeout to be 1000
* Set the read timeout to 5000
* Handle the failing request and write the response to console
* If at any time we get a status code we do not anticipate throw an IllegalStateException
* In the case of error, just catch the IOException.

There will not be unit tests for this module since we need a mocking library to do it correctly.  Future labs will
take this on.

Hints
-----
* Use the URL class to open a connection.
* Use InputStreamReader.
* Use BufferedReader.
* Put 
