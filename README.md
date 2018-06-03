# 3skills.now

## Run in docker

### Build with maven

```bash
mvn package dockerfile:build
docker run -p 9090:9090 instantfoo:latest
```

206.189.118.85

### Start docker registry on digital ocean
ssh root@206.189.118.85
docker run -d -p 5000:5000 --name registry registry:2

### Push to digital ocean docker registry
mvn package dockerfile:build
docker tag instantfoo:latest 206.189.118.85:5000/instantfoo:latest
docker push 206.189.118.85:5000/instantfoo:latest

### Run container on digitial ocean
ssh root@206.189.118.85
docker run --name instantfoo -d -p 9090:9090 localhost:5000/instantfoo:latest

### Push to AWS docker registry
aws ecr get-login --no-include-email --region us-east-2
mvn package dockerfile:build

docker tag instantfoo:latest 464797721797.dkr.ecr.us-east-2.amazonaws.com/instantfoo:latest
docker push 464797721797.dkr.ecr.us-east-2.amazonaws.com/instantfoo:latest