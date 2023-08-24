package br.com.fiap;

import br.com.fiap.domain.entity.TipoDeAcao;
import br.com.fiap.domain.entity.Processo;
import br.com.fiap.domain.entity.Advogado;
import br.com.fiap.domain.entity.Estado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("oracle");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            // Persistir todas as entidades no SGBD
            entityManager.getTransaction().begin();

            Estado estado = new Estado(1L, "São Paulo", "SP");
            entityManager.persist(estado);

            TipoDeAcao tipoDeAcao = new TipoDeAcao(1L, "Ação Judicial");
            entityManager.persist(tipoDeAcao);

            Advogado advogado = new Advogado(1L, "João da Silva", "123456", estado);
            entityManager.persist(advogado);

            Processo processo = new Processo(1L, "123", false, advogado, tipoDeAcao);
            entityManager.persist(processo);

            entityManager.getTransaction().commit();

            // Consultar e exibir um Processo pelo identificador
            Processo processoConsultado = entityManager.find(Processo.class, 1L);
            System.out.println("Processo encontrado:");
            System.out.println(processoConsultado);

            // Consultar e exibir todos os processos
            List<Processo> processos = entityManager.createQuery("SELECT p FROM Processo p", Processo.class).getResultList();
            System.out.println("\nTodos os processos:");
            for (Processo p : processos) {
                System.out.println(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
