package com.es.scrapper;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Assert;
import org.junit.Test;


public class ScrapperTest {

    private Scrapper scrapper;

    @Test
    public void simpleScrapperTest() {
        scrapper = new Scrapper();
        String url = "http://www.example.com";
        HtmlPage page = null;
        String xPathLink = "/html/body/div/p[2]/a";
        try {
            page = this.scrapper
                    .setOptions()
                    .setOptionJavaScriptWaitTimeDefault(3000)
                    .visit(url).getCurrentPage();
        } catch (Exception e) {
        }

        Assert.assertNotNull("Non-null page expected",page);
        String body = page.getPage().getBody().getTextContent();
        Assert.assertNotNull("Body tag expected",body);
        Assert.assertTrue("Didn't fine expected content",body.trim().startsWith("Example"));
    }

    @Test
    public void clickAnchorTest() {
        scrapper = new Scrapper();
        String url = "http://www.example.com";
        HtmlPage page = null;
        String xPathLink = "/html/body/div/p[2]/a";
        try {
            page = this.scrapper
                    .setOptions()
                    .setOptionJavaScriptWaitTimeDefault(3000)
                    .visit(url)
                    .visitAnchorX(xPathLink,2000)
                    .getCurrentPage();
        } catch (Exception e) {
        }
        Assert.assertNotNull("Non-null page expected",page);
        Assert.assertTrue("Expected a different result",page.getUrl().toString().equals("https://www.iana.org/domains/reserved"));
        String body = page.getPage().getBody().getTextContent().trim();
        Assert.assertTrue("Content expected to start with Domains",body.trim().startsWith("Domains"));
    }

}
