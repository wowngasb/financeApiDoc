@ECHO OFF
jar cvf HttpApi.jar com/test/HttpApi.class

SET CLASSPATH=.;lib\commons-lang-2.4.jar;lib\commons-logging-1.1.1.jar;lib\ezmorph-1.0.6.jar;lib\json-lib-0.9.jar;lib\commons-beanutils-1.8.2.jar;lib\httpclient-4.2.5.jar;lib\httpcore-4.2.4.jar;HttpApi.jar

scala Test

PAUSE