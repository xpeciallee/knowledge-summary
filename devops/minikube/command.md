user: mini
pw: minikube0


创建用户：

useradd mini

passwd mini 设置密码

su mini 切换用户
usermod -aG docker mini && newgrp docker

chmod u-w /etc/sudoers