## **Desafio**
Você foi contratado como consultor de TI por uma startup que está migrando seus sistemas para a nuvem usando Java e AWS. Durante a transição, a equipe precisa de uma ferramenta simples para identificar rapidamente o tipo de serviço AWS a partir de um código de operação enviado por outros times. Cada código de operação é uma string que pode indicar um serviço como EC2, S3 ou Lambda, mas pode também conter erros de digitação. Sua tarefa é criar um programa que, ao receber o código de operação, identifique corretamente o serviço AWS correspondente ou informe que o código é invalido. O sucesso da migração depende da precisão dessa identificação, pois comandos errados podem causar atrasos e custos extras. Use estruturas de controle básicas para garantir que apenas os códigos corretos sejam aceitos, ajudando a equipe a manter a eficiência e a segurança durante a consultoria.

Implemente um programa que leia uma string representando o código de operação e imprima o nome do serviço AWS correspondente: "EC2", "S3" ou "Lambda". Se o código não corresponder exatamente a nenhum desses, imprima "Codigo invalido". Utilize apenas estruturas de controle básicas (if, else if, else) para realizar a verificação. Não utilize bibliotecas externas.

---
### Entrada
Uma única string representando o código de operação enviado pela equipe.

---
### Saída
Uma única string: "EC2", "S3", "Lambda" ou "Codigo invalido", de acordo com o código de operação informado.

---
### Exemplos
A tabela abaixo apresenta exemplos de entrada e saída:

| Entrada     | Saída |
|:------------| :----: | 
| EC2         | EC2      |
| S3          | S3      |
| Lambda      | Lambda      |
| ec2         | Codigo invalido      |
