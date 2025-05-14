# Conversor de Moedas Java

Uma aplicação em Java que consome a [ExchangeRate-API](https://www.exchangerate-api.com/) para converter valores entre diferentes moedas usando uma única chamada ao endpoint `/latest/USD`.  
Utiliza Java 11+, HttpClient e [Gson](https://github.com/google/gson) para serialização JSON.

---

## 📋 Sumário

- [Funcionalidades](#-funcionalidades)
- [Tecnologias](#-tecnologias)
- [Instalação](#-instalação)
- [Configuração](#-configuração)
- [Como usar](#-como-usar)
- [Arquitetura do código](#-arquitetura-do-código)
    - [Classes principais](#classes-principais)
    - [Método genérico de conversão](#método-genérico-de-conversão)
- [Testes](#-testes)
- [Melhorias futuras](#-melhorias-futuras)
- [Licença](#-licença)

---

## 🚀 Funcionalidades

- Chama a ExchangeRate-API apenas uma vez para obter taxas baseadas no USD.
- Converte entre pares de moedas arbitrários (ex.: USD→BRL, ARS→COP, EUR→GBP etc.) usando fórmula genérica.
- Menu de console interativo com opções de conversão pré-definidas e opção de “sair”.
- Tratamento de entrada do usuário e saída formatada.

---

## 🛠️ Tecnologias

- Java 11 ou superior
- HttpClient (java.net.http)
- [Gson](https://github.com/google/gson) para JSON
- ExchangeRate-API (endpoint gratuito `latest/USD`)

---



