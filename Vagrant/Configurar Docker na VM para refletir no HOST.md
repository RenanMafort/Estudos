 # 1- Verifique o Arquivo /etc/docker/daemon.json
Certifique-se de que o arquivo contém apenas:

{
  "hosts": ["tcp://0.0.0.0:2375", "unix:///var/run/docker.sock"]
}

# 2- Modifique o Arquivo de Unidade do Docker
O Docker já tem -H fd:// configurado no arquivo de unidade (docker.service), que está causando conflito com o daemon.json.
Edite o arquivo de unidade:

**sudo vi /usr/lib/systemd/system/docker.service**

Localize a linha que contém:

**ExecStart=/usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock**

Altere para:

**ExecStart=/usr/bin/dockerd --containerd=/run/containerd/containerd.sock**

# 3- Recarregue as Configurações do systemd

Depois de editar o arquivo, recarregue as configurações:



**sudo systemctl daemon-reload**

# 4- Reinicie o Serviço do Docker

Reinicie o Docker:

**sudo systemctl restart docker**

# 5- Teste se Está Funcionando

Depois que o serviço iniciar, teste novamente se o Docker responde do HOST pra VM :

curl http://<IP_DA_VM>:2375/version

Para conseguir o IP da VM:
**ip addr show**
Procure pela interface de rede usada para comunicação com o host (geralmente eth0 ou similar) e identifique o endereço IP ao lado de inet. Ele deve ter um formato como 192.168.x.x ou similar.

Exemplo de saída:

2: eth0: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc fq_codel state UP group default qlen 1000
    inet 192.168.56.101/24 brd 192.168.56.255 scope global dynamic eth0
       valid_lft 86400sec preferred_lft 86400sec

       
Aqui, o IP da máquina virtual é 192.168.56.101.

Testar conectividade com o Docker
Certifique-se de que o Docker está rodando na VM. Você pode verificar com:

sudo systemctl status docker
Se o serviço não estiver ativo, inicie-o:

sudo systemctl start docker

# 6- Baixar o [Docker CLI](https://download.docker.com/win/static/stable/x86_64/) para usar os comandos docker do HOST para refletir na VM

Extrair o arquivo baixado, usar o CMD para executar o docker.exe

# 7- Configurar as enviroments no intellij para usar o docker na VM
![image](https://github.com/user-attachments/assets/e68da5fa-7f29-4e8d-9273-10f34a21ec97)


