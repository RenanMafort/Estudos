#!/bin/bash

# Comando para pegar arquivos da VM pro Host
# vagrant plugin install vagrant-scp

# vagrant status para ver o nome da maquina. por padrao é "defautl"
# vagrant scp vagrant@127.0.0.1:<caminho do arquivo> <caminho para colocar>

# Copiar da VM para o host
# vagrant ssh-config
# Host default
#   HostName 127.0.0.1
#   User vagrant
#   Port 2222
#   UserKnownHostsFile /dev/null
#   StrictHostKeyChecking no
#   PasswordAuthentication no
#   IdentityFile C:/docker/docker/.vagrant/machines/default/virtualbox/private_key
#   IdentitiesOnly yes
#   LogLevel FATAL
#   PubkeyAcceptedKeyTypes +ssh-rsa
#   HostKeyAlgorithms +ssh-rsa

#   scp -P 2222 -i <IdentityFile> vagrant@127.0.0.1:<caminho do arquivo> <caminho para colocar>
# caso der esse erro@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @    WARNING: REMOTE HOST IDENTIFICATION HAS CHANGED!     @
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# IT IS POSSIBLE THAT SOMEONE IS DOING SOMETHING NASTY!

# só usar o comando ssh-keygen -R [127.0.0.1]:2222

 scp -P 2222 -i "C:/Projetos/Renan/Docker com vagrant/.vagrant/machines/default/virtualbox/private_key" vagrant@127.0.0.1:/home/vagrant/renan-downloads/Apache-NetBeans-23-bin-windows-x64.exe

# Configurações de rede
echo > /etc/sysconfig/network-scripts/ifcfg-eth1
echo "DEVICE=eth1
TYPE=Ethernet
ONBOOT=yes
BRIDGE=br0" | sudo tee /etc/sysconfig/network-scripts/ifcfg-eth1

echo > /etc/sysconfig/network-scripts/ifcfg-br0
echo "DEVICE=br0
TYPE=Bridge
BOOTPROTO=dhcp
ONBOOT=yes
DELAY=0" | sudo tee /etc/sysconfig/network-scripts/ifcfg-br0

/home/vagrant/renan/downloads/glassfish-5.1.0.zip
# Reinicia o serviço de rede
sudo systemctl restart network
sudo ip route del default via 10.0.2.2 dev eth0

# Instala o docker
sudo yum install -y yum-utils
sudo yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
sudo yum install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin -y
sudo systemctl start docker
sudo systemctl enable docker

# export KUBECONFIG=/etc/rancher/k3s/k3s.yaml


# /etc/yum.repos.d/CentOS-Base.repo
[base]
name=CentOS-$releasever - Base
baseurl=http://vault.centos.org/7.9.2009/os/$basearch/
gpgcheck=1
gpgkey=file:///etc/pki/rpm-gpg/RPM-GPG-KEY-CentOS-7

[updates]
name=CentOS-$releasever - Updates
baseurl=http://vault.centos.org/7.9.2009/updates/$basearch/
gpgcheck=1
gpgkey=file:///etc/pki/rpm-gpg/RPM-GPG-KEY-CentOS-7

[extras]
name=CentOS-$releasever - Extras
baseurl=http://vault.centos.org/7.9.2009/extras/$basearch/
gpgcheck=1
gpgkey=file:///etc/pki/rpm-gpg/RPM-GPG-KEY-CentOS-7

[centosplus]
name=CentOS-$releasever - Plus
baseurl=http://vault.centos.org/7.9.2009/centosplus/$basearch/
gpgcheck=1
enabled=0
gpgkey=file:///etc/pki/rpm-gpg/RPM-GPG-KEY-CentOS-7
