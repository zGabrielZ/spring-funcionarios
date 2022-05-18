package br.com.gabrielferreira.spring.data;
import br.com.gabrielferreira.spring.data.entidade.Cargo;
import br.com.gabrielferreira.spring.data.entidade.Funcionario;
import br.com.gabrielferreira.spring.data.entidade.Unidade;
import br.com.gabrielferreira.spring.data.service.CargoService;
import br.com.gabrielferreira.spring.data.service.FuncionarioService;
import br.com.gabrielferreira.spring.data.service.RelatorioService;
import br.com.gabrielferreira.spring.data.service.UnidadeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication // Utilizamos essa anotação para percorrer em todas as anotações que está envolvido no projeto e executar
public class SpringDataApplication implements CommandLineRunner {
	private final CargoService cargoService;

	private final UnidadeService unidadeService;

	private final FuncionarioService funcionarioService;

	private final RelatorioService relatorioService;

	public SpringDataApplication(CargoService cargoService, UnidadeService unidadeService, FuncionarioService funcionarioService,RelatorioService relatorioService){
		this.cargoService = cargoService;
		this.unidadeService = unidadeService;
		this.funcionarioService = funcionarioService;
		this.relatorioService = relatorioService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args); // Rodar a nossa aplicação Spring
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Deletando todos os cargos, unidades e funcionarios já salvos !!");
		funcionarioService.deletarTudo();
		cargoService.deletarTudo();
		unidadeService.deletarTudo();


		System.out.println("Inserindo cargos !!");
		Cargo cargo1 = new Cargo(null,"Desenvolvedor de Software");
		cargoService.inserir(cargo1);

		Cargo cargo2 = new Cargo(null,"RH");
		cargoService.inserir(cargo2);

		Cargo cargo3 = new Cargo(null,"Gerente");
		cargoService.inserir(cargo3);

		System.out.println("Cargos inseridos !!");

		System.out.println("Atualizando o cargo 1 (Desenvolvedor de Software) para (Analista de Sistemas)");
		cargo1.setDescricao("Analista de Sistemas");
		cargoService.inserir(cargo1);
		System.out.println("Cargo atualizado !!");

		System.out.println("Mostrar o cargo atualizado !!");
		System.out.println(cargoService.mostrarCargo(cargo1.getId()));

		System.out.println("Deletar o cargo atualizado !!");
		cargoService.deletarPorId(cargo1.getId());

		System.out.println("Inserido outro cargo !!");
		Cargo cargo4 = new Cargo(null,"Analista de sistemas");
		cargoService.inserir(cargo4);

		System.out.println("Mostrar cargos salvos !!");
		Iterable<Cargo> cargos = cargoService.mostrarCargos();
		cargos.forEach(System.out::println);

		System.out.println("----------------------------------------------------------------------------------------");

		System.out.println("Inserindo unidades !!");
		Unidade unidade1 = new Unidade(null,"Mooca","Rua mooca, 43");
		unidadeService.inserir(unidade1);
		Unidade unidade2 = new Unidade(null,"Anália Franco","Rua anália franco, 50");
		unidadeService.inserir(unidade2);
		Unidade unidade3 = new Unidade(null,"Tatuapé","Rua tatuapé, 32");
		unidadeService.inserir(unidade3);

		System.out.println("------------------------------------------------------------------------------------------");

		System.out.println("Inserindo funcionários !!");
		Cargo cargoResultado = cargoService.mostrarCargo(cargo4.getId());
		Unidade unidadeResultado = unidadeService.mostrarUnidade(unidade1.getId());
		Funcionario funcionario = new Funcionario(null,"José Pereira","06785665000", BigDecimal.valueOf(4500.00)
				, LocalDate.parse("2018-10-03"),cargoResultado,unidadeResultado);
		funcionarioService.inserir(funcionario);

		Cargo cargoResultado2 = cargoService.mostrarCargo(cargo2.getId());
		Unidade unidadeResultado2 = unidadeService.mostrarUnidade(unidade1.getId());
		Funcionario funcionario2 = new Funcionario(null,"Marcos da Silva","05919685093", BigDecimal.valueOf(5500.00)
				, LocalDate.parse("2020-05-10"),cargoResultado2,unidadeResultado2);
		funcionarioService.inserir(funcionario2);

		Cargo cargoResultado3 = cargoService.mostrarCargo(cargo3.getId());
		Unidade unidadeResultado3 = unidadeService.mostrarUnidade(unidade2.getId());
		Funcionario funcionario3 = new Funcionario(null,"Lucas Pereira","04538018031", BigDecimal.valueOf(3500.00)
				, LocalDate.parse("2022-01-05"),cargoResultado3,unidadeResultado3);
		funcionarioService.inserir(funcionario3);

		Cargo cargoResultado4 = cargoService.mostrarCargo(cargo3.getId());
		Unidade unidadeResultado4 = unidadeService.mostrarUnidade(unidade3.getId());
		Funcionario funcionario4 = new Funcionario(null,"Lucas da Silva","00325429090", BigDecimal.valueOf(4600.00)
				, LocalDate.parse("2019-06-03"),cargoResultado4,unidadeResultado4);
		funcionarioService.inserir(funcionario4);

		System.out.println("Buscar por nome de funcionários !!");
		List<Funcionario> funcionarios = relatorioService.buscarFuncionarioPorNome("Lucas");
			funcionarios.forEach(System.out::println);

		System.out.println("Buscar por salário e retornar funcionários por maior ou igual !!");
		List<Funcionario> funcionariosSalarioMaiorOuIgual = relatorioService.buscarFuncionarioPorMaiorOuIgualSalario(BigDecimal.valueOf(3500.00));
		funcionariosSalarioMaiorOuIgual.forEach(System.out::println);

		System.out.println("Buscar por salário e retornar funcionário por menor ou igual !!");
		List<Funcionario> funcionariosSalarioMenorOuIgual = relatorioService.buscarFuncionarioPorMenorOuIgualSalario(BigDecimal.valueOf(3500.00));
		funcionariosSalarioMenorOuIgual.forEach(System.out::println);
	}
}
