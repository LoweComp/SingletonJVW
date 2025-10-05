package com.SingletonJVW;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AgendaMusicalTest {

    @org.junit.jupiter.api.BeforeEach
    void setup() {
        AgendaMusical instance = AgendaMusical.getInstance();
        instance.setNomeFestival(null);
        instance.setUsuarioLogado(null);
        instance.setCapacidadeMaxima(0);
        instance.finalizarProducao();
        instance.getEventosAgendados().clear();
    }

    @Test
    void deveRetornarSempreAMesmaInstancia() {
        AgendaMusical instancia1 = AgendaMusical.getInstance();
        AgendaMusical instancia2 = AgendaMusical.getInstance();

        assertSame(instancia1, instancia2, "As duas referências devem apontar para o mesmo objeto.");
        assertEquals(instancia1.hashCode(), instancia2.hashCode(), "Os HashCodes devem ser idênticos.");
    }

    @Test
    void deveCompartilharOEstadoGlobalmente() {
        // Add dados e modify estados
        AgendaMusical gerenteA = AgendaMusical.getInstance();
        gerenteA.setNomeFestival("VIBRA Festival");
        gerenteA.setUsuarioLogado("ProdutorMaster");
        gerenteA.setCapacidadeMaxima(50000);
        gerenteA.iniciarProducao(); // Muda o status boolean
        gerenteA.adicionarItemAgenda("LoweZera - Palco Norte");
        gerenteA.registrarFaltaDeItem();

        // VERIFICAÇÃO (Gerente B)
        AgendaMusical gerenteB = AgendaMusical.getInstance();
        assertEquals("VIBRA Festival", gerenteB.getNomeFestival(), "O nome do festival deve ser compartilhado.");
        assertEquals("ProdutorMaster", gerenteB.getUsuarioLogado(), "O usuário logado deve ser o mesmo.");
        assertEquals(50000, gerenteB.getCapacidadeMaxima(), "A capacidade máxima deve ser vista por todos.");
        assertTrue(gerenteB.isStatusProducao(), "O status de produção deve ser 'true'.");
        assertEquals(1, gerenteB.getItensEmFalta(), "O contador de falta de item deve ser 1.");

        // ADD novo item à lista
        gerenteB.adicionarItemAgenda("Check-in Equipe Técnica");
        assertEquals(2, gerenteA.getEventosAgendados().size(), "A lista deve ser compartilhada e ter 2 itens agora.");
    }
}
