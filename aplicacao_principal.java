import java.util.ArrayList;
import java.util.Scanner;

public class ListaDeTarefas {
    private ArrayList<Tarefa> tarefas;

    public ListaDeTarefas() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        this.tarefas.add(tarefa);
    }

    public void removerTarefa(Tarefa tarefa) {
        this.tarefas.remove(tarefa);
    }

    public void marcarTarefaConcluida(Tarefa tarefa) {
        tarefa.setConcluida(true);
    }

    public ArrayList<Tarefa> getTarefas() {
        return this.tarefas;
    }

    public static void main(String[] args) {
        ListaDeTarefas listaDeTarefas = new ListaDeTarefas();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Remover tarefa");
            System.out.println("3. Marcar tarefa como concluída");
            System.out.println("4. Ver todas as tarefas");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    scanner.nextLine(); // Consumir nova linha
                    System.out.println("Digite o nome da tarefa:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite a descrição da tarefa:");
                    String descricao = scanner.nextLine();
                    Tarefa tarefa = new Tarefa(nome, descricao);
                    listaDeTarefas.adicionarTarefa(tarefa);
                    System.out.println("Tarefa adicionada com sucesso.");
                    break;
                case 2:
                    System.out.println("Digite o número da tarefa que deseja remover:");
                    int indexRemover = scanner.nextInt();
                    if (indexRemover < 1 || indexRemover > listaDeTarefas.getTarefas().size()) {
                        System.out.println("Índice inválido.");
                        break;
                    }
                    Tarefa tarefaRemover = listaDeTarefas.getTarefas().get(indexRemover - 1);
                    listaDeTarefas.removerTarefa(tarefaRemover);
                    System.out.println("Tarefa removida com sucesso.");
                    break;
                case 3:
                    System.out.println("Digite o número da tarefa que deseja marcar como concluída:");
                    int indexConcluida = scanner.nextInt();
                    if (indexConcluida < 1 || indexConcluida > listaDeTarefas.getTarefas().size()) {
                        System.out.println("Índice inválido.");
                        break;
                    }
                    Tarefa tarefaConcluida = listaDeTarefas.getTarefas().get(indexConcluida - 1);
                    listaDeTarefas.marcarTarefaConcluida(tarefaConcluida);
                    System.out.println("Tarefa marcada como concluída.");
                    break;
                case 4:
                    ArrayList<Tarefa> tarefas = listaDeTarefas.getTarefas();
                    if (tarefas.isEmpty()) {
                        System.out.println("Não há tarefas cadastradas.");
                    } else {
                        System.out.println("Todas as tarefas:");
                        for (int i = 0; i < tarefas.size(); i++) {
                            Tarefa tarefaAtual = tarefas.get
