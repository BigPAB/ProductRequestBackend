# Getting Started

#About
O projeto é composto de 6 serviços que são os seguintes: config-service, register-service, proxy-service, 
client-service, product-service e request-service.
Cada um desses modulos é um projeto maven SpringBoot separado. Em modo geral, é um projeto criado
com java, spring boot, hibernate, jpa conexão banco com mysql

# Passos para rodar o projeto - Intellij
1- Ao abrir o intellij, clique em get project from version control
2- seletione git e coloque o link do repositório no campo url
3-Confirmar
4- Clique direito no arquivo pom.xml e em seguida clique em "Add as a maven project"
5-Execute o passo 4 em todos os modulos
6-Execute um maven clean e package em todos os modulos.
7-Crie uma database com o nome product-request, a nome do usuário para acessar seu banco deve ser "root", sem senha.
8-Conecte-se em uma rede que tenha acesso a internet porque o projeto consome os arquivos de
configuração que estão no git em um repositorio nomeado productRequest-cloud-config.
9-Rodar os serviços nessa ordem: config-service, registration-service, proxy-service e os demais
não precisam seguir uma ordem.
