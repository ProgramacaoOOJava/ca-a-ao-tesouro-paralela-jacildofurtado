import java.util.ArrayList;

/**
 * Classe principal que simula a Caça ao Tesouro Paralela.
 * Demonstra o uso de threads, prioridades, tipos (user e daemon) e exceções personalizadas
 * através de diferentes tipos de exploradores.
 */
public class CacaAoTesouroParalela {
    
    public static void main(String[] args) {
        System.out.println("=== CAÇA AO TESOURO PARALELA ===");
        System.out.println("Exploradores em ação: threads, prioridades e exceções em Java\n");
        
        // Lista para gerenciar as threads dos exploradores
        ArrayList<Thread> exploradoresThreads = new ArrayList<>();
        // Criando exploradores rápidos
        ExploradorRapido alice = new ExploradorRapido("Alice", "Rapido", 10, "Explorar a caverna profunda");
        ExploradorRapido bob = new ExploradorRapido("Bob", "Rapido", 8, "Investigar a floresta");
        // Criando exploradores cuidadosos
        ExploradorCuidadoso charlie = new ExploradorCuidadoso("Charlie", "Cuidadoso", 3, "Examinar as pedras");
        ExploradorCuidadoso david = new ExploradorCuidadoso("David", "Cuidadoso", 3, "Observar os animais");
        // Criando um explorador com tarefa inválida para demonstrar exceção
        ExploradorRapido eve = new ExploradorRapido("Eve", "Rapido", 5, null);

        // Encapsulando exploradores em threads
        Thread tAlice = new Thread(alice);
        tAlice.setName("Alice");
        Thread tBob = new Thread(bob);
        tBob.setName("Bob");
        Thread tCharlie = new Thread(charlie);
        tCharlie.setName("Charlie");
        Thread tDavid = new Thread(david);
        tDavid.setName("David");
        Thread tEve = new Thread(eve);
        tEve.setName("Eve");
        // Configurando prioridades das threads
        tAlice.setPriority(Thread.MAX_PRIORITY);
        tBob.setPriority(Thread.MAX_PRIORITY);
        tCharlie.setPriority(Thread.MIN_PRIORITY);
        tDavid.setPriority(Thread.MIN_PRIORITY);
        tEve.setPriority(Thread.MAX_PRIORITY);
        // Configurando algumas threads como daemon (tarefas secundárias)
        tCharlie.setDaemon(true);
        tDavid.setDaemon(true);
        // Adicionando threads à lista
        exploradoresThreads.add(tAlice);
        exploradoresThreads.add(tBob);
        exploradoresThreads.add(tCharlie);
        exploradoresThreads.add(tDavid);
        exploradoresThreads.add(tEve);
        // Exibindo informações das threads antes da execução
        System.out.println("\n=== INFORMAÇÕES DAS THREADS ===");
        for (Thread t : exploradoresThreads) {
            System.out.println("Explorador: " + t.getName() 
                    + " | Prioridade: " + t.getPriority() 
                    + " | Daemon: " + t.isDaemon()
                    + " | Estado: " + t.getState());
        }
        
        // Iniciando todas as threads
        System.out.println("\n=== INICIANDO EXPLORAÇÃO ===");
        for (Thread t : exploradoresThreads) {
            t.start();
            System.out.println("Explorador " + t.getName() + " iniciou a exploração.");
        }
        
        // Aguardando conclusão das threads não-daemon
        System.out.println("\n=== AGUARDANDO CONCLUSÃO DOS EXPLORADORES ===");
        for (Thread t : exploradoresThreads) {
            if (!t.isDaemon()) {
                try {
                    t.join(); // Aguarda a conclusão da thread
                    System.out.println("Explorador " + t.getName() + " finalizada.");
                } catch (InterruptedException e) {
                    System.err.println("Erro ao aguardar Explorador " + t.getName() + ": " + e.getMessage());
                }
            }
        }
        
        // Verificando estado final das threads
        System.out.println("\n=== ESTADO FINAL DAS THREADS ===");
        for (Thread t : exploradoresThreads) {
            System.out.println("Explorador: " + t.getName() 
                    + " | Estado final: " + t.getState());
        }
        
        System.out.println("\n=== CAÇA AO TESOURO PARALELA FINALIZADA ===");
        System.out.println("Todos os exploradores principais completaram suas missões!");
    }
}

