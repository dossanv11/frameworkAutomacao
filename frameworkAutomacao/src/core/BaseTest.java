package core;

//Ctrl+Shift+M cria um corte estatico
import static core.DriverFactory.getDriver;   //Resultado de Ctrl+Shift+M
import static core.DriverFactory.killDriver;	//Resultado de Ctrl+Shift+M

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import pages.Inicializacao;





public class BaseTest {
	@Rule
	public TestName testName = new TestName();

	@Before
	public void inicializa() {
		Inicializacao inicializa = new Inicializacao();
		inicializa.abrirSite();
		inicializa.logar();
	}

	@After
	public void finaliza() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(
				"target" + File.separator + "screenshot" + File.separator + testName.getMethodName() + ".jpg"));

		if (Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
	}
}
