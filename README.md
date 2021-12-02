# Estruturas de dados



<p align="center">
  <img alt="IBIMIRIM" src="https://i0.wp.com/www.luisdev.com.br/wp-content/uploads/2021/04/ESTRUTURA-DE-DADOS-COM-C.png?w=744&ssl=1" width="80%">
</p>

A Lei de Demeter: Há uma heurística muito conhecida chamada Lei de Demeter: um módulo não deve enxergar o interior dos objetos que ele manipula. Como vimos na seção anterior, os objetos escondem seus dados e expõem as operações. Isso significa que um objeto não deve expor sua estrutura interna por meio dos métodos assessores, pois isso seria expor, e não ocultar, sua estrutura interna.

► C

► Um objeto criado por f

► Um objeto passado como parâmetro para f

► um objeto dentro de uma variável de instância C

O método não deve chamar os métodos em objetos retornados por qualquer outras das funções permitidas. Em outras palavra, fale apenas com conhecidos, não com estranhos.

O código seguinte parece violar a Lei de Demeter (dentre outras coisas), pois ele chama a função getScratchDir() no valor retornado de getOptions() e, então, chama getAbsolutePath() no valor retornado de getScratchDir().

​	final String outputDir = ctxt.getOptions().getScratchDir().getAbsolutePath();

*código limpo Habilidades Práticas do Agile Software*
