# BACK END

Descrição do projeto

## Repositório:
https://github.com/Eduardojvr/desafioBack
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
