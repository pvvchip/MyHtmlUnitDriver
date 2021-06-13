import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class GMatrix {
    private String Name;
    private String Composition;
    private String Comment;

    public GMatrix(String barCode) {

        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);

        try (webClient) {
//            4607011262302
            HtmlPage page = webClient.getPage("http://www.goodsmatrix.ru/mobile/" + barCode + ".html");

            HtmlElement name = page.getHtmlElementById("GoodsName");
            Name = name.asText();

            HtmlElement composition = page.getHtmlElementById("Composition");
            Composition = composition.asText();

            HtmlElement comment = page.getHtmlElementById("Comment");
            Comment = comment.asText();

        } catch (ElementNotFoundException e) {
            System.out.println("Нет страницы или элемента.");
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    public String getName() {
        return Name;
    }

    public String getComposition() {
        return Composition;
    }

    public String getComment() {
        return Comment;
    }
}
