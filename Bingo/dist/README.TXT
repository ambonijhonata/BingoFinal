Dupla: Jhonata e Felipe Vedova

Pré requisitos:
- Java 21 e variáveis de ambiente configuradas.

1- Abrir um CMD na pasta aonde está o arquivo Bingo e executar a linha de comando: Essa linha irá iniciar o servidor.
java -cp Bingo.jar servidor.ChatServer

2- Abrir outro CMD na pasta aonde está o arquivo Bingo e executar a linha de comando: Essa linha iniciará os clientes.
java -cp Bingo.jar cliente.Menu

Servidor - sorteador:
Após iniciar o servidor, este irá aguardar a conexão dos clientes por 2 minutos, caso não tenha cliente conectado ao bingo, o servidor será finalizado. Se houver 
cliente conectado, o servidor irá sortear um número a cada 15 segundos até que se tenha um vencedor.

Cliente - cartela do bingo:
O cliente após iniciar irá ficar aguardando mensagem do servidor, sendo que está mensagem será um número de 1 a 75. Quando uma cartela do bingo marcar cinco números em posições
aleatórias, o cliente envia uma mensagem ao servidor com o texto "ganhou" e desmarca os números já sorteados na cartela para aguardar o próximo sorteio.

Servidor ao ter ganhador:
Após receber a mensagem ganhou, o servidor irá encaminhar para todos os clientes uma mensagem informando o IP e porta do ganhador e irá esperar por 1 minuto até iniciar um novo sorteio.