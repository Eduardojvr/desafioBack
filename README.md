# BACK END

Descrição do projeto

## Repositório:

## Pré-requisitos

Antes de começar, verifique se você atende aos seguintes requisitos:

- JDK (Java Development Kit) instalado e configurado corretamente na versão 17
- Maven instalado e configurado corretamente (dependendo do sistema de construção usado no projeto)
- Dependências e configurações do projeto estão corretamente definidas

## Configuração

Siga estes passos para configurar o projeto:

1. Clone este repositório para sua máquina local ou descompacte:

   ```shell
   cd gastos

2. 
    ```shell
    mvn clean install  

3. Subindo a aplicação localmente
    ```shell
    mvn spring-boot:run   

4. Testando se a aplicação está no ar
    acesse: http://localhost:8080/api/health/

5. Rodando teste unitários
    ```shell
    mvn clean test

6. vendo percentual de teste com jacoco
    ```shell
    mvn jacoco:report    

Após rodar o jacoco, abra "target\site\jacoco\index.html" no navegador


# FRONT END

Descrição do projeto

## Repositório:

## Pré-requisitos

Antes de começar, verifique se você atende aos seguintes requisitos:

- Node.js 17.9.1 e npm (Node Package Manager) instalados e configurados corretamente
- Angular CLI instalado globalmente (pode ser instalado usando o comando `npm install -g @angular/cli`)
- Dependências do projeto instaladas (pode ser feito executando o comando `npm install` na pasta raiz do projeto)

## Configuração

Siga estes passos para configurar o projeto:

1. Entre na rai do projeto

2. Rode
    ```shell
    npm install

3. Rode 
    ```shell
    ng serve
    
4. Acesse
    http://localhost:4200/