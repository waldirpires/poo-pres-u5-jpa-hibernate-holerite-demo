package br.newtonpaiva.poo.u5.lab5b.holerite;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpresaTest {

    private Empresa unit;

    @BeforeEach
    void setUp() throws Exception {
        unit = new Empresa("Newton Paiva SW", "123.456/0001-32", "Caiçara, BH");
    }

    @Test
    void testAdicionarFuncionario() {
        // given:
        var f = new Funcionario("0003", "Caim", "012.345.678-90", LocalDate.now(), "102");

        // test:
        unit.adicionarFuncionario(f);

        // assert:
        assertTrue(unit.getFuncionarios().contains(f)); // contem
        assertSame(f.getEmpresa(), unit); // igual
    }

    @Test
    void testRemoverFuncionario() {

    }
}
