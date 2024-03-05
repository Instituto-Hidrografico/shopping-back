# _Shopping_
![github](https://img.shields.io/github/stars/gadelhati/shopping?style=social "Github")
![java](https://img.shields.io/badge/java-19-2145E8 "Java")
![postgresql](https://img.shields.io/badge/postgresql-15.1.1-6495ED "PostgreSQL")
![springboot](https://img.shields.io/badge/springboot-3.0.1-53D05D "Spring Boot")

### Necessary knowledge:
<a href="https://www.java.com" target="_blank">
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="25" height="25"/>
</a>
<a href="https://www.postgresql.org" target="_blank">
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postgresql/postgresql-original-wordmark.svg" alt="postgresql" width="25" height="25"/>
</a>
<a href="https://spring.io/" target="_blank">
    <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="25" height="25"/>
</a>
<a href="https://heroku.com" target="_blank">
    <img src="https://www.vectorlogo.zone/logos/heroku/heroku-icon.svg" alt="heroku" width="25" height="25"/>
</a>

### Required downloads:
|     name     | source |                 file name version | link for download                                                                   |
|:------------:|:------:|----------------------------------:|:------------------------------------------------------------------------------------|
|  `intellij`  |  IDE   |               idealC-2022.3.1.exe | https://download-cdn.jetbrains.com/idea/ideaIC-2022.3.1.exe                         |
|    `java`    |  JDK   |        jdk-19_windows-x64_bin.exe | https://download.oracle.com/java/19/latest/jdk-19_windows-x64_bin.exe               |
| `postgresql` |  SGBD  | postgresql-15.1.1-windows-x64.exe | https://get.enterprisedb.com/postgresql/postgresql-15.1-1-windows-x64.exe           |
|  `pgadmin4`  |        |             pgadmin4-6.19-x64.exe | https://ftp.postgresql.org/pub/pgadmin/pgadmin4/v6.19/windows/pgadmin4-6.19-x64.exe |

### Description
CRUD service from a shopping table.

### Roadmap
#### in development
- [ ] add food purchase flow
- [ ] change application.properties to [dev using h2, and prod using postgres]
#### in concept
- [ ] service to provide color palete
- [ ] add Internationalization to ValidationMessages.properties
- [ ] improve refresh token

## Summary
* [How to work with this project](#how-to-work-with-this-project)
  - [how to create this project](#how-to-create-this-project)
  - [how to clone the project and build locally](#how-to-clone-the-project-and-build-locally)
  - [how to install dependencies for this project](#how-to-install-dependencies-for-this-project)
  - [how to run project](#how-to-run-project)
  - [how to stop application on localhost](#how-to-stop-application-on-localhost)
  - [how to create file war](#how-to-create-file-war)
  - [how to select page on get request](#how-to-select-page-on-get-request)
* [How to deploy on Tomcat Server](#how-to-deploy-on-tomcat-server)
* [Features](#features)
* [HTTP Status code list](#http-status-code-list)
* [Developers](#developers)
* [Licence](#licence)

## Example
> [example](https://github.com/teddysmithdev/pokemon-review-springboot)

## How to work with this project
Type in intellij terminal tab

### how to create this project
> [https://start.spring.io/](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.0.2&packaging=war&jvmVersion=19&groupId=br.eti.gadelha&artifactId=shopping&name=shopping&description=Gadelha's%20Spring%20Boot%20Project&packageName=br.eti.gadelha.shopping&dependencies=lombok,h2,security,data-jpa,postgresql,actuator,validation)

### how to clone the project and build locally
```
git clone http://localhost:3120/shopping/food
```

### how to install dependencies for this project
```
mvn dependency:copy-dependencies
```

### how to run project
```
mvn spring-boot:run
```

### how to stop application on localhost
```
netstat -a -n -o
tskill "NÚMERO DO PID"
```

### how to create file war
```
mvn clean package
```
two files with the extension .war will be created, the one with the shortest name will be used.

### how to select page on get request
```
{{shopping-local}}/food/?page=2&size=5
{{shopping-local}}/food/?sort=name,desc
```

## How to deploy on Tomcat Server
Type in your linux server
```
service tomcat stop
rm /opt/tomcat/webapps/<old_version>.war
rm -Rfv /opt/tomcat/webapps/<old_version>
cp /home/<user>/<application_name>.war /opt/tomcat/webapps/
chown tomcat:tomcat /opt/tomcat/webapps/<application_name>.war
chmod 755 <application_name>
service tomcat start
```

## Features
These are the paths to services:
- [x] [CREATE](http://localhost:3119/food) - path to item creation;
- [x] [RETRIEVE](http://localhost:3119/food/id) - path to retrieve of an item by id;
- [x] [RETRIEVE](http://localhost:3119/food/search) - path to retrieve of an item by search or all items without source;
- [x] [UPDATE](http://localhost:3119/food/id) - path to update an item;
- [x] [DELETE](http://localhost:3119/food/id) - path to delete an item;
- [x] [DELETE_ALL](http://localhost:3119/food) - path to delete all items;

## HTTP Status code list
> [HHTP Status Code](https://httpstatuses.com/)

## Developers
> [Gadelha TI](https://github.com/gadelhati)
> [Lucas](https://github.com/lucassmartins)

## Licence
> [MIT License](https://choosealicense.com/licenses/mit/)
```
MIT License

Copyright (c) 2020 Jason Watmore

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```