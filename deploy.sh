#!/bin/bash

# Installs restprovider to liferay in vagrant machine

mvn clean package
sudo cp target/restprovider.war /opt/liferay/deploy
sudo chown liferay:liferay /opt/liferay/deploy/restprovider.war
