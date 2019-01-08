# reactive-spring-gateway-microservice [![Build Status](https://travis-ci.org/amanganiello90/reactive-spring-gateway-microservice.svg)](https://travis-ci.org/amanganiello90/reactive-spring-gateway-microservice)

<img src="https://img.shields.io/github/forks/amanganiello90/reactive-spring-gateway-microservice.svg">&nbsp;
<img src="https://img.shields.io/github/stars/amanganiello90/reactive-spring-gateway-microservice.svg">&nbsp;<a href="https://github.com/amanganiello90/reactive-spring-gateway-microservice/issues"><img src="https://img.shields.io/github/issues/amanganiello90/reactive-spring-gateway-microservice.svg">
</a>&nbsp;<img src="https://img.shields.io/github/license/amanganiello90/reactive-spring-gateway-microservice.svg">&nbsp;<img src="https://img.shields.io/github/downloads/amanganiello90/reactive-spring-gateway-microservice/total.svg">&nbsp;

> A Spring boot reactive 5 microservice gateway that uses [spring cloud gateway](https://spring.io/projects/spring-cloud-gateway). It routes any requests adding a basic authorization and removing any tokens using a custom filter (_AddBasicAuthHeader_). You have only to configure the **endpoints variables** in the **src/main/resources/application.yml** file.



|Please donate whether you wish support us to give more time to app's growth | [![](https://www.paypal.com/en_US/IT/i/btn/btn_donateCC_LG.gif)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=XTC895QYD28TC) |
|:------------------------------------------------------------------------------|:------------------------------------------------------------------------------------------------------------------------------------------------------|


### News ###

* Development 1.0-SNAPSHOT first version

Jenuary 02,2018  | **Release 1.0** | available from  **[GITHUB REPO](https://github.com/amanganiello90/reactive-spring-gateway-microservice/archive/develop.zip)**  |
---- | ---- | ---- |


## NEXT DEVELOPMENTS (checked in progress)

- [ ] Add spring-boot-actuator
- [ ] Explain more and better on README.md
- [ ] testing and replace endpoints
- [ ] remove access_token and id_token in custom filter
- [ ] create a spring boot starter with module microservice structure


### How it works


### How to configure

YOUR-YAML-CONFIGURATION-FOLDER-PATH/application.yml:

```
 
gateway:
  remote:
    url: YOUR_REMOTE_URL_TO_REDIRECT
  basic:
    auth:
      username: YOUR_BASIC_AUTH_USER
      password: YOUR_BASIC_AUTH_PASSWORD

```


### How to run

```
java -jar reactive-spring-gateway-microservice-1.0-SNAPSHOT.jar --spring.config.location=classpath:/,file:YOUR-YAML-CONFIGURATION-FOLDER-PATH

```
