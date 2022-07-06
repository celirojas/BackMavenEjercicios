package com.example.PruebasIntegracion;

import com.example.PruebasIntegracion.controller.LenguajeController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(LenguajeController.class)
class PruebasIntegracionApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	void buscarTodosLosLenguajesAPI() throws Exception{

		//Llamo al endpoint
		mvc.perform(MockMvcRequestBuilders.get("/lenguajes")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void buscarLenguajesTipoAPINoExistente() throws Exception{
		//Llamo al endpoint
		mvc.perform(MockMvcRequestBuilders.get("/lenguajes/{tipo}", "Pepe")
						.accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isNotFound());

	}
}
