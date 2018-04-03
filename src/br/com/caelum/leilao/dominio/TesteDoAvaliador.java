package br.com.caelum.leilao.dominio;

import org.junit.Assert;
import org.junit.Test;

public class TesteDoAvaliador {
	
	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		
		//1º parte : cenario
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao ("Playstation 3 Novo");
		
		leilao.propoe(new Lance(joao, 250.0));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(maria, 400.0));
		
		//2º parte : acao
		Avaliador leiloeiro = new Avaliador ();
		leiloeiro.avalia(leilao);
		
		//3º parte : validacao
		double maiorEsperado = 400;
		double menorEsperado = 250;
		
		Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		
		Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
	}

}
