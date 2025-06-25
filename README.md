# Análise de Desempenho de Tabelas Hash em Java

Este projeto implementa e compara o desempenho de três funções de hash distintas em Java, com tratamento de colisões por encadeamento (listas ligadas). Ele segue rigorosamente as especificações do trabalho RA3 da PUCPR.

## Funcionalidades

- Tabela hash com tratamento de colisões por listas encadeadas.
- Três funções de hash implementadas:
  - Resto da divisão: `hash = código % tamanho`
  - Multiplicação: usa a constante áurea (`0.6180339887`)
  - Dobramento: divide o código em blocos e realiza a soma.
- Geração de dados aleatórios com seed fixa.
- Medições detalhadas de:
  - Tempo de inserção (ms)
  - Tempo de busca (ns)
  - Número de colisões totais e nas listas
  - Número de comparações por busca

## Resultados

Os resultados completos estão disponíveis no arquivo `resultados.csv`. Eles incluem:

- Método de hash utilizado
- Tamanho da tabela (1.000, 10.000 ou 100.000 posições)
- Quantidade de dados inseridos (10.000, 100.000 ou 1.000.000)
- Número total de colisões e colisões nas listas encadeadas
- Tempo médio de inserção e de busca
- Número médio de comparações por busca

---

## Análise de Desempenho de Tabelas Hash

### Resultados Detalhados por Tamanho de Tabela

### Tabela de Tamanho 1000

- Colisões:
  - Extremamente altas: 90% para 10k dados e 99% para 100k e 1M
  - Todas as funções têm desempenho quase idêntico nesse cenário

- Colisões em Lista:
  - Aumentam drasticamente: ~40k (10k) → ~490M (1M)
  - Dobramento teve ligeira vantagem em 1M (498.9M vs 499.0M)

- Tempo de Inserção:
  - Cresce rapidamente: 1-3ms (10k) → 25-26s (1M)
  - Dobramento foi mais eficiente com 1M dados (24.9s)

- Tempo de Busca:
  - Resto/Multiplicação estáveis (~17μs)
  - Dobramento salta para 108μs com 1M dados

- Comparações:
  - Crescimento linear: 5-6 (10k) → 493-507 (1M)
  - Multiplicação teve menor número em 1M (493)

#Conclusão: Espaço insuficiente. Dobramento se destaca na inserção, Multiplicação no equilíbrio geral.

---

### Tabela de Tamanho 10000

- Colisões:
  - Reduzidas em comparação com tabela 1000: 36% (10k) → 99% (1M)
  - Ainda assim, 990k colisões para 1M dados

- Colisões em Lista:
  - 1.2k (10k) → 49M (1M)
  - Dobramento foi melhor em 10k/100k

- Tempo de Inserção:
  - Mais rápido que tabela 1000
  - Dobramento mais consistente (31ms em 100k)

- Tempo de Busca:
  - 500-900ns (10k) → 15-16μs (1M)
  - Dobramento com boa performance geral

- Comparações:
  - 1-6 (100k) → 51 (1M)
  - Multiplicação teve menor crescimento

# Conclusão: Bom equilíbrio geral. Dobramento obteve melhor desempenho global.

---

### Tabela de Tamanho 100000

- Colisões:
  - Mínimas: 0.5% (10k) → 90% (1M)
  - Distribuição mais equilibrada entre funções

- Colisões em Lista:
  - 14-20 (10k) → 4.6M (1M)
  - Resto apresentou menos colisões

- Tempo de Inserção:
  - Muito baixo: 0-1ms (10k) → ~500ms (1M)
  - Resto foi mais eficiente

- Tempo de Busca:
  - Extremamente rápido: 260-420ns (10k)
  - Resto/Multiplicação consistentes

- Comparações:
  - Quase sempre 1 (máximo de 6 em 1M)
  - Eficiência máxima obtida

# Conclusão: Melhor desempenho geral. Resto se destacou amplamente.

---

### Resumo Final

| Tabela   | Inserção Rápida | Busca Eficiente | Menos Colisões | Menos Comparações | Observações           |
|----------|------------------|------------------|-----------------|--------------------|------------------------|
| 1000     | Dobramento        | Multiplicação    | Todas ruins     | Multiplicação      | Tabela pequena demais  |
| 10000    | Dobramento        | Dobramento       | Dobramento      | Multiplicação      | Boa opção geral        |
| 100000   | Resto             | Resto            | Resto           | Empate (1-6)       | Melhor escolha         |

---

## Principais Conclusões

- O tamanho da tabela é determinante: Tabela com 100.000 posições apresentou o melhor desempenho geral.
- Funções hash:
  - Resto: excelente para tabelas grandes.
  - Dobramento: ótimo desempenho em tabelas médias.
  - Multiplicação: desempenho mais estável em tabelas pequenas.
- Fator de carga é crítico: Acima de 90% de ocupação, a performance degrada rapidamente.

## Sobre o Projeto
Implementação acadêmica de tabelas hash em Java, comparando três funções de hash diferentes, com análise de desempenho em diversos cenários de carga. Desenvolvido como recuperação para a disciplina de Engenharia de Software da PUCPR.

## Gráficos
# Gráficos para o tamanho de tabela - 1000
- Tempo de inserção
![grafico_tabela100_tempo_inserc](https://github.com/user-attachments/assets/a95965f1-fe90-4b28-9eb0-b1a612a69dc2)
- Número de Colisões
![grafico_tabela100_colisoes](https://github.com/user-attachments/assets/f7782088-f942-49f9-9dc9-40400e67bb60)
- Tempo de Busca
![grafico_tabela100_temp_busca](https://github.com/user-attachments/assets/c11cb7d3-4c9e-4fa6-9747-eb195c9c78ea)
- Numero de Comparações
![grafico_tabela100_comparacoes](https://github.com/user-attachments/assets/017d5ac2-e1fd-49f6-9301-6cce53839842)

# Gráficos para o tamanho de tabela - 10000
- Tempo de inserção
![grafico_tabela10000_temp_insercao](https://github.com/user-attachments/assets/eee6191d-cf1f-40b8-b9b2-903024ae0b64)
- Número de Colisões
![grafico_tabela10000_colisao](https://github.com/user-attachments/assets/236a7602-a259-40e8-826d-225e29cb5192)
- Tempo de Busca
![grafico_tabela10000_temp_busca](https://github.com/user-attachments/assets/cfe8fffc-a35d-4582-9ff6-9209b1b25008)
- Numero de Comparações
![grafico_tabela10000_comparacoes](https://github.com/user-attachments/assets/957f3ba4-d3b2-4e29-8757-fb5be18aba1c)
# Gráficos para o tamanho de tabela - 100000
- Tempo de inserção
![grafico_tabela100000_temp_insercao](https://github.com/user-attachments/assets/f9ed9b22-4982-4ede-b423-d9c2d2b13aff)
- Número de Colisões
![grafico_tabela100000_colisoes](https://github.com/user-attachments/assets/5238a67d-fa01-4f82-a2ed-b7a71c56ca25)
- Tempo de Busca
![grafico_tabela100000_temp_busca](https://github.com/user-attachments/assets/52673afd-75e7-4c40-aef4-0a1b33aa6520)
- Numero de Comparações
![grafico_tabela100000_comparacoes](https://github.com/user-attachments/assets/254bb3cc-6ee4-4d91-a3c6-c226251e14b6)

