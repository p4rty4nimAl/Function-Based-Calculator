javac -d out/ -cp . tk/p4rty/Main.java
cd out
"C:\Program Files\Eclipse Adoptium\jdk-17.0.1.12-hotspot\bin\jar.exe" cmf fbc.mf FBC.jar tk/*
move FBC.jar ../FBC.jar
cd ../
cmd java -jar FBC.jar
