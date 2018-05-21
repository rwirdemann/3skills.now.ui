# 3skills.now

## Run in docker

### Build with maven

```bash
mvn package dockerfile:build
docker run -p 9090:9090 skillboost:latest
```

### Push to AWS docker registry
aws ecr get-login --no-include-email --region us-east-2
mvn package dockerfile:build

docker tag skillboost:latest 464797721797.dkr.ecr.us-east-2.amazonaws.com/skillboost:latest
docker push 464797721797.dkr.ecr.us-east-2.amazonaws.com/skillboost:latest