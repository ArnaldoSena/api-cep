# API-CEP

Api que busca ceps em http://viacep.com.br e cadastra no Postgres

# Containers Dockers 

O primeiro passo a ser realizado é a configuração dos containers dockers do projeto.
Para isso é necessário executar o comando abaixo na raíz do projeto.

    $ docker-compose up -d

O comando acima irá configurar todos os containers utilizados pela aplicação. Os containers são:

* Postgres
