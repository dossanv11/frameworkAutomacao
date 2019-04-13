package core;

import static core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	/***
	 * áreas de texto
	 */
	
	public void abrirURL(String url) {
		getDriver().get(url);
	}
	
	public void escreva(By locator, String texto) {
		getDriver().findElement(locator).clear();

		getDriver().findElement(locator).sendKeys(texto);
	}

	public void escreva(String id, String texto) {
		escreva(By.id(id), texto);// reutilizando método com parâmetros diferentes pois estamos usando sempre o
									// locator igual id
	}

	/***
	 * obter valores (input e html)
	 */

	public String obterValorInput(String id) {
		return getDriver().findElement(By.id(id)).getAttribute("value");
	}

	public String obterValorTexto(String id) {
		return getDriver().findElement(By.id(id)).getText();
	}
	
	public String obterValorTexto(By locator) {
		return getDriver().findElement(locator).getText();
	}

	/***
	 * áreas de clicks (button, radiobox, checkbox, listbox)
	 */

	public void clickRadio(String id) {
		getDriver().findElement(By.id(id)).click();
	}

	public void clickCheckBox(String id) {
		getDriver().findElement(By.id(id)).click();
	}

	public boolean verificarClique(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}

	public void selecionarCombo(String id, String valor) {
		WebElement elemento = getDriver().findElement(By.id(id));
		Select select = new Select(elemento);
		select.selectByVisibleText(valor);
	}

	public void deselecionarCombo(String id, String valor) {
		WebElement elemento = getDriver().findElement(By.id(id));
		Select select = new Select(elemento);
		select.deselectByVisibleText(valor);
	}
	
	public String obterValorCombo(String id, String valor) {
		WebElement elemento = getDriver().findElement(By.id(id));
		Select select = new Select(elemento);
		
		return select.getFirstSelectedOption().getText();
	}
	
	public List<String> obterValoresCombo (String id){
		WebElement elemento = getDriver().findElement(By.id(id));
		Select select = new Select(elemento);
		
		List<WebElement> listElements = select.getAllSelectedOptions();
		List<String> listValores = new ArrayList<String>();
		
		for (WebElement opcao : listElements) {
			listValores.add(opcao.getText());
		}
		
		return listValores;
	}
	
	public int obterQtdeOpcoesCombo(String id) {
		WebElement elemento = getDriver().findElement(By.id(id));
		Select select = new Select(elemento);
		
		List<WebElement> listElements = select.getOptions();
		
		return listElements.size();
	}
	
	public boolean verificarOpcaoCombo(String id, String valor) {
		WebElement elemento = getDriver().findElement(By.id(id));
		Select select = new Select(elemento);
		
		List<WebElement> listElements = select.getOptions();
		
		for (WebElement opcao : listElements) {
			if (opcao.getText().equals(valor)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void clicarBotaoXpath(String xpath) {
		getDriver().findElement(By.xpath(xpath)).click();
	}
	
	public void clicarBotaoId(String id) {
		getDriver().findElement(By.id(id)).click();
	}
	
	public void sendEnter(By locator) {
		getDriver().findElement(locator).sendKeys(Keys.ENTER);
	}
	
	//***ALERTS***//
	
	public String obterTextoAlert() {
		Alert alerta = getDriver().switchTo().alert();
		
		return alerta.getText();
		
	}
	
	public String obterTextoAceitarAlert() {
		Alert alerta = getDriver().switchTo().alert();
		String valor = alerta.getText(); 
		alerta.accept();
		
		return valor;
	}
	
	public String obterTextoNegarAlert() {
		Alert alerta = getDriver().switchTo().alert();
		String valor = alerta.getText(); 
		alerta.dismiss();
		
		return valor;
	}
	
	public void escreverNoAlert(String texto) {
		Alert alerta = getDriver().switchTo().alert();
		alerta.sendKeys(texto);
		alerta.accept();
	}
	
	//***FRAMES E JANELA***//
	public void entrarFrame(String id) {
		getDriver().switchTo().frame(id);
	}
	
	public void sairFrame() {
		getDriver().switchTo().defaultContent();
	}
	
	public void trocarJanela(String id) {
		getDriver().switchTo().window(id);
	}
	public void interagirComTabela(int indiceBusca,int indiceInteracao, String valor, String valorBusca, String acao) {
		String xpath = "//tbody/tr[td[" + indiceBusca + "]='" + valorBusca + "']/td[" + indiceInteracao + "]/input";
		
		WebElement elementoTabela = getDriver().findElement(By.xpath(xpath));
		
		switch (acao) {
		case "click":
			elementoTabela.click();
			break;
		case "escrever":
			elementoTabela.sendKeys(valor);
			break;
		default:
			System.out.println("Ação informada não é válida");
		}
	}
	
	
	//UTILIZANDO XPATH DENTRO DE OUTRO XPATH
	// //tbody/tr[td[1]="Doutorado"]/td[1]
}
