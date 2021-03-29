curl -fsSL https://get.docker.com | bash -s docker --mirror Aliyun

yum remove docker \
docker-client \
docker-client-latest \
docker-common \
docker-latest \
docker-latest-logrotate \
docker-logrotate \
docker-engine

yum-config-manager \
--add-repo \
http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo

yum install docker-ce docker-ce-cli containerd.io

list docker-ce --showduplicates | sort -r

systemctl start docker

docker run hello-world

docker run -d -p 8082:8082 test-docker

## Windows install docker
https://hub.docker.com/editions/community/docker-ce-desktop-windows
https://docs.microsoft.com/zh-cn/windows/wsl/install-win10

{
"registry-mirrors": [
"https://registry.docker-cn.com",
"https://docker.mirrors.ustc.edu.cn",
"http://hub-mirror.c.163.com",
"https://mirror.baidubce.com"
],
"insecure-registries": [],
"debug": false,
"experimental": false,
"features": {
"buildkit": true
}
}

minikube start  image-mirror-country='cn' --registry-mirror=https://registry.docker-cn.com  --memory=4096 
--image-repository=registry.cn-hangzhou.aliyuncs.com/google_containers


kubectl create deployment hello-minikube --image=hello-world:latest
