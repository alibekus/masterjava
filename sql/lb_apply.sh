export LB_HOME=/opt/liquibase
source $LB_HOME/liquibase --driver=org.postgresql.Driver \
  --classpath=$LB_HOME/lib \
  --changeLogFile=databaseChangeLog.sql \
  --url="jdbc:postgresql://localhost:5432/masterjava" \
  --username=masterjava \
  --password=masterjava \
  migrate
