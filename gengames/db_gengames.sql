use db_gengames;

insert into tb_categoria (nome, descricao) values ("Ação", "Descrição do gênero ação!");
insert into tb_categoria (nome, descricao) values ("Aventura", "Descrição do gênero aventura!");
insert into tb_categoria (nome, descricao) values ("FPS", "Descrição do gênero FPS!");
insert into tb_categoria (nome, descricao) values ("RPG", "Descrição do gênero RPG!");
insert into tb_categoria (nome, descricao) values ("Sobrevivencia", "Descrição do gênero Sobrevivencia!");

insert into tb_produto (nome, descricao, preco, qtde, categoria_id) values ("Guild Wars 2", "Jogo do tipo MMORPG", 99.99, 5, 4);
insert into tb_produto (nome, descricao, preco, qtde, categoria_id) values ("Brawl Stars", "Jogo do tipo FPS", 0, 0, 3);
insert into tb_produto (nome, descricao, preco, qtde, categoria_id) values ("Valorant", "ogo do tipo FPS", 150.99, 100, 3);
insert into tb_produto (nome, descricao, preco, qtde, categoria_id) values ("New World", "Jogo do tipo MMORPG", 50, 50, 4);
insert into tb_produto (nome, descricao, preco, qtde, categoria_id) values ("No Man's Sky", "Jogo do tipo RPG ", 200, 25, 4);

select * from tb_categoria;

select * from tb_produto;