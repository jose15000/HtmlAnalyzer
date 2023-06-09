<h1>HTML Analyzer</h1>
<p>Este programa tem como objetivo extrair o trecho de texto contido no nível mais profundo da estrutura HTML de uma página da web. O usuário fornece a URL da página e o programa realiza a análise do código HTML da página para identificar o trecho de texto.</p>

<h2>Funcionamento</h2>

<p>O programa utiliza a biblioteca Jsoup para realizar o parsing do código HTML da página. Em seguida, a função <code>getDeepestTextElement</code> é chamada para identificar o elemento HTML que contém o trecho de texto mais profundo na estrutura da página. Esse elemento é então utilizado para extrair o trecho de texto e exibi-lo na saída padrão.</p>

<h2>Estrutura do código</h2>

<p>O código do programa está dividido em três arquivos:</p>

<ul><li><code>HtmlAnalyzer.java</code> - arquivo principal que contém a lógica do programa;</li><li><code>HtmlLine.java</code> - arquivo com a classe que representa uma linha do código HTML;</li><li><code>TestHtmlAnalyzer.java</code> - arquivo com os testes unitários da classe HtmlAnalyzer.</li></ul>

<p>O arquivo <code>HtmlAnalyzer.java</code> contém a classe <code>HtmlAnalyzer</code>, que é a classe principal do programa. Ela contém o método <code>main</code> e as funções necessárias para realizar a análise da URL e extrair o trecho de texto contido no nível mais profundo da estrutura HTML.</p>

<p>O arquivo <code>HtmlLine.java</code> contém a classe <code>HtmlLine</code>, que representa uma linha do código HTML. Cada linha pode ser de um dos três tipos mencionados nas premissas e a classe possui métodos para identificar o tipo da linha e para extrair o conteúdo da linha, caso seja um trecho de texto.</p>

<p>O arquivo <code>TestHtmlAnalyzer.java</code> contém os testes unitários da classe <code>HtmlAnalyzer</code>. Os testes foram implementados com o framework JUnit e verificam o funcionamento das funções principais do programa.</p>

<h2>Como utilizar a solução</h2>

<p>Para utilizar o programa, é necessário ter o Java instalado em seu computador. Em seguida, siga os passos abaixo:</p>

<ol><li>Baixe os arquivos <code>HtmlAnalyzer.java</code>, <code>HtmlLine.java</code> e <code>TestHtmlAnalyzer.java</code> e salve-os em uma pasta de sua preferência.</li><li>Abra um terminal ou prompt de comando na pasta onde os arquivos foram salvos.</li><li>Compile o código com o comando <code>javac HtmlAnalyzer.java</code>.</li><li>Execute o programa com o comando <code>java HtmlAnalyzer [URL da página]</code>, substituindo <code>[URL da página]</code> pela URL da página que deseja analisar.</li><li>O trecho de texto contido no nível mais profundo da estrutura HTML da página será exibido na saída padrão.</li></ol>

<h2>Limitações</h2>

<p>O programa foi desenvolvido para funcionar com páginas HTML bem formadas e pode apresentar comportamentos inesperados em casos de páginas com erros de sintaxe ou com estruturas muito complexas. Além disso, o programa não é capaz de identificar trechos de texto que estejam dentro de elementos como scripts ou tags de comentários.</p>
