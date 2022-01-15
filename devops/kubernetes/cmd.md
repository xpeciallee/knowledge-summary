```
minikube start
minikube dashboard
http://127.0.0.1:52150/api/v1/namespaces/kubernetes-dashboard/services/http:kubernetes-dashboard:/proxy/#/workloads?namespace=default

ConfigMap
Secret: DB User/DB Pwd
Mongodb  Exppress(External Service) -> Mongodb(Internal Service)

Create Secret:  kubectl apply -f secret.yaml
kubectl apply -f configMap.yaml
kubectl apply -f mongo-express.yaml
minikube service mongodb-express-service
```
