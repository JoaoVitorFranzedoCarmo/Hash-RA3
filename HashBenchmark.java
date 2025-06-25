import java.io.FileWriter;
import java.io.IOException;

public class HashBenchmark {
    public static void benchmark() {
        int[] tamanhosTabela = {1000, 10000, 100000};
        int[] tamanhosDados = {10000, 100000, 1000000};
        int[] seeds = {123, 456, 789};
        
        try {
            FileWriter writer = new FileWriter("resultados.csv");
            writer.write("Metodo,Tamanho_Tabela,Tamanho_Dados,Colisoes,Colisoes_Lista,Tempo_Insercao_ms,Tempo_Busca_ns,Comparacoes\n");
            
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    Registro[] dados = RegistroGenerator.gerarRegistros(tamanhosDados[j], seeds[j]);
                    
                    testarEGravar(writer, new HashResto(tamanhosTabela[i]), dados, "Resto", tamanhosTabela[i], tamanhosDados[j]);
                    testarEGravar(writer, new HashMultiplicacao(tamanhosTabela[i]), dados, "Multiplicacao", tamanhosTabela[i], tamanhosDados[j]);
                    testarEGravar(writer, new HashDobramento(tamanhosTabela[i]), dados, "Dobramento", tamanhosTabela[i], tamanhosDados[j]);
                }
            }
            
            writer.close();
            System.out.println("Dados salvos em resultados.csv");
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo");
        }
    }
    
    private static void testarEGravar(FileWriter writer, HashTable hash, Registro[] dados, String nome, int tamTabela, int tamDados) throws IOException {
        // Inserção
        long inicioIns = System.currentTimeMillis();
        for (int i = 0; i < tamDados; i++) {
            hash.inserir(dados[i]);
        }
        long tempoIns = System.currentTimeMillis() - inicioIns;
        
        // Busca
        int[] indicesBusca = {0, tamDados/4, tamDados/2, (3*tamDados)/4, tamDados-1};
        long tempoBuscaTotal = 0;
        int totalComparacoes = 0;
        
        for (int i = 0; i < 5; i++) {
            Registro alvo = dados[indicesBusca[i]];
            ResultadoBusca resultado = hash.buscar(alvo);
            tempoBuscaTotal += resultado.tempoNanos;
            totalComparacoes += resultado.comparacoes;
        }
        
        long tempoBuscaMedia = tempoBuscaTotal / 5;
        int mediaComparacoes = totalComparacoes / 5;
        
        String linha = String.format("%s,%d,%d,%d,%d,%d,%d,%d\n",
            nome, tamTabela, tamDados, hash.getColisoes(),
            hash.getColisoesLista(), tempoIns, tempoBuscaMedia, mediaComparacoes);
        
        writer.write(linha);
        
        System.out.printf("%s | Tabela: %d | Dados: %d | Colisões: %d (%d lista) | Tempo: %dms (ins) / %dns (busca) | Comparações: %d\n",
            nome, tamTabela, tamDados, hash.getColisoes(), hash.getColisoesLista(),
            tempoIns, tempoBuscaMedia, mediaComparacoes);
    }
}