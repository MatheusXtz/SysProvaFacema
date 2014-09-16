name := "SysProva"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(  
  javaJpa,  
  javaEbean,
  "mysql" % "mysql-connector-java" % "5.1.26",
  "org.hibernate"  %  "hibernate-entitymanager"  %  "3.6.9.Final",
  cache
)     

play.Project.playJavaSettings
