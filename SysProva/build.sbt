name := "SysProva"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(  
  javaJpa,  
  javaEbean,
  "mysql" % "mysql-connector-java" % "5.1.26",
  "org.hibernate"  %  "hibernate-entitymanager"  %  "3.6.9.Final",
   "net.sf.jasperreports" % "jasperreports"  % "5.5.0",
  "com.lowagie" % "itext" % "2.1.7",
  cache
)     

play.Project.playJavaSettings
