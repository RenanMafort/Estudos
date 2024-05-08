```yaml
# GIT INIT

# GIT CLONE

# GIT STATUS

# GIT ADD .

# GIT COMMIT -A -M "....."

# - USADO PARA MOVER OU RENOMEAR
GIT MV

# - REMOVE ARQUIVO OU DIRETÓRIO
GIT RM / GIT RM -R 

# - VOLTA TUDO AO ESTADO INICIAL
GIT RESET -- HARD <REPO>

# - VOLTA O ARQUIVO AO ESTADO INICIAL
GIT CHECKOUT <ARQUIVO>

# - CRIA UMA BRANCH E TROCA AO MESMO TEMPO
GIT CHECKOUT -B <NOME_BRANCH>

# - TROCA PARA A BRANCH ESCOLHIDA
GIT CHECKOUT <NOME_BRANCH>

# - MESCLA BRANCHES
GIT MERGE

# - DESFAZ E SALVA AS IMPLEMENTAÇÕES PARA SER RECUPERADAS DEPOIS
GIT STASH

# - MOSTRA AS STASHES CRIADAS
GIT STASH LIST

# - RECUPERA A STASH
GIT STASH APPLY <NUMERO-STASH>

# - MOSTRA AS ALTERAÇÕES FEITAS NAS STASHES
GIT STASH SHOW -P <NUMERO_STASH>

# - EXCLUI A STASH
GIT STASH DROP <NUMERO_STASH>

# - LIMPA TODAS AS STASHES
GIT STASH CLEAR 

# - CRIA UMA TAG
GIT TAG -A 'NOME' -M 'MENSAGEM'

# - LISTA AS TAGS CRIADAS
GIT TAG

# - DETALHA AS ALTERAÇÕES DAS TAGS
GIT SHOW <NOME_TAG>

# - TROCA DE TAG
GIT CHECKOUT <NOME_TAG>

# - ENVIA A TAG PARA O REPOSITÓRIO
GIT PUSH <REPO> <NOME_TAG>

# - ENVIA TODAS AS TAGS PARA O REPOSITÓRIO
GIT PUSH <REPO> --TAGS

# - DELETA UMA TAG
GIT TAG -D <NOME_TAG>

# - ATUALIZA TODAS AS BRANCHES E TAGS DO REPOSITÓRIO PARA O LOCAL
GIT FETCH

# - BAIXA TODAS AS BRANCHES
GIT FETCH -A

# - VERIFICA OS REMOTES
 GIT REMOTE -V

# - REMOVE O REMOTE COM REPOSITÓRIO
GIT REMOTE RM <REPO>

# - VERIFICA OS MÓDULOS
GIT SUBMODULE

# - ADICIONA O REPOSITÓRIO MÓDULO
GIT SUBMODULE ADD <REPO>

# - PUSH NO MÓDULO
GIT PUSH --RECURSE-SUBMODULES=ON-DEMAND 

# - DIFERENÇA DA BRANCH ATUAL PARA A BRANCH REMOTA
GIT DIFF

# - DIFERENÇA DE DOIS ARQUIVOS
GIT DIFF <ARQUIVO_A> <ARQUIVO_B>

# - LOG RESUMIDO DE TUDO O QUE ACONTECEU
GIT SHORTLOG

# - FAZ COM QUE O ARQUIVO NÃO SEJA RASTREADO PELO GIT
GIT UPDATE-INDEX --ASSUME-UNCHANGED <FILE>

# - DESFAZ O COMANDO ACIMA
GIT UPDATE-INDEX --NO-ASSUME-UNCHANGED <FILE>


#  - PARA OBTER UMA LISTA DE ARQUIVOS / ARQUIVOS QUE SÃO ASSUME-UNCHANGED EXECUTE ISSO EM UM SHELL UNIX:
GIT LS-FILES -V | GREP '^H'

# - OU EM UM POWERSHELL:
GIT LS-FILES -V | SELECT-STRING -CASESENSITIVE '^H'

# SERVE PARA ALTERAR UM COMMIT
# Existem 3 situações diferentes, que vão ficando cada vez mais complexas:

# Editar o último commit local - ANTES DO PUSH:
O git commit --amend # vai abrir seu editor, com o conteúdo da mensagem do último commit e você pode editar tranquilamente.

# Editar commits mais antigos - ANTES DO PUSH:
# Você vai precisar fazer um rebase do seu histórico, que é mais complexo que o processo anterior:

git rebase -i HEAD~3 # Mostra a lista dos 3 últimos commits
# A lista vai ser mais ou menos assim:

pick e499d89 Delete CNAME
pick 0c39034 Better README
pick f7fde4a Change the commit message but push the same commit.

# Rebase 9fdb3bd..f7fde4a onto 9fdb3bd
#
# Commands:
#  p, pick = use commit
#  r, reword = use commit, but edit the commit message
#  e, edit = use commit, but stop for amending
#  s, squash = use commit, but meld into previous commit
#  f, fixup = like "squash", but discard this commit's log message
#  x, exec = run command (the rest of the line) using shell
#
# These lines can be re-ordered; they are executed from top to bottom.
#
# If you remove a line here THAT COMMIT WILL BE LOST.
#
# However, if you remove everything, the rebase will be aborted.
#
# Note that empty commits are commented out
# Altere pick para reword nos commits que você quer editar a mensagem:

pick e499d89 Delete CNAME
reword 0c39034 Better README
reword f7fde4a Change the commit message but push the same commit.
# Salve e feche o arquivo. Depois disso o git vai abrir cada um dos commits marcados com reword para edição. Edite as mensagens, salve e feche.

# Alterar os commits DEPOIS DO PUSH
# Antes de mais nada, isso é altamente não recomendado.
# Isso pode quebrar o respositório e dar muito trabalho.
# 99.9% das vezes é melhor deixar o commit errado.

# Para alterar o histórico depois do push, basta seguir um dos passos acima e depois executar:

git push --force
```

