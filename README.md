# projeto-jpa-maven
Projeto básico Java JPA com conexão com o banco de dados MySQL. O projeto salva os dados "nome" e "email".
segue alguns comentários que ajudam no entendimento do projeto: 


/* COMANDO PARA CRIAR PESSOA NO BANCO DE DADOS:
		Pessoa p3 = new Pessoa(null, "Hartur", "hartur@gmail.com"); <-- ADICIONANDO OS PARAMETROS DA PESSOA QUE SERA CRIADA.
    
		em.getTransaction().begin();									
		em.persist(p3);     <-- COMANDO PARA ENVIAR A PESSOA CRIADA PARA O BANCO DE DADOS.
		em.getTransaction().commit();
    
    

		 COMANDO PARA EXCLUIR PESSOA DO BANCO DE DADOS:
		Pessoa p = em.find(Pessoa.class, 3); <-- SELECIONANDO A PESSOA HARTUR COM O ID 3
		em.getTransaction().begin();
		em.remove(p);  <-- REMOVENDO A PESSOA SELECIONADA
		em.getTransaction().commit();
    
    

		COMANDO PARA LISTAGEM DE PESSOAS:
		System.out.println("Listagem de contas: ");
					Query query = em.createQuery("SELECT p FROM Pessoa p");  <-- CRIANDO UMA BUSCA PELOS DADOS DO OBJETO PESSOA (p)
					List<Pessoa> pessoas = query.getResultList();  <-- GUARDANDO TODAS AS PESSOAS NO BD EM UMA LISTA
					for (Pessoa element : pessoas){   <-- LAÇO DE REP. PARA MOSTRAR TODAS AS PESSOAS QUE ESTÃO NO BD
						System.out.println("==========================");
						System.out.println(element);
						System.out.println("==========================");
					}
		*/
