import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class WebRskrf extends WebInfo {

    public WebRskrf(String barCode) {
        setBarCode(barCode);

        Logger logger = LoggerFactory.getLogger(WebRskrf.class);

        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);

        try (webClient) {
            HtmlPage page = webClient.getPage("https://rskrf.ru/search/?how=r&q=" + getBarCode());
            List<HtmlElement> element = page.getByXPath("//a[@href=\"#goods\"]/span/text()");
            String str = String.valueOf(element.get(0));
            str = str.replace("(","").replace(")","");
            logger.info(str + " элемент");
            if (Integer.parseInt(str) == 1) {
                element = page.getByXPath("//a[@href=\"#goods\"]/span/text()");
            }

//            HtmlElement name = page.getHtmlElementById("GoodsName");
//            HtmlElement composition = page.getHtmlElementById("Composition");
//            HtmlElement comment = page.getHtmlElementById("Comment");
//
//            setName(name.asText());
//            setComposition(composition.asText());
//            setComment(comment.asText());

        } catch (ElementNotFoundException e) {
            logger.error("Нет страницы или элемента.");
        } catch (FailingHttpStatusCodeException e) {
            logger.error("Ошибка сервера: rskrf.ru");
        } catch (Exception e) {
            logger.error("Ошибка сети");
        }
    }
}
