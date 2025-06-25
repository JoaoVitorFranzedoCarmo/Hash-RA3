public class HashMultiplicacao implements HashTable {
    private No[] tabela;
    private int colisoes;
    private int colisoesLista;
    private int tamanho;
    private final double A = 0.6180339887;
    
    public HashMultiplicacao(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new No[tamanho];
    }
    
    private int hash(int codigo) {
        double valor = codigo * A;
        return (int)(tamanho * (valor - (int)valor));
    }
    
    public void inserir(Registro registro) {
        int pos = hash(registro.getCodigo());
        
        if (tabela[pos] == null) {
            tabela[pos] = new No(registro);
        } else {
            colisoes++;
            No atual = tabela[pos];
            while (atual.proximo != null) {
                atual = atual.proximo;
                colisoesLista++;
            }
            atual.proximo = new No(registro);
        }
    }
    
    public ResultadoBusca buscar(Registro registro) {
        int pos = hash(registro.getCodigo());
        No atual = tabela[pos];
        int comparacoes = 0;
        long inicio = System.nanoTime();
        
        while (atual != null) {
            comparacoes++;
            if (atual.registro.getCodigo() == registro.getCodigo()) {
                long tempo = System.nanoTime() - inicio;
                return new ResultadoBusca(true, comparacoes, tempo);
            }
            atual = atual.proximo;
        }
        long tempo = System.nanoTime() - inicio;
        return new ResultadoBusca(false, comparacoes, tempo);
    }
    
    public int getColisoes() { return colisoes; }
    public int getColisoesLista() { return colisoesLista; }
}