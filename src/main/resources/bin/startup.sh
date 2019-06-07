#!/bin/sh
# Change this to your JDK installation root
#
# JAVA_HOME=/usr/java/jdk1.6.0_18

JAVA=java

SCRIPT_DIR=$(cd "$(dirname "$0")"; pwd)
BASE_DIR=${SCRIPT_DIR}/..

#LOG4J_ENV="-Dlog4j.configuration=file:configs/log4j2.xml"
#QUARTZ_ENV="-Dorg.quartz.properties=configs/quartz.properties"

#echo "log4j:$LOG4J_ENV"
#echo "quartz:$QUARTZ_ENV"

#$JAVA -classpath $LOG4J_ENV $QUARTZ_ENV -jar $BASE_DIR/twsihan-quartz-mybatis-examples.jar
$JAVA -jar $BASE_DIR/twsihan-quartz-mybatis-examples.jar
