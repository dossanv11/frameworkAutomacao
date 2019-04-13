package pages;

import core.BasePage;

public class Inicializacao extends BasePage {

	public void abrirSite() {
		abrirURL("https://mark7.herokuapp.com/login");
	}
	
	public void logar() {
		escreva("login_email", "valdir.santos001@yahoo.com.br");
		escreva("login_password", "Automation@2019");
		clicarBotaoXpath("//button[contains(text(),'Login')]");
	}

}
