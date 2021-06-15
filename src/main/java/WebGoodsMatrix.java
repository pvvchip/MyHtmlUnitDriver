import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class WebGoodsMatrix extends WebInfo {
    public WebGoodsMatrix(String barCode) {
        setBarCode(barCode);

        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);

        try (webClient) {
            HtmlPage page = webClient.getPage("http://www.goodsmatrix.ru/mobile/" + getBarCode() + ".html");
            HtmlElement name = page.getHtmlElementById("GoodsName");
            HtmlElement composition = page.getHtmlElementById("Composition");
            HtmlElement comment = page.getHtmlElementById("Comment");

            setName(name.asText());
            setComposition(composition.asText());
            setComment(comment.asText());

        } catch (ElementNotFoundException e) {
            System.out.println("Нет страницы или элемента.");
        } catch (FailingHttpStatusCodeException e) {
            System.out.println("Ошибка сервера: www.goodsmatrix.ru");
        } catch (Exception e) {
            System.out.println("Ошибка сети");
        }
    }

    @Override
    public String toString() {
        return getBarCode() + "\n"
                + getName() + "\n"
                + getComposition() + "\n"
                + getComment();
    }
}
