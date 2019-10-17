#Ferramenta para detectar se há problema com a tabela de horário de verão na versão do java
### no ano de 2019 não haverá horário de verão no Brasil, isso pode gerar problemas nos seus servidores
### você pode atualizar o java, mas como nem sempre isso é uma opção, essa ferramenta pode ser útil

- Para fazer build da ferramenta
  - mvn clean install
 
- Para rodar a ferramenta:
  -  java -jar horarioverao-1.0.jar
  
- ela apresentará uma mensagem como a mensagem abaixo
   - [ZDT] representacao -> 2019-11-02T23:00-03:00[America/Sao_Paulo]
   - [ZDT] offset -> -03:00
   - [ZDT] apos adicionar uma hora -> 2019-11-03T01:00-02:00[America/Sao_Paulo] com offset -02:00
   - [ZDT] Ainda ha problema com horario de verao: esperado[-03:00] obtido[-02:00]
   - [Calendar] representacao -> 02/11/2019 23:00
   - [Calendar] offset -> 0
   - [Calendar] apos adicionar uma hora -> 03/11/2019 01:00 com offset 3600000
   - [Calendar] Ainda ha problema com horario de verao: esperado[0] obtido[3600000]
   
- Para corrigir é necessário executar o comando:
   - java -jar tzupdater.jar -l https://data.iana.org/time-zones/releases/tzdata2019c.tar.gz
   - é possível obter o tzupdater no site da oracle (https://www.oracle.com/technetwork/java/javase/downloads/tzupdater-download-513681.html)
   - se você veio do futuro, a tabela de timezones pode ter sido atualizada, obtenha a mais recente em: https://www.iana.org/time-zones
   
- Depois rodar o primeiro comando novamente:
  -  java -jar horarioverao-1.0.jar
  -  [ZDT] representacao -> 2019-11-02T23:00-03:00[America/Sao_Paulo]
  -  [ZDT] offset -> -03:00
  -  [ZDT] apos adicionar uma hora -> 2019-11-03T00:00-03:00[America/Sao_Paulo] com offset -03:00
  -  [ZDT] Problema com horario de verao resolvido
  -  [Calendar] representacao -> 02/11/2019 23:00
  -  [Calendar] offset -> 0
  -  [Calendar] apos adicionar uma hora -> 03/11/2019 00:00 com offset 0
  -  [Calendar] Problema com horario de verao resolvido
