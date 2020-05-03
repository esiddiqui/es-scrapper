# ES-Scrapper

This is a lightweight wrapper on the `HTMLUnit` head-less browser library.

More here: http://htmlunit.sourceforge.net/

The es-scrapper has a simple-to-use fluent-API to scrap content on the web, fill & submit forms, click links OR perform other workflows from Java code.


## Usage:
Clone the repo, build & install artifacts in the local maven repo. 

```

./gradlew :test publishToMavenLocal

```

.. then include it in your project like:

```
implementation 'com.es:web-scrapper:<version>'
```


## Example:

An example use case: 

Visit a page pointed by the `url` & then follow the link from `<a href=?>` found using `XPath`.

```
  page = new Scrapper()
        .setOptions()
        .setOptionJavaScriptWaitTimeDefault(3000)
        .visit(url) 
        .visitAnchorX(XPath,2000) 
        .getCurrentPage();
```
