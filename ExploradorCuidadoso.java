/**
 * Explorador cuidadoso que executa tarefas com precisão e atenção aos detalhes.
 * Implementa Runnable para execução em thread separada.
 */
public class ExploradorCuidadoso extends Explorador implements Runnable {
    
    // * Construtor do explorador cuidadoso.
    public ExploradorCuidadoso(String nome, String tipo, int prioridade, String tarefa) {
        super(nome, tipo, prioridade, tarefa);
    }
    
    /**
     * Implementação específica da execução de tarefa para exploradores cuidadosos.
     * Exploradores cuidadosos executam tarefas com mais cautela e precisão.
     * @throws TarefaInvalidaException Se a tarefa for nula ou vazia
     */
    @Override
    public void executarTarefa() throws TarefaInvalidaException {
        // Valida se a tarefa é válida
        if (tarefa == null || tarefa.trim().isEmpty()) {
            throw new TarefaInvalidaException("Erro: Tarefa inválida para " + nome);
        }

        // Imprime informações sobre a execução da tarefa
        System.out.println("Status: " + nome + " está " + tarefa + " com cuidado.");
        System.out.println("Status: " + nome + " concluiu a tarefa com sucesso.");
    }
    
    /**
     * Método run() executado quando a thread é iniciada.
     * Trata exceções e chama executarTarefa().
     */
    @Override
    public void run() {
        try {
            executarTarefa(); // Chama o método de execução da tarefa
        } catch (TarefaInvalidaException e) {
            System.err.println(e.getMessage()); // Imprime a mensagem de erro se a tarefa for inválida
        }
    }
}

