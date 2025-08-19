# 📘 Challenge Currency Converter - G8 ONE

Este projeto é um **conversor de moedas** simples em Java.  
O usuário informa um valor no terminal, escolhe a conversão desejada e o programa consulta a **ExchangeRate-API**, retornando o valor convertido em tempo real.

---

## 🎯 Funcionalidades
- Menu interativo no terminal com **6 opções de conversão**:
  - Dólar Australiano ➝ Real  
  - Yuan Chinês ➝ Real  
  - Peso Mexicano ➝ Real  
  - Real ➝ Dólar Australiano  
  - Real ➝ Yuan Chinês  
  - Real ➝ Peso Mexicano  
- Consulta de **cotações em tempo real** por meio da **ExchangeRate-API**.  
- Exibição da **taxa de conversão usada** e do **valor convertido**.  

---

## 🚀 Tecnologias utilizadas
- **Java 24+**: linguagem principal do projeto.  
- **Gson**: biblioteca para serialização/desserialização JSON.  
- **ExchangeRate-API**: API gratuita para consulta das taxas de câmbio.  

---

## 📦 Requisitos
- **Java 24** ou superior instalado (JDK).  
- Cadastro gratuito na [ExchangeRate-API](https://www.exchangerate-api.com/) para obter uma **API Key**.  
- Biblioteca **Gson** adicionada ao projeto (configure conforme sua IDE).  
- IDE de sua preferência (IntelliJ, Eclipse, VS Code).  

---

## ⚙️ Instalação e execução

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu-usuario/seu-projeto.git
   cd seu-projeto

2. Configure a chave da API:
Abra o arquivo ExchangeRateClient.java e substitua a constante:

   ```bash
	- private static final String API_KEY = "SUA_CHAVE_AQUI";


3. Adicione a biblioteca Gson:
Configure conforme sua IDE (IntelliJ, Eclipse, VS Code, etc).

4. Execute o projeto:

- Pelo terminal (caso configure manualmente as dependências).
- Ou diretamente pela sua IDE.


## 🖼️ Exemplo de uso

=======================================

CONVERSOR DE MOEDAS (API)       

=======================================
1) USD -> BRL (Dólar para Real)
2) BRL -> USD (Real para Dólar)
3) EUR -> BRL (Euro para Real)
4) BRL -> EUR (Real para Euro)
5) ARS -> BRL (Peso Argentino para Real)
6) BRL -> ARS (Real para Peso Argentino)
7) Sair
Escolha uma opção (1-7): 1

Digite o valor a ser convertido: 100
Taxa usada: 1 USD = 5.23 BRL
Valor 100,00 [USD] equivale a 523,00 [BRL]
