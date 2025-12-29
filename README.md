# 🚀 Conversor de Moedas v3.0 PRO

![Java](https://img.shields.io/badge/Java-17+-007396?style=flat&logo=java&logoColor=white)
![API](https://img.shields.io/badge/ExchangeRate--API-v6-green?style=flat&logo=apirest)

**Conversor PROFISSIONAL** com **cotações REAIS** da internet! 💰✨  
**Feito em Sorocaba-SP, Brasil** 🇧🇷


## ✨ FUNCIONALIDADES COMPLETAS

| **Feature** | **Status** |
|-------------|------------|
| 🌐 **HttpClient + API v6** (chave real) | ✅ |
| 💰 **12 moedas populares** | ✅ |
| 📋 **Histórico conversões** (últimas 10) | ✅ |
| 🕒 **Logs com data/hora** (java.time) | ✅ |
| 🎮 **Menu interativo PRO** | ✅ |
| 🛡️ **Fallback valores seguros** | ✅ |
| 💎 **Gson parsing robusto** | ✅ |

## 🌍 **MOEDAS DISPONÍVEIS (12)

| Moeda | Código |
|-------|--------|
| 🇺🇸 **Dólar** | USD |
| 🇪🇺 **Euro** | EUR |
| 🇬🇧 **Libra** | GBP |
| 🇨🇦 **Dólar Canadense** | CAD |
| 🇯🇵 **Iene** | JPY |
| 🇦🇺 **Dólar Australiano** | AUD |
| 🇲🇽 **Peso Mexicano** | MXN |
| 🇷🇺 **Rublo** | RUB |
| 🇨🇳 **Yuan** | CNY |
| 🇮🇳 **Rupia Indiana** | INR |
| 🪙 **Bitcoin** | BTC |
| ⚡ **Ethereum** | ETH |


## 🎮 COMO USAR

**🚀 Conversor de Moedas v3.0 PRO 💎**

📋 MENU PRINCIPAL:

    1️⃣ Converter Moeda
    2️⃣ Ver Histórico  
    3️⃣ Limpar Histórico
    0️⃣ Sair

1 → Escolha moeda → Digite R$ → CONVERTE! ✅  
2 → Veja últimas 10 conversões com horário


📁 ESTRUTURA DO PROJETO

    src/
    └── conversor/
    ├── Moeda.java         (Modelo de dados 💎)
    ├── ApiMoeda.java      (HttpClient + Gson 🌐)
    ├── Main.java          (Menu profissional 🎮)
    └── Historico.java     (Logs java.time 📋)
'''

## 🛠️ TECNOLOGIAS
- Java 17+ (HttpClient moderno)  
- Gson 2.10.1 (JSON parsing)  
- java.time (Logs precisos)  
- ExchangeRate-API v6 (Cotações reais)

## 🔧 COMO EXECUTAR
1. Abra no IntelliJ IDEA
2. src → Mark Directory as → Sources Root (azul ✅)
3. Adicione Gson: File → Project Structure → Libraries → Maven → com.google.code.gson:gson:2.10.1
4. Run Main.main() → Funcionando! 🚀

## 📊 EXEMPLO DE EXECUÇÃO

📊 MOEDAS DISPONÍVEIS:
1. 🇺🇸 Dólar (USD): R$ 5,54
2. 🇪🇺 Euro (EUR): R$ 6,52
   ...
   💡 1 → R$ 1000 → $ 180,51 ✅ SALVO!
   📋 ÚLTIMAS: 29/12 11:25 | R$1000 → $180,51
   
## 🔑 API KEY (substitua no código)

    private static final String API_URL =
        "https://v6.exchangerate-api.com/v6/SUA_CHAVE_AQUI/latest/BRL";


## 📈 COTAÇÕES ATUALIZADAS

- Fonte: ExchangeRate-API v6 (1500+ requests/mês grátis)
- Atualização: A cada execução
- 161 moedas suportadas (expansível)


## 🎓 O QUE APRENDEMOS
✅ HttpClient (Java 11+)  
✅ Gson JSON parsing      
✅ java.time LocalDateTime  
✅ ArrayList dinâmico  
✅ Switch expressions (Java 17)  
✅ Tratamento exceções robusto    
✅ Estrutura MVC simples  


# 📝 LICENSE

    MIT License - Uso pessoal/comercial OK!
    Dados API: Apenas uso final (não redistribuir)

# 👨‍💻 AUTOR
** Desenvolvido por Christian Martins, Brasil
29/12/2025 **

<div align="center"> <img src="https://img.shields.io/badge/Status-PRODU%C3%87%C3%83O-00D2FF?style=flat&logo=rocket&logoColor=white" alt="Produção"> </div>