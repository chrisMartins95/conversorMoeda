package conversor;

/**
 * 📊 Modelo da Moeda - guarda nome, símbolo e valor atualizado
 * Exemplo: "Dólar", "USD", 5.67 (R$ por USD)
 */
public class Moeda {
    // 🌟 Atributos privados (só esta classe acessa)
    private String nome;      // "Dólar", "Euro", etc.
    private String simbolo;   // "USD", "EUR", "GBP"
    private double valor;     // Valor em reais (R$)

    // 🏗️ Construtor - cria moeda nova com valores
    public Moeda(String nome, String simbolo, double valor) {
        this.nome = nome;
        this.simbolo = simbolo;
        this.valor = valor;
    }

    // 📖 GETTERS - métodos para PEGAR os valores
    public String getNome() {
        return nome;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public double getValor() {
        return valor;
    }

    // ✏️ SETTER - método para ATUALIZAR o valor (opcional)
    public void setValor(double valor) {
        this.valor = valor;
    }

    // 💬 toString - formatação BONITA na tela
    @Override
    public String toString() {
        return String.format("💵 %s (%s): R$ %.2f", nome, simbolo, valor);
    }
}
