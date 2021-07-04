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

redis-cli.exe -h 124.70.142.137 -p 6379

docker run -itd --name mysql-strive -p 3306:3306 -e MYSQL_ROOT_PASSWORD=strive123456

docker run --name=strive_mysql -e MYSQL_DATABASE=databases -e MYSQL_USER=root -e MYSQL_PASSWORD=strive@123 -e MYSQL_ROOT_PASSWORD=strive@123 -v /home/mysql_home:/var/lib/mysql -d mysql:5.7
docker run -itd --name mysql-test -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 mysql:5.7

docker run -d -p 10240:8080 -p 10241:50000 -v /var/jenkins_mount:/var/jenkins_home -v /etc/localtime:/etc/localtime --name myjenkins jenkins/jenkins


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
docker run --name any-artifactory -d -v data_artifactory:/var/opt/jfrog/artifactory -p 8081:8081 -p 8082:8082 docker.bintray.io/jfrog/artifactory-oss