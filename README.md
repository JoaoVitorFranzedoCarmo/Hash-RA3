# Análise de Desempenho de Tabelas Hash

## Descrição do Projeto
Implementação em Java de tabelas hash com tratamento de colisões por encadeamento, comparando três funções de hash diferentes. Desenvolvido para a disciplina de Estruturas de Dados da PUCPR.

## Métodos Implementados
| Função Hash          | Implementação                     | Arquivo               |
|----------------------|-----------------------------------|-----------------------|
| Resto da Divisão     | `hash = chave % tamanho`          | `HashResto.java`      |
| Multiplicação        | Usa constante áurea (0.6180339887)| `HashMultiplicacao.java` |
| Dobramento           | Divide e soma partes do código    | `HashDobramento.java` |

## Resultados por Tamanho de Tabela

### Tabela 1.000 Posições
#### Gráficos
1. ![Tempo de Inserção](https://github.com/user-attachments/assets/a95965f1-fe90-4b28-9eb0-b1a612a69dc2)
2. ![Colisões](https://github.com/user-attachments/assets/f7782088-f942-49f9-9dc9-40400e67bb60)
3. ![Tempo de Busca](https://github.com/user-attachments/assets/c11cb7d3-4c9e-4fa6-9747-eb195c9c78ea)
4. ![Comparações](https://github.com/user-attachments/assets/017d5ac2-e1fd-49f6-9301-6cce53839842)

**Análise**:
### Tabela com 1.000 posições

- Colisões:
  - O número de colisões é muito alto com qualquer função de hash.
  - Todas as funções se comportam de forma muito semelhante nesse cenário.

- Tempo de Inserção:
  - O tempo de inserção aumenta muito com a quantidade de dados.
  - A função Dobramento foi ligeiramente mais rápida com 1 milhão de dados.

- Tempo de Busca:
  - Os tempos são razoáveis com poucos dados.
  - Para 1 milhão de dados, a função Dobramento teve um tempo de busca bem mais alto.

- Comparações:
  - O número de comparações cresce bastante com mais dados.
  - A função Multiplicação teve menos comparações em cenários maiores.

Conclusão: Com apenas 1.000 posições, a tabela fica sobrecarregada. Dobramento foi melhor na inserção, enquanto Multiplicação teve um desempenho mais equilibrado no geral.


### Tabela 10.000 Posições
#### Gráficos
5. ![Tempo de Inserção](https://github.com/user-attachments/assets/eee6191d-cf1f-40b8-b9b2-903024ae0b64)
6. ![Colisões](https://github.com/user-attachments/assets/236a7602-a259-40e8-826d-225e29cb5192)
7. ![Tempo de Busca](https://github.com/user-attachments/assets/cfe8fffc-a35d-4582-9ff6-9209b1b25008)
8. ![Comparações](https://github.com/user-attachments/assets/957f3ba4-d3b2-4e29-8757-fb5be18aba1c)

**Análise**:
### Tabela com 10.000 posições

- Colisões:
  - As colisões diminuem em relação à tabela de 1.000, mas ainda são significativas com muitos dados.

- Tempo de Inserção:
  - O tempo foi menor em todos os casos comparado com a tabela de 1.000 posições.
  - A função Dobramento teve tempos mais estáveis e bons resultados.

- Tempo de Busca:
  - Todos os métodos tiveram bom desempenho.
  - Dobramento manteve desempenho consistente mesmo com muitos dados.

- Comparações:
  - O número de comparações cresceu com o volume de dados.
  - Multiplicação apresentou menos comparações nos testes maiores.

Conclusão: Esta configuração apresenta um bom equilíbrio entre desempenho e custo. Dobramento teve o melhor desempenho geral, enquanto Multiplicação se destacou nas comparações.

### Tabela 100.000 Posições
#### Gráficos
9. ![Tempo de Inserção](https://github.com/user-attachments/assets/f9ed9b22-4982-4ede-b423-d9c2d2b13aff)
10. ![Colisões](https://github.com/user-attachments/assets/5238a67d-fa01-4f82-a2ed-b7a71c56ca25)
11. ![Tempo de Busca](https://github.com/user-attachments/assets/52673afd-75e7-4c40-aef4-0a1b33aa6520)
12. ![Comparações](https://github.com/user-attachments/assets/254bb3cc-6ee4-4d91-a3c6-c226251e14b6)

**Análise**:

### Tabela com 100.000 posições

- Colisões:
  - O número de colisões foi baixo com 10 mil dados e aumentou com mais dados, mas ainda manteve-se em níveis aceitáveis.
  - A função Resto teve os menores números de colisões em todos os volumes.

- Tempo de Inserção:
  - O tempo de inserção foi muito bom, mesmo com grandes volumes de dados.
  - A função Resto teve os menores tempos.

- Tempo de Busca:
  - Todos os métodos tiveram tempos de busca muito rápidos.
  - Resto e Multiplicação foram ligeiramente melhores.

- Comparações:
  - O número de comparações ficou próximo de 1 na maioria dos casos.
  - Mesmo com 1 milhão de dados, o crescimento foi pequeno.

Conclusão: Esta foi a melhor configuração. A função Resto apresentou o melhor desempenho geral em praticamente todos os critérios.

## Conclusões Finais

- O tamanho da tabela tem um grande impacto no desempenho.
  - Tabelas pequenas causam muitas colisões e atrasos.
  - Tabelas maiores têm desempenho muito melhor e mais estável.

- Sobre as funções de hash:
  - Resto teve o melhor desempenho com tabelas grandes.
  - Dobramento foi eficiente em tabelas de tamanho médio.
  - Multiplicação teve desempenho consistente em tabelas menores.

- Manter uma taxa de ocupação adequada é essencial.
  - Quando a tabela fica muito cheia, o desempenho piora significativamente.
