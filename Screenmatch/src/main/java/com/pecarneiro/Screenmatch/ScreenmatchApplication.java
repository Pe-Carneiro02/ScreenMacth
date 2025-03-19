package com.pecarneiro.Screenmatch;

import com.pecarneiro.Screenmatch.model.DadosSerie;
import com.pecarneiro.Screenmatch.service.ConsumoAPI;
import com.pecarneiro.Screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoapi = new ConsumoAPI();
		var json = consumoapi.obterDados("https://www.omdbapi.com/?t=dead&apikey=8b35bf12");
		System.out.println(json);
		ConverteDados conver = new ConverteDados();
		DadosSerie dados = conver.obterDados(json, DadosSerie.class);
        System.out.println(dados);

	}
}
