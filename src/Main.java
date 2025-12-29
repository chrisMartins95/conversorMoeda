package conversor;

import java.util.Scanner;

/**
 * 🎮 CONVERSOR PROFISSIONAL v3.0 - Histórico + 12 Moedas + Logs!
 */
public class Main {
    private static Historico historico = new Historico();

    public static void main(String[] args) {
        System.out.println("🚀 Conversor de Moedas v3.0 PRO 💎");
        System.out.println("Carregando cotações reais... ⏳\n");

        ApiMoeda api = new ApiMoeda();
        Moeda[] moedas = api.buscarTodasMoedas();

        Scanner scanner = new Scanner(System.in);
        int opcao;

        while (true) {
            mostrarMenuPrincipal();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> menuConverter(moedas, scanner);
                case 2 -> historico.mostrarHistorico();
                case 3 -> historico.limpar();
                case 0 -> {
                    System.out.println("👋 Até logo! ✨");
                    return;
                }
                default -> System.out.println("❌ Opção inválida!");
            }
            System.out.println();
        }
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("📋 MENU PRINCIPAL:");
        System.out.println("1️⃣  Converter Moeda");
        System.out.println("2️⃣  Ver Histórico");
        System.out.println("3️⃣  Limpar Histórico");
        System.out.println("0️⃣  Sair");
        System.out.print("💡 Escolha: ");
    }

    private static void menuConverter(Moeda[] moedas, Scanner scanner) {
        System.out.println("\n📊 MOEDAS DISPONÍVEIS (12 opções):");
        for (int i = 0; i < moedas.length; i++) {
            System.out.printf("%d. %s%n", i+1, moedas[i]);
        }

        System.out.print("\n💡 Digite o número da moeda: ");
        int escolha = scanner.nextInt();

        if (escolha < 1 || escolha > moedas.length) {
            System.out.println("❌ Moeda inválida!");
            return;
        }

        Moeda moeda = moedas[escolha - 1];
        System.out.print("💵 Quanto em REAL? R$ ");
        double valorReal = scanner.nextDouble();

        double valorConvertido = valorReal / moeda.getValor();
        System.out.printf("✅ R$ %.2f = %s %.2f%n",
                valorReal, moeda.getSimbolo(), valorConvertido);

        // 💾 SALVA NO HISTÓRICO!
        historico.adicionarConversao(moeda, valorReal, valorConvertido);
        System.out.println("📋 Salvo no histórico! ✅");
    }
}
