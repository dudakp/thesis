#!/usr/bin/env zsh

mvn clean install -Dspring-boot.run.profiles=prod
docker stop thesis-spring
docker rm thesis-spring
docker build -t dudak/thesis .
docker run -d -p 8081:8081 --name thesis-spring --network=dudak dudak/thesis
echo "Dockerizing app complete!"
