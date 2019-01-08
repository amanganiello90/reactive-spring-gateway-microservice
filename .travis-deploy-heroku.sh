#!/bin/bash

npm install -g heroku-cli && heroku plugins:install heroku-cli-deploy && heroku deploy:jar target/gateway.jar --app gateway-app

