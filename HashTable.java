public interface HashTable {
    void inserir(Registro registro);
    ResultadoBusca buscar(Registro registro);
    int getColisoes();
    int getColisoesLista();
}

class ResultadoBusca {
    public final boolean encontrado;
    public final int comparacoes;
    public final long tempoNanos;
    
    public ResultadoBusca(boolean encontrado, int comparacoes, long tempoNanos) {
        this.encontrado = encontrado;
        this.comparacoes = comparacoes;
        this.tempoNanos = tempoNanos;
    }
}