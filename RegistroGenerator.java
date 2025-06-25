public class RegistroGenerator {
    public static Registro[] gerarRegistros(int quantidade, int seed) {
        Registro[] registros = new Registro[quantidade];
        int random = seed;
        
        for (int i = 0; i < quantidade; i++) {
            random = (random * 1103515245 + 12345) & 0x7fffffff;
            registros[i] = new Registro(100000000 + (random % 900000000));
        }
        return registros;
    }
}