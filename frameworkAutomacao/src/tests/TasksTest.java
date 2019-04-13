package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.TaskPage;

public class TasksTest extends BaseTest {
	
	TaskPage tp = new TaskPage();
	
	@Test
	public void criarTask() {
		tp.abrirTaskPage();
		tp.preencherCamposTask();
		tp.enviarTaskCriada();		
		Assert.assertEquals("Nova task1", tp.retornaTituloTaskCriada());
	}
}
