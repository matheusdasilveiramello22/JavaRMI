# Passos a serem seguidos para rodar o leitor de informações do computador, através do RMI:

### Remove todos os .class da pasta atual
1. rm *.class

### Compila todos os arquivos .java para .class
2. javac *.java

### Cria um objeto stub e skeleton pela ferramenta rmic
3. rmic LookerRemote

### Inicia o registro rmi em um prompt de comando na porta 5000
4. rmiregistry 5000

### Inicia o servidor em outro prompt de comando
5. java Server

### Inicia o cliente em outro prompt de comando
6. java Client
