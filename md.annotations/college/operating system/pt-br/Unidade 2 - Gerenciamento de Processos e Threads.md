## **2.1 - Tarefas**
- As técnicas atuais de gerenciamento de processos realizam a multiplexação do processador entre as múltiplas tarefas existentes
	- **Task** -> A execução de um fluxo sequencial de instruções para atender uma finalidade específica;
	- **Programa** -> É o conjunto de uma ou mais sequências de instruções escritas para resolver um problema específico, constituindo assim uma aplicação ou um utilitário (Um programa pode possuir diversas tarefas.);

##### **Sistemas Mono-Tarefa**
- Cada tarefa geralmente possui *comportamento, duração, e importâncias distintas*.
- Cabe ao SO organizar a sequencia de execução de tarefas;
- Os primeiros sistemas computadorizados eram **mono-tarefa**:
	- Somente era possível executar uma tarefa de cada vez;

![[sistema-mono-tarefa.png]]
###### **Problemas**
- A transição de uma tarefa para outra era realizada manualmente pelo programador ou pelo operado profissional;
- O tempo em que o processador ficava ocioso esperando a tarefa finalizar uma operação em algum periférico de entrada/saída;

###### **Soluções**
- Posteriormente implementou-se o **system monitor**, capaz de automatizar a transição do fluxo de execução de uma tarefa para a outra;
	- A função do **system monitor** é gerenciar uma fila de tarefas a serem executada, otimizando assim a utilização do processador.
- A solução encontrada para otimizar o tempo do processador foi permitir a suspensão temporária das tarefas que realizam operações de I/O e permitir que outras utilizem o processador em seu lugar;
	- Este procedimento é chamado de **preemptação de tarefas**, e os SO que o implementam são chamados de sistemas preemptivos (Podemos parar no meio do caminho e intervir uma mensagem);
	- Isto deu origem aos sistemas **multi-tarefas**;

##### **Sistema Multi-Tarefas**
- *Diagrama inicial do Sistema Multi-Tarefas sem tratamento de looping*
![[sistema-multi-tarefas.png]]

- ***New Queue:*** Toda tarefa criada, fica na fila *nova* aguardando ser carregada em memória.
- ***Ready Queue:*** A fila recebe *tasks* tanto da fila de novas tasks, quanto da fila de tasks suspensas que agora estão prontas(Finalizou o I/O ou outra coisa que suspendia a task de continuar), e aguarda até poder ser processada pela CPU (Processing Queue).
- ***Processing Queue:*** 
- ***Suspended Queue:***
- ***Finished Queue:***

###### **Problemas**
- Como tratar uma tarefa cujo o tempo de execução era infinito (em looping), seja este acidentalmente ou intencionalmente?
- Além de poder inviabilizar a utilização do computador no caso de looping, esta abordagem não permitia interatividade (ex.: uso do terminal de comandos);

###### **Soluções**
- Para solucionar isto foram criados os sistema de tempo compartilhado (time-sharing);
	- Nesta abordagem, cada atividade que detém o processador recebe um limite de tempo de processamento chamado de ***quantum***;
	- Caso a tarefa não seja finalizada, esta retorna para a fila de tarefas prontas para execução (ready-queue) e aguarda uma nova oportunidade de utilizar o processador;
- *Diagrama do Sistema de estados utilizado atualmente*
![[sistema-multi-tarefas-atual.png]]

### **Implementação de Tarefas**
- Cada tarefa possui uma estrutura de dados onde as informações de contexto são armazenadas;
- Esta estrutura geralmente é chamada de TCB (Task Control Block).
	- ID (número, ponteiro, referência de objeto); 
	- Estado (nova, pronta, executando, suspensa, Finalizada, ...); 
	- Valores dos registradores do processador; 
	- Lista contendo as áreas de memória utilizadas pela tarefa; 
	- Lista contendo os arquivos abertos, conexões de rede e outros recursos; 
	- Informações de gerência e contabilização (prioridade, proprietário, data de início, tempo de processamento já decorrido, volume de dados lidos/escritos, etc.)

- Existe sempre um PCB (Process Control Block) que contém/gerencia diversas tarefas (TCB's) de modo que elas consigam se comunicar;
- As tarefas usam de um espaço de memória compartilhado aonde utilizam métodos async/await para gerenciar leitura/modificações das tasks, evitando acessos múltiplos.

## **2.2 - Trocas de Contexto**
- O ato de gravar as informações de uma tarefa permitindo-a ser executada posteriormente é chamado de chaveamento de contexto;
	- Contexto é o conjunto de dados que representam o estado atual da tarefa: 
		- Arquivos abertos; 
		- Valores de variáveis; 
		- Valores de registradores;

- Em termos leigos, faz um backup do *contexto* (Todos os dados necessários da tarefa) por meio do **dispatcher** e é direcionado pelo **scheduler** .

- Em um chaveamento de contexto existem questões de ordem mecânica e de ordem estratégica a serem resolvidas:
	- **Aspectos Mecânicos:** O *dispatcher* é responsável pela recuperação do contexto e atualização das informações contidas no TCB;
	- **Aspectos Estratégicos:** O *scheduler* é responsável por decidir, com base em algum fator (prioridade, tempo de processamento, etc.), a próxima tarefa que deverá ser executada pelo processador;

![[troca-de-contexto.png]]

## **2.3 - Processos**

