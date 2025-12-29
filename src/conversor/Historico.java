package conversor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * 📋 Histórico de Conversões - salva TUDO que usuário faz!
 */
public class Historico {
    private final List<Conversao> conversoes;
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM HH:mm:ss");

    public Historico() {
        this.conversoes = new ArrayList<>();
    }

    /**
     * 💾 Adiciona nova conversão ao histórico
     */
    public void adicionarConversao(Moeda moeda, double valorReal, double valorConvertido) {
        Conversao conv = new Conversao(moeda, valorReal, valorConvertido, LocalDateTime.now());
        conversoes.add(conv);

        // 🗑️ Mantém só últimas 10 conversões
        if (conversoes.size() > 10) {
            conversoes.remove(0);
        }
    }

    /**
     * 📊 Mostra histórico formatado
     */
    public void mostrarHistorico() {
        if (conversoes.isEmpty()) {
            System.out.println("📭 Histórico vazio!");
            return;
        }

        System.out.println("\n📋 ÚLTIMAS CONVERSÕES:");
        System.out.println("═".repeat(60));
        for (int i = 0; i < conversoes.size(); i++) {
            Conversao c = conversoes.get(i);
            System.out.printf("%d. %s | R$ %.2f → %s %.2f | %s%n",
                    i+1, c.getDataHora(), c.getValorReal(),
                    c.getMoeda().getSimbolo(), c.getValorConvertido(),
                    c.getDataHora().format(FORMATTER));
        }
        System.out.println("═".repeat(60));
    }

    // 🗑️ Limpar histórico
    public void limpar() {
        conversoes.clear();
        System.out.println("🗑️ Histórico limpo!");
    }
}

/**
 * 📄 Registro individual de conversão
 */
class Conversao {
    private final Moeda moeda;
    private final double valorReal;
    private final double valorConvertido;
    private final LocalDateTime dataHora;

    public Conversao(Moeda moeda, double valorReal, double valorConvertido, LocalDateTime dataHora) {
        this.moeda = moeda;
        this.valorReal = valorReal;
        this.valorConvertido = valorConvertido;
        this.dataHora = dataHora;
    }

    // Getters
    public Moeda getMoeda() { return moeda; }
    public double getValorReal() { return valorReal; }
    public double getValorConvertido() { return valorConvertido; }
    public LocalDateTime getDataHora() { return dataHora; }
}
