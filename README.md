# Sistema de Cálculo de Folha de Pagamento de Trabalhador em Java

Este projeto consiste em um programa Java que calcula o salário de um trabalhador para um determinado mês e ano, considerando seu salário base e os contratos por hora que ele possa ter. O sistema permite cadastrar as informações do trabalhador, seus contratos e, posteriormente, calcular o rendimento total para um período específico.

**Autor:** gustavodees

## Arquivos Incluídos

* `principal/Main.java`: Contém a classe principal com o método `main`, responsável por interagir com o usuário para obter os dados do trabalhador e seus contratos, e para calcular e exibir o salário.
* `enums/WorkerLevel.java`: Define o enum `WorkerLevel` que representa os possíveis níveis de experiência de um trabalhador (JUNIOR, MID\_LEVEL, SENIOR).
* `entities/Departament.java`: Define a classe `Departament`, que representa o departamento ao qual o trabalhador pertence.
* `entities/HourContract.java`: Define a classe `HourContract`, que representa um contrato por hora com informações sobre a data, valor por hora e duração em horas.
* `entities/Worker.java`: Define a classe `Worker`, que representa um trabalhador com informações como nome, nível, salário base, departamento e uma lista de contratos por hora.

## Como Usar

1.  **Salve os arquivos:** Certifique-se de salvar o código nos locais corretos:
    * Crie uma pasta chamada `entities`. Dentro dela, salve os arquivos `Departament.java` e `HourContract.java`.
    * Crie dentro da pasta `entities` uma subpasta chamada `enums` e salve o arquivo `WorkerLevel.java`.
    * Crie uma pasta chamada `principal` e salve dentro dela o arquivo `Main.java`.
2.  **Compile o código:** Abra um terminal ou prompt de comando, navegue até o diretório raiz do seu projeto e compile os arquivos Java utilizando o compilador Java:

    ```bash
    javac principal/Main.java entities/Departament.java entities/HourContract.java entities/enums/WorkerLevel.java entities/Worker.java
    ```

3.  **Execute o programa:** Após a compilação ser concluída com sucesso, execute a classe `Main` com o comando:

    ```bash
    java principal.Main
    ```

4.  **Entrada de Dados:** O programa irá interagir com você através do console, solicitando as seguintes informações:
    * **Nome do departamento:** Digite o nome do departamento ao qual o trabalhador pertence e pressione Enter.
    * **Dados do trabalhador:**
        * **Nome:** Digite o nome do trabalhador e pressione Enter.
        * **Level:** Digite o nível do trabalhador (JUNIOR, MID\_LEVEL ou SENIOR) e pressione Enter. Certifique-se de digitar exatamente como está nas opções.
        * **Salario Base:** Digite o salário base do trabalhador (use ponto como separador decimal) e pressione Enter.
    * **Quantidade de contratos:** Digite o número de contratos por hora que este trabalhador possui e pressione Enter.
    * **Dados de cada contrato:** Para cada contrato, o programa solicitará:
        * **Data (DD/MM/YYYY):** Digite a data do contrato no formato dia/mês/ano e pressione Enter.
        * **Valor por hora:** Digite o valor pago por hora neste contrato (use ponto como separador decimal) e pressione Enter.
        * **Duração:** Digite o número de horas trabalhadas neste contrato e pressione Enter.
    * **Mês e ano para cálculo:** Digite o mês e o ano para os quais você deseja calcular o salário total, no formato MM/YYYY (exemplo: 08/2023) e pressione Enter.

5.  **Resultado:** O programa exibirá no console:
    * O nome do trabalhador.
    * O nome do departamento ao qual ele pertence.
    * O salário total para o mês e ano especificados, formatado com duas casas decimais. Este valor incluirá o salário base e o valor total dos contratos por hora que ocorreram no mês e ano informados.

## Explicação do Código

### `enums/WorkerLevel.java`

Este arquivo define o enum `WorkerLevel`, que representa o nível de experiência do trabalhador. As opções são:

* `JUNIOR`
* `MID_LEVEL`
* `SENIOR`

### `entities/Departament.java`

Esta classe representa um departamento e possui o seguinte atributo:

* `nome` (String): O nome do departamento.

Possui um construtor padrão e um construtor que recebe o nome do departamento como parâmetro, além de um getter e um setter para o atributo `nome`.

### `entities/HourContract.java`

Esta classe representa um contrato por hora e possui os seguintes atributos:

* `date` (Date): A data do contrato.
* `valuePerHour` (Double): O valor pago por cada hora trabalhada.
* `hours` (Integer): A duração do contrato em horas.

Possui um construtor padrão e um construtor que recebe a data, o valor por hora e a duração como parâmetros, além de getters e setters para cada atributo. Inclui o método `totalValue()` que calcula o valor total do contrato (valor por hora multiplicado pela duração).

### `entities/Worker.java`

Esta classe representa um trabalhador e possui os seguintes atributos:

* `name` (String): O nome do trabalhador.
* `level` (WorkerLevel): O nível de experiência do trabalhador (referência ao enum `WorkerLevel`).
* `baseSalary` (Double): O salário base do trabalhador.
* `departament` (Departament): O departamento ao qual o trabalhador pertence (referência à classe `Departament`).
* `contracts` (List<HourContract>): Uma lista de objetos `HourContract` representando os contratos por hora do trabalhador.

Possui um construtor padrão e um construtor que recebe o nome, nível, salário base e departamento como parâmetros. Contém getters e setters para todos os atributos, além de métodos para adicionar (`addContract`) e remover (`removeContract`) contratos da lista.

O método principal para calcular o salário é `income(int year, int month)`. Este método recebe o ano e o mês como parâmetros e retorna o salário total do trabalhador para aquele período. Ele calcula a soma do salário base com o valor total de todos os contratos que possuem a mesma data (mês e ano) que os parâmetros fornecidos.

### `principal/Main.java`

Esta classe contém o método `main`, que é o ponto de entrada do programa.

1.  Cria um objeto `Scanner` para ler a entrada do usuário.
2.  Cria um objeto `SimpleDateFormat` para formatar a data dos contratos.
3.  Solicita e lê o nome do departamento.
4.  Solicita e lê os dados do trabalhador (nome, nível e salário base), criando um objeto `Worker`. O nível do trabalhador é convertido de String para o enum `WorkerLevel` utilizando `WorkerLevel.valueOf()`.
5.  Solicita a quantidade de contratos que o trabalhador possui.
6.  Em um loop, para cada contrato:
    * Solicita e lê a data, o valor por hora e a duração do contrato. A data é convertida de String para um objeto `Date` utilizando `sdf.parse()`.
    * Cria um objeto `HourContract` com as informações fornecidas e o adiciona à lista de contratos do trabalhador utilizando o método `addContract()`.
7.  Solicita e lê o mês e o ano para calcular o salário total, no formato MM/YYYY. Extrai o mês e o ano como inteiros.
8.  Imprime o nome do trabalhador, o nome do departamento e o salário total para o mês e ano especificados, formatado com duas casas decimais, chamando o método `income()` do objeto `Worker`.
9.  Fecha o objeto `Scanner`.
