#!/bin/bash

#  Instala bridge-utils
# sudo yum install -y bridge-utils

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


# Reinicia o serviço de rede
sudo systemctl restart network
sudo ip route del default via 10.0.2.2 dev eth0

yum clean all
yum repolist

sudo tee /etc/yum.repos.d/adoptium.repo <<EOT
[adoptium]
name=Adoptium
baseurl=https://packages.adoptium.net/artifactory/rpm/centos/7/x86_64/
enabled=1
gpgcheck=1
gpgkey=https://packages.adoptium.net/artifactory/api/gpg/key/public
EOT

sudo yum update -y

sudo yum install -y temurin-17-jdk


 
sudo yum install -y yum-utils
sudo yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
sudo yum install -y docker-ce docker-ce-cli containerd.io
sudo systemctl start docker
sudo systemctl enable docker
sudo curl -L "https://github.com/docker/compose/releases/download/1.25.5/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
sudo ln -s /usr/local/bin/docker-compose /usr/bin/docker-compose
systemctl daemon-reload
systemctl restart docker