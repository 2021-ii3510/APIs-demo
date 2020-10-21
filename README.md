# APIs Demo

This is the application that we have live-coded during Lecture 5.

It uses multiple activities to actually illustrate the use of each of the following libraries:

- Picasso, which is used to download and display images from the Web;
- Glide, which is also used to download and display images from the Web;
- Volley, which is the Android library used to make HTTP requests;
- Retrofit, which is the other livrary used to make HTTP requests (Retrofit is also combined with Gson converter).

To be able to do all of these, it is important to:

- Change the `AndroidManifest.xml` file to allow the Internet permission;
- Declare the dependencies in the `build.gradle` app file.


## Picasso

Picasso is quite straightforward to use if you simply want to download an image from the Web and display it inside an `ImageView`.
For some more complex use (e.g., image transformation), the best thing would be to look at their documentation.

## Glide

Glide has a very similar usage as Picasso. If you want to know more about Glide, you can also take a look at their documentation.

## Volley

Volley is the Android library that makes HTTP requests. Depending on the format of your HTTP response, you should be creating either:

- A `StringRequest`, if your response is simply a String;
- A `JsonArrayRequest`, if your response is a JSON array;
- A `JsonObjectRequest`, if your response is a JSON object.

After that, you should simply implement the `onResponse()` and `onErrorResponse()` callback methods which will be called
when the call receives the response.

Finally, make sure to add the request to the `RequestQueue` object created to make all the queries.

## Retrofit

Retrofit is a HTTP library that is a little more complex to implement compared to Volley, but it is also more powerful.
Retrofit can (and not necessarily has to) be used with a converter to transform JSON objects into POJOs (_Plain Old Java Objects_).
For more information on Retrofit, take a look at the documentation.

For Retrofit to work, you need to:

- Declare POJOs for each type of _response_ that you expect from your API. Note that it is *super important* that you also declare the getters and setters;
- Declare an interface with methods that correspond to the HTTP requests that you're going to make;
- Instantiate a Retrofit object that will also create your service interface;
- Use your service to make the actual calls, and implement the callback methods with your own logic.