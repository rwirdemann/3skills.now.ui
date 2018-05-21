#!/bin/sh
mvn package
mvn package dockerfile:build

docker tag skillboost:latest 464797721797.dkr.ecr.us-east-2.amazonaws.com/skillboost:latest
docker push 464797721797.dkr.ecr.us-east-2.amazonaws.com/skillboost:latest