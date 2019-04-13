package pages;

import org.openqa.selenium.By;

import core.BasePage;


public class TaskPage extends BasePage {
		
	public void abrirTaskPage() {
		clicarBotaoId("insert-button");
	}
		
	public void preencherCamposTask() {
		escreva("title", "Nova task1");
		escreva("dueDate","10/10/1990");
		escreva(By.xpath("//label[@for='tags']/..//input"), "PrimeiraTag,");
		escreva(By.xpath("//label[@for='tags']/..//input"), "SegundaTag,");
	}
	
	public void enviarTaskCriada() {
		clicarBotaoId("form-submit-button");
	}
	
	public String retornaTituloTaskCriada() {
		String texto = obterValorTexto(By.xpath("//table[@id='tasks']//a[contains(text(),'Nova task1')]"));
		return texto;
	}
	
}
