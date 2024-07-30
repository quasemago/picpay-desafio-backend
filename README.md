# Desafio PicPay backend.
Projeto elaborado para resolução do desafio do PicPay para uma vaga de backend. Desenvolvido em Java com Spring Boot.

Link do desáfio: https://github.com/PicPay/picpay-desafio-backend

## Tecnologias utilizadas:
- Spring Boot
- Spring Data JPA
- Spring Web
- Spring Validation
- Spring Cloud OpenFeign
- Spring DevTools
- Lombok
- H2 Database
- Flyway

## Instalando
O projeto foi desenvolvido utilizando a linguagem de programação Java, utilizando o Java Development Kit (JDK) na versão 17. Portanto, para executar o projeto, é necessário ter o JDK 17 instalado na máquina, que pode ser baixado através do link: https://www.oracle.com/java/technologies/downloads/#java17

Além do JDK 17, também é necessário ter o apache maven instalado na máquina, que pode ser baixado através do link: https://maven.apache.org/download.cgi

Após instalado o JDK e o Apache Maven, basta clonar o repositório:
```
git clone https://github.com/quasemago/picpay-desafio-backend.git
```

Após tudo instalado, basta abrir o terminal na pasta raiz do projeto, e executar o comando `mvn clean install` para que todas as dependências sejam baixadas. Após isso execute o comando `mvn clean package` para compilar o projeto.

## Executando
Com o projeto já compilado, observe que será criado uma pasta chamada `target` na raiz do projeto, essa pasta contem o nosso projeto compilado, sendo nomeado de `desafio-picpay-0.0.1-SNAPSHOT`.

Após entrar na pasta, para executar o projeto, basta executar o comando `java -jar desafio-picpay-0.0.1-SNAPSHOT` via terminal.

## API
### EndPoints:
- Realiza uma transação de transferência:
```json
"POST" /transfer
{
  "value": 1500.0,
  "payer": 1,
  "payee": 2
}
```
- Obtêm todas transações:
```json
"GET" /transfer
```

### Sucesso:
- Transação realizada com sucesso:
```json
{
    "transactionId": "fe5a3702-2583-4df3-a306-474631cd5e09",
    "date": "2024-07-18T18:52:30.9209573"
}
```

### Erros:
- Transação não autorizada:
```json
  {
    "code": 400,
    "status": "Bad Request",
    "message": "A transação não foi autorizada!"
  }
```
- Notificação falhou:
```json
{
    "code": 400,
    "status": "Bad Request",
    "message": "A transação não foi notificada com sucesso!"
}
```
- Transação falhou devido a regras de negócio:
```json
{
  "code": 400,
  "status": "Bad Request",
  "message": "O pagador não possui saldo suficiente para esta transferência."
}
```
- Transação falhou devido a campo(s) inválido(s):
```json
{
    "code": 400,
    "status": "Bad Request",
    "message": "Invalid field(s)",
    "details": [
        {
            "field": "value",
            "message": "deve ser maior que 0"
        }
    ]
}
```
