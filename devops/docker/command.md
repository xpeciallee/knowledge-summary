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