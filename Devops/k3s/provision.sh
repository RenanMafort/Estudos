#!/bin/bash


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
