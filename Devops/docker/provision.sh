#!/bin/bash

sudo yum install -y yum-utils
sudo yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
sudo yum install -y docker-ce docker-ce-cli containerd.io
sudo systemctl start docker
sudo systemctl enable docker




# sudo bash -c 'cat <<EOF > /etc/yum.repos.d/CentOS-Base.repo
# [base]
# name=CentOS-$releasever - Base
# baseurl=http://vault.centos.org/7.9.2009/os/$basearch/
# gpgcheck=1
# gpgkey=file:///etc/pki/rpm-gpg/RPM-GPG-KEY-CentOS-7

# [updates]
# name=CentOS-$releasever - Updates
# baseurl=http://vault.centos.org/7.9.2009/updates/$basearch/
# gpgcheck=1
# gpgkey=file:///etc/pki/rpm-gpg/RPM-GPG-KEY-CentOS-7

# [extras]
# name=CentOS-$releasever - Extras
# baseurl=http://vault.centos.org/7.9.2009/extras/$basearch/
# gpgcheck=1
# gpgkey=file:///etc/pki/rpm-gpg/RPM-GPG-KEY-CentOS-7

# [centosplus]
# name=CentOS-$releasever - Plus
# baseurl=http://vault.centos.org/7.9.2009/centosplus/$basearch/
# gpgcheck=1
# enabled=0
# gpgkey=file:///etc/pki/rpm-gpg/RPM-GPG-KEY-CentOS-7
# EOF'


