http://nodejs.cn/download/

mkdir node_global
mkdir node_cache
npm config set prefix "C:\Program Files\nodejs\node_global"
npm config set cache "C:\Program Files\nodejs\node_cache"
npm install -g cnpm --registry=https://registry.npm.taobao.org