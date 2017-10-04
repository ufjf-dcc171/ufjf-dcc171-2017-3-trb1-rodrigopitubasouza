# ufjf-dcc171-2017-3-trb1-rodrigopitubasouza
ufjf-dcc171-2017-3-trb1-rodrigopitubasouza created by GitHub Classroom

*Nome: Rodrigo Pituba de Souza Matrícula: 201476037 Curso: Sistemas de Informação

*O sistema foi desenvolvido pensando em uma hambúrgueria, com um controle simples de pedidos por mesa.

*Modelo de dados utilizado:  https://drive.google.com/file/d/0ByweASNzLOm7QkcxYTRLcEFUQkk/view

*Levantamento dos campos necessários para a construção das telas; Para a tela inicial, é fundamental selecionar o número da mesa, o status do pedido (visto que este só poderia ser editado caso estiver aberto), digitar a mão o horário de abertura e de seu fechamento, ou seja, os itens que foram solicitados pelos clientes do sistema, para tela de itens é necessário selecionar qual o item será adicionado ao pedido e em caso de novos itens adicionar seu nome e valor nos campos a esquerda.

*Descrição sucinta dos pontos importantes do funcionamento da interface; A interface funciona em três janelas. Sendo a primeira a principal e responsável por fechar o programa, temos os botões para controlar as ações (adicionar, editar e excluir), um botão para gerar uma “Nota Fiscal”. Utilizei o JPanel para incluir as informações e JScrollPane para listar os pedidos,itens e compras feitas e em sua maioria do BorderLayout e GridLayout para organizar.

*Discussão dos pontos que apresentaram maior dificuldade de implementação A formatação da hora; Edição dos pedidos - se não houver mais de um, pode haver problemas de seleção pois não foi possível utilizar o clearSelection na lista de pedidos, a seleção do layout da lista de mesas foi difícil para a criação do sistema

*Pontos onde podem ser realizadas melhorias futuras Deixar a inclusão de novos itens (classes) melhor estruturada., não ser necessário digitar a hora, o layout responsivo, persistência dos dados, utilização de banco de dados.
