#!/bin/sh
mvn package dockerfile:build
docker tag instantfoo:latest 206.189.114.248:5000/instantfoo:latest
docker push 206.189.114.248:5000/instantfoo:latest