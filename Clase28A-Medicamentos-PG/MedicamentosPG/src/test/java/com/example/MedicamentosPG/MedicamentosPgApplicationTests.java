package com.example.MedicamentosPG;

import com.example.MedicamentosPG.dto.MedicamentoDTO;
import com.example.MedicamentosPG.repository.impl.MedicamentoRepository;
import com.example.MedicamentosPG.service.MedicamentoService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class MedicamentosPgApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void guardar(){
		MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoRepository());
		MedicamentoDTO medicamentoDTO = medicamentoService.guardarMedicamento(new MedicamentoDTO("Ibuprofeno", "lab123", 500, 1000.99));

		Assert.assertNotNull(medicamentoDTO);

	}

}
