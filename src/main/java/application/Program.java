package application;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;


public class Program {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);

		int selecao = 0;
		while (selecao != 4){
			System.out.println("TAINY'S BD");
			System.out.println("[1] ENVIAR UMA PESSOA PARA O BD;");
			System.out.println("[2] EXCLUIR UMA PESSOA DO BD;");
			System.out.println("[3] LISTAR CONTAS");
			System.out.println("[4] SAIR.");
			System.out.println("==========================");
			System.out.print("Selecione a operação que deseja realizar: ");
			selecao = sc.nextInt();


			switch (selecao){
				case 1:
					System.out.println("para adicionar uma pessoa, primeiro insira: ");
					System.out.println("seu nome");
					String nome = sc.next();
					System.out.println(" e o seu email: ");
					String email = sc.next();

					Pessoa pessoa = new Pessoa(null, nome, email);
					em.getTransaction().begin();
					em.persist(pessoa);
					em.getTransaction().commit();

					System.out.println("Pessoa adicionada com sucesso!");
					break;

				case 2:
					System.out.println("para apagar os dados de uma pessoa, primeiro insira: ");
					System.out.println("O ID da pessoa que deseja excluir: ");
					int selecaoId = sc.nextInt();

					pessoa = em.find(Pessoa.class, selecaoId);
					em.getTransaction().begin();
					em.remove(pessoa);
					em.getTransaction().commit();

					System.out.println("Dados da pessoa deletados com sucesso!");
					break;

				case 3:
					System.out.println("Listagem de pessoas criadas: ");
					Query query = em.createQuery("SELECT p FROM Pessoa p");
					List<Pessoa> pessoas = query.getResultList();
					for (Pessoa element : pessoas){
						System.out.println(element);
						System.out.println("==========================");
					}
					break;

				default:
					break;
			}
		}


		em.close();
		emf.close();
		sc.close();

	}

}
