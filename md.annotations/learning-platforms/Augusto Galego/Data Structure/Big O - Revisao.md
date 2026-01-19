- Forma de denotar a performance sobre a escalabilidade a partir da analise assintotica 
- Geralmente e considerado o pior caso possivel
- Complexidade temporal:
	- Diz respeito a acessos/tempo do runtime
- Complexidade espacial:
	- Quanto de espaco vamos alocar na memoria, independente de quantas iteracoes fazer


- Principais Big O notation (melhor para pior)
	- O(1) - Constante
		- Ex: Tempo: Pegar a primeira posicao de um array
		- Ex: Espaco: Alocar somente um espaco na memoria
		- Obs: Caso seja uma variavel fixa mesmo sendo um numero alto, o espaco na memoria ainda e O(1)

	- O(log N) - Logaritimica
		- Conforme o input aumenta exponencialmente o tempo de exec. aumenta linearmente.
		- Ex: Binary Search, aumentando um array de 10 elementos para 20, apenas aumenta uma execucao na busca. Exponencial -> Linear

	- O(N) - Linear
		- Escala conforme o input aumenta, tanto temporal quanto espacial

	- O(N log N) - Log-Linear
		- Quase todos os metodos de sorting (Exceto BubbleSort -> O(n2))
			- QuickSort, MergeSort...
		- Divide and Conquer
		- Percorre todo o algoritmo (O(N)) recursivamente(multiplica) enquanto divide o array(O(N log N))

	- O(N²) - Quadratica
		- Basicamente um loop dentro de outro, aonde ambos sao percorridos por completo.