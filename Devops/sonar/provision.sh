#!/bin/bash

#Att in Repo
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

useradd sonar
yum install wget unzip java-11-openjdk-devel -y
wget https://binaries.sonarsource.com/Distribution/sonarqube/sonarqube-9.1.0.47736.zip
unzip sonarqube-9.1.0.47736.zip -d /opt/
mv /opt/sonarqube-9.1.0.47736 /opt/sonarqube
chown -R sonar:sonar /opt/sonarqube
touch /etc/systemd/system/sonar.service

echo > /etc/systemd/system/sonar.service
cat <<EOT >> /etc/systemd/system/sonar.service
[Unit]
Description=Sonarqube service
After=syslog.target network.target
[Service]
Type=forking
ExecStart=/opt/sonarqube/bin/linux-x86-64/sonar.sh start
ExecStop=/opt/sonarqube/bin/linux-x86-64/sonar.sh stop
User=sonar
Group=sonar
Restart=always
[Install]
WantedBy=multi-user.target
EOT
systemctl daemon-reload
service sonar start

#Instalar o sonar scanner
wget https://binaries.sonarsource.com/Distribution/sonar-scanner-cli/sonar-scanner-cli-4.6.2.2472-linux.zip
sudo unzip sonar-scanner-cli-4.6.2.2472-linux.zip -d /opt/sonar-scanner
chown -R sonar:sonar /opt/sonar-scanner
echo 'export PATH=$PATH:/opt/sonar-scanner/bin' | sudo tee -a /etc/profile
curl -sL https://rpm.nodesource.com/setup_10.x | sudo bash - 
sudo yum install nodejs -y