#!/usr/bin/env bash

mvn clean package

echo 'Copy files...'

scp -i Mykey.pem jar_file.jar ubuntu@amazonaws

echo 'Copy Finished.'

ssh -i Mykey.pem ubuntu@amazonaws << EOF

pgrep java | sudo xargs kill -9
cd spring
nohup sudo java -jar jar_file.jar > log.txt &
EOF

echo 'Bye'